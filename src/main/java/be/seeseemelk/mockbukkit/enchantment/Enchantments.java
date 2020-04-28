package be.seeseemelk.mockbukkit.enchantment;

import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

public class Enchantments
{

    public static void registerAllEnchantmentMocks()
    {
        try
        {
            Field[] enchants = Enchantment.class.getDeclaredFields();
            //noinspection unchecked
            for (Field enchant : enchants)
            {
                if (enchant.getType() != Enchantment.class)
                {
                    continue;
                }
                enchant.setAccessible(true);
                Enchantment enchantmentWrapper = (Enchantment) enchant.get(null);
                BasicEnchantment enchantment = new BasicEnchantment(enchantmentWrapper.getKey().getKey());
                Enchantment.registerEnchantment(enchantment);
            }
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }

        Enchantment.stopAcceptingRegistrations();
    }

    public static void unregisterAll()
    {
        try
        {
            Field byKey = Enchantment.class.getDeclaredField("byKey");
            Field byName = Enchantment.class.getDeclaredField("byName");

            byKey.setAccessible(true);
            byName.setAccessible(true);

            ((Map<?, ?>) byName.get(null)).clear();
            ((Map<?, ?>) byKey.get(null)).clear();

            Field acceptingNew = Enchantment.class.getDeclaredField("acceptingNew");
            acceptingNew.setAccessible(true);
            acceptingNew.set(null, true);

            System.out.println(Arrays.toString(Enchantment.values()));
        }
        catch (NoSuchFieldException | IllegalAccessException e)
        {
            e.printStackTrace();
        }

    }
}
