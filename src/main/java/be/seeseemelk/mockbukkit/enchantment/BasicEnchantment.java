package be.seeseemelk.mockbukkit.enchantment;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class BasicEnchantment extends Enchantment
{

    private final String name;

    public BasicEnchantment(String name, NamespacedKey id)
    {
        super(id);
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int getMaxLevel()
    {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getStartLevel()
    {
        return 0;
    }

    @Override
    public EnchantmentTarget getItemTarget()
    {
        return EnchantmentTarget.ALL;
    }

    @Override
    public boolean isTreasure()
    {
        return false;
    }

    @Override
    public boolean isCursed()
    {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment other)
    {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack item)
    {
        return true;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof BasicEnchantment)) return false;
        if (!super.equals(o)) return false;

        BasicEnchantment that = (BasicEnchantment) o;

        return Objects.equals(getKey(), that.getKey());
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + getKey().hashCode();
        return result;
    }
}
