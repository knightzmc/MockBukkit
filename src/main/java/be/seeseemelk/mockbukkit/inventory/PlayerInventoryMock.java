package be.seeseemelk.mockbukkit.inventory;

import java.util.Arrays;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import be.seeseemelk.mockbukkit.UnimplementedOperationException;

public class PlayerInventoryMock extends InventoryMock implements PlayerInventory
{
	protected static final int HOTBAR = 0;
	protected static final int SLOT_BAR = 9;
	protected static final int BOOTS = 36;
	protected static final int LEGGINGS = 37;
	protected static final int CHESTPLATE = 38;
	protected static final int HELMET = 39;
	protected static final int OFF_HAND = 40;
	private int mainHandSlot = 0;

	public PlayerInventoryMock(HumanEntity holder, String name)
	{
		super(holder, name, 41, InventoryType.PLAYER);
	}

	@Override
	public HumanEntity getHolder()
	{
		return (HumanEntity) super.getHolder();
	}

	@Override
	public ItemStack[] getArmorContents()
	{
		return Arrays.copyOfRange(getContents(), BOOTS, BOOTS+4);
	}

	@Override
	public ItemStack[] getExtraContents()
	{
		return Arrays.copyOfRange(getContents(), OFF_HAND, OFF_HAND+1);
	}

	@Override
	public ItemStack getHelmet()
	{
		return getItem(HELMET);
	}

	@Override
	public ItemStack getChestplate()
	{
		return getItem(CHESTPLATE);
	}

	@Override
	public ItemStack getLeggings()
	{
		return getItem(LEGGINGS);
	}

	@Override
	public ItemStack getBoots()
	{
		return getItem(BOOTS);
	}

	@Override
	public void setArmorContents(ItemStack[] items)
	{
		if (items == null)
			throw new NullPointerException("ItemStack was null");
		else if (items.length > 4)
			throw new IllegalArgumentException("ItemStack array too large (max: 4, was: " + items.length + ")");
		items = (items.length == 4) ? items : Arrays.copyOf(items, 4);
		setItem(BOOTS, items[0]);
		setItem(LEGGINGS, items[1]);
		setItem(CHESTPLATE, items[2]);
		setItem(HELMET, items[3]);
	}

	@Override
	public void setExtraContents(ItemStack[] items)
	{
		if (items == null)
			throw new NullPointerException("ItemStack was null");
		else if (items.length > 1)
			throw new IllegalArgumentException("ItemStack array too large (max: 4, was: " + items.length + ")");
		items = (items.length == 1) ? items : Arrays.copyOf(items, 1);
		setItem(OFF_HAND, items[0]);
	}

	@Override
	public void setHelmet(ItemStack helmet)
	{
		setItem(HELMET, helmet);
	}

	@Override
	public void setChestplate(ItemStack chestplate)
	{
		setItem(CHESTPLATE, chestplate);
	}

	@Override
	public void setLeggings(ItemStack leggings)
	{
		setItem(LEGGINGS, leggings);
	}

	@Override
	public void setBoots(ItemStack boots)
	{
		setItem(BOOTS, boots);
	}

	@Override
	public ItemStack getItemInMainHand()
	{
		return getItem(SLOT_BAR + mainHandSlot);
	}

	@Override
	public void setItemInMainHand(ItemStack item)
	{
		setItem(SLOT_BAR + mainHandSlot, item);
	}

	@Override
	public ItemStack getItemInOffHand()
	{
		return getItem(OFF_HAND);
	}

	@Override
	public void setItemInOffHand(ItemStack item)
	{
		setItem(OFF_HAND, item);

	}

	@Deprecated
	@Override
	public ItemStack getItemInHand()
	{
		return getItemInMainHand();
	}

	@Deprecated
	@Override
	public void setItemInHand(ItemStack stack)
	{
		setItemInMainHand(stack);

	}

	@Override
	public int getHeldItemSlot()
	{
		return mainHandSlot;
	}

	@Override
	public void setHeldItemSlot(int slot)
	{
		if (slot < 0 || slot > 8)
			throw new ArrayIndexOutOfBoundsException("Slot should be within [0-8] (was: " + slot + ")");
		mainHandSlot = slot;
	}

}
