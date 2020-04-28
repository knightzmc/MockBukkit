package be.seeseemelk.mockbukkit.enchantment;

import be.seeseemelk.mockbukkit.MockBukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EnchantmentTest
{

    @Before
    public void setUp()
    {
        MockBukkit.mock();
    }

    @After
    public void tearDown()
    {
        if (MockBukkit.isMocked())
        {
            MockBukkit.unload();
        }
    }

    @Test
    public void enchantmentMocks_assertFullyWorking()
    {
        for (Enchantment e : Enchantment.values())
        {
            e.getMaxLevel(); //Make sure no NPEs
        }
        new ItemStack(Material.STONE).addEnchantment(Enchantment.ARROW_FIRE, 3);
    }
}
