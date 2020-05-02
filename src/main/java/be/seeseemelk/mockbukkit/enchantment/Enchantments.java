package be.seeseemelk.mockbukkit.enchantment;

import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;
import java.util.Map;

public class Enchantments
{

    private static boolean isRegistered = false;

    public static void registerAllEnchantmentMocks()
    {
        if (isRegistered)
        {
            return;
        }
        try
        {
            Field[] enchants = Enchantment.class.getDeclaredFields();
            for (Field enchant : enchants)
            {
                if (enchant.getType() != Enchantment.class)
                {
                    continue;
                }
                enchant.setAccessible(true);
                Enchantment enchantmentWrapper = (Enchantment) enchant.get(null);
                BasicEnchantment enchantment = new BasicEnchantment(enchant.getName().toLowerCase(), enchantmentWrapper.getKey());
                Enchantment.registerEnchantment(enchantment);
            }
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        finally
        {
            isRegistered = true;
            Enchantment.stopAcceptingRegistrations();
        }
    }

    public static void unregisterAll()
    {
        try
        {
            Field byId = Enchantment.class.getDeclaredField("byKey");
            Field byName = Enchantment.class.getDeclaredField("byName");

            byId.setAccessible(true);
            byName.setAccessible(true);

            ((Map<?, ?>) byName.get(null)).clear();
            ((Map<?, ?>) byId.get(null)).clear();

            Field acceptingNew = Enchantment.class.getDeclaredField("acceptingNew");
            acceptingNew.setAccessible(true);
            acceptingNew.set(null, true);

            isRegistered = false;
        }
        catch (NoSuchFieldException | IllegalAccessException e)
        {
            e.printStackTrace();
        }

    }
}
