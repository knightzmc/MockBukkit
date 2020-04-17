package be.seeseemelk.mockbukkit.enchantment;

import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;

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
                BasicEnchantment enchantment = new BasicEnchantment(enchant.getName().toLowerCase(), enchantmentWrapper.getId());
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
}
