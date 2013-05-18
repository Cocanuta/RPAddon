package hac.RPAddon.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBranch extends Item {

	public ItemBranch(int id) {
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName("itemBranch");
	}

	@Override

	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("RPAddon:itemBranch");
	}
}
