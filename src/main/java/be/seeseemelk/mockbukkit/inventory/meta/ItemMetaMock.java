package be.seeseemelk.mockbukkit.inventory.meta;

import be.seeseemelk.mockbukkit.UnimplementedOperationException;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

import static java.util.Objects.nonNull;

public class ItemMetaMock implements ItemMeta
{
    private String displayName = null;
    private List<String> lore = null;
    private Map<Enchantment, Integer> enchants = new HashMap<>();
    private Set<ItemFlag> hideFlags = EnumSet.noneOf(ItemFlag.class);
    private boolean unbreakable;

    public ItemMetaMock()
    {
    }


    public ItemMetaMock(ItemMeta meta)
    {
        this.displayName = meta.getDisplayName();
        if (meta.hasLore())
        {
            this.lore = new ArrayList<>(meta.getLore());
        }
        this.enchants = new HashMap<>(meta.getEnchants());
        this.hideFlags = new HashSet<>(meta.getItemFlags());
        this.unbreakable = meta.isUnbreakable();
    }

    public ItemMetaMock(ItemMetaMock meta)
    {
        this((ItemMeta) meta);
    }

    static boolean checkConflictingEnchants(Map<Enchantment, Integer> enchantments, Enchantment enchants)
    {
        if (enchantments != null && !enchantments.isEmpty())
        {
            Iterator<Enchantment> var2 = enchantments.keySet().iterator();

            Enchantment enchant;
            do
            {
                if (!var2.hasNext())
                {
                    return false;
                }

                enchant = var2.next();
            }
            while (!enchant.conflictsWith(enchants));
            return true;
        } else
        {
            return false;
        }
    }

    @Override
    public String toString()
    {
        return "ItemMetaMock{" +
                "displayName='" + displayName + '\'' +
                ", lore=" + lore +
                ", enchants=" + enchants +
                ", hideFlags=" + hideFlags +
                ", unbreakable=" + unbreakable +
                '}';
    }

    @Override
    public boolean hasDisplayName()
    {
        return nonNull(displayName);
    }

    @Override
    public String getDisplayName()
    {
        return displayName;
    }

    @Override
    public void setDisplayName(String name)
    {
        displayName = name;
    }

