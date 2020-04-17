package be.seeseemelk.mockbukkit.enchantment;

import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;

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
}
