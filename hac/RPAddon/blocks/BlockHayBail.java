package hac.RPAddon.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ibxm.Player;
import hac.RPAddon.Common.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockHayBail extends Block
{

	@SideOnly(Side.CLIENT)
    private Icon top;
    @SideOnly(Side.CLIENT)
    private Icon side;

		public BlockHayBail (int id, Material material)
        {
                super(id, material);
                setCreativeTab(CreativeTabs.tabBlock);
                setHardness(1.0F);
                setUnlocalizedName("blockHayBail");
                
                
        }
		
		public Icon getIcon(int par1, int par2)
	    {
	        return par1 == 0 ? this.top : (par1 == 1 ? this.top : this.side);
	    }


		
		public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
        {
        	par5Entity.fallDistance = par5Entity.fallDistance * 0.2F;
        }
		
	    public void registerIcons(IconRegister par1IconRegister)
	    {
	        this.side = par1IconRegister.registerIcon("RPAddon:blockHayBailSide");
	        this.top = par1IconRegister.registerIcon("RPAddon:blockHayBailTop");
	    }

}