    /**
     * Checks if this items lore is equal to some other lore.
     *
     * @param meta The other item meta whose lore should be compared.
     * @return {@code true} if they are the same, {@code false} if they're not.
     */
    private boolean isLoreEquals(ItemMeta meta)
    {
        if (lore == null)
            return !meta.hasLore();
        else if (!meta.hasLore())
            return false;

        List<String> otherLore = meta.getLore();
        if (lore.size() == otherLore.size())
        {
            for (int i = 0; i < lore.size(); i++)
            {
                if (!lore.get(i).equals(otherLore.get(i)))
                    return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Checks if the display name of this item meta is equal to the display name of
     * another one.
     *
     * @param meta The other item meta to check against.
     * @return {@code true} if both display names are equal, {@code false} if
     * they're not.
     */
    private boolean isDisplayNameEqual(ItemMeta meta)
    {
        if (displayName != null)
        {
            if (meta.hasDisplayName())
                return displayName.equals(meta.getDisplayName());
            else
                return false;
        } else
        {
            return !meta.hasDisplayName();
        }
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
        result = prime * result + ((lore == null) ? 0 : lore.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof ItemMeta)
        {
            ItemMeta meta = (ItemMeta) obj;
            return isLoreEquals(meta) && isDisplayNameEqual(meta);
        } else
        {
            return false;
        }
    }

    @Override
    public ItemMetaMock clone()
    {
        try
        {
            ItemMetaMock meta = (ItemMetaMock) super.clone();
            meta.displayName = displayName;
            meta.lore = lore;
            return meta;
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
    }

    public Spigot spigot()
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public boolean hasLore()
    {
        return lore != null;
    }

    @Override
    public List<String> getLore()
    {
        return new ArrayList<>(lore);
    }

    @Override
    public void setLore(List<String> lore)
    {
        this.lore = new ArrayList<>(lore);
    }

    /**
     * Asserts if the lore contains the given lines in order.
     *
     * @param lines The lines the lore should contain
     */
    public void assertLore(List<String> lines)
    {
        if (lore != null && lore.size() == lines.size())
        {
            for (int i = 0; i < lore.size(); i++)
            {
                if (!lore.get(i).equals(lines.get(i)))
                {
                    throw new AssertionError(
                            String.format("Line %d should be '%s' but was '%s'", i, lines.get(i), lore.get(i)));
                }
            }
        } else if (lore != null)
        {
            throw new AssertionError(
                    String.format("Lore contained %d lines but should contain %d lines", lore.size(), lines.size()));
        } else
        {
            throw new AssertionError("No lore was set");
        }
    }

    /**
     * Asserts if the lore contains the given lines in order.
     *
     * @param lines The lines the lore should contain
     */
    public void assertLore(String... lines)
    {
        assertLore(Arrays.asList(lines));
    }

    /**
     * Asserts that the item meta contains no lore.
     *
     * @throws AssertionError if the item meta contains some lore.
     */
    public void assertHasNoLore() throws AssertionError
    {
        if (lore != null && lore.size() != 0)
        {
            throw new AssertionError("Lore was set but shouldn't have been set");
        }
    }

    /**
     * Used internally for the ItemFactoryMock. This code is based on
     * `CraftMetaItem#updateMaterial`
     *
     * @param material
     * @return
     */
    public Material updateMaterial(Material material)
    {
        return material;
    }

    @Override
    public Map<String, Object> serialize()
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public boolean hasLocalizedName()
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public String getLocalizedName()
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public void setLocalizedName(String name)
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public boolean hasEnchants()
    {
        return !enchants.isEmpty();
    }

    @Override
    public boolean hasEnchant(Enchantment ench)
    {
        return enchants.containsKey(ench);
    }

    @Override
    public int getEnchantLevel(Enchantment ench)
    {
        return hasEnchant(ench) ? enchants.get(ench) : 0;
    }

    @Override
    public Map<Enchantment, Integer> getEnchants()
    {
        return Collections.unmodifiableMap(enchants);
    }

    @Override
    public boolean addEnchant(Enchantment ench, int level, boolean ignoreLevelRestriction)
    {
        Integer existingLevel = this.enchants.get(ench);
        if (nonNull(existingLevel) && existingLevel.equals(level))
        {
            return false; // Already exists with the same level
        }

        if (ignoreLevelRestriction)
        {
            this.enchants.put(ench, level);
            return true;
        } else
        {
            // TODO Auto-generated method stub
            throw new UnimplementedOperationException();
        }
    }

    @Override
    public boolean removeEnchant(Enchantment ench)
    {
        return nonNull(this.enchants.remove(ench));
    }

    @Override
    public boolean hasConflictingEnchant(Enchantment ench)
    {
        boolean b = this.hasEnchants() && enchants.remove(ench) != null;
        if (enchants != null && enchants.isEmpty())
        {
            enchants = null;
        }

        return b;
    }

    @Override
    public void addItemFlags(ItemFlag... itemFlags)
    {
        hideFlags.addAll(Arrays.asList(itemFlags));
    }

    @Override
    public void removeItemFlags(ItemFlag... itemFlags)
    {
        hideFlags.removeAll(Arrays.asList(itemFlags));
    }

    @Override
    public Set<ItemFlag> getItemFlags()
    {
        return Collections.unmodifiableSet(hideFlags);
    }

    @Override
    public boolean hasItemFlag(ItemFlag flag)
    {
        return hideFlags.contains(flag);
    }

    @Override
    public boolean isUnbreakable()
    {
        return unbreakable;
    }

    @Override
    public void setUnbreakable(boolean unbreakable)
    {
        this.unbreakable = unbreakable;
    }

}
