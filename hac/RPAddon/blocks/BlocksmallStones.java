package hac.RPAddon.blocks;
import hac.RPAddon.RPAddon;

import java.util.Random;

import cpw.mods.fml.common.Mod.Item;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;


public class BlocksmallStones extends BlockContainer {

public BlocksmallStones(int id, Material material) {
super(id, material);
setCreativeTab(CreativeTabs.tabBlock);
float f = 0.3F;
this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 0.7F, 0.5F + f);
}

public int idDropped(int par1, Random par2Random, int par3)
{
return RPAddon.itemStoneChips.itemID;
}


/**
* The type of render function that is called for this block
*/
public int getRenderType()
{
return -2;
}

/**
* Is this block (a) opaque and (B) a full 1m cube? This determines whether or not to render the shared face of two
* adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
*/
public boolean isOpaqueCube()
{
return false;
}

/**
* If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
*/
public boolean renderAsNormalBlock()
{
return false;
}

public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
{
int rotation = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 2.5D) & 3;
world.setBlock(i, j, k, rotation - 1);
}

public TileEntity createNewTileEntity(World par1World)
{
return new TileEntitysmallStones();
}

public boolean canBlockStay(World par1World, int par2, int par3, int par4)
{
    if (par3 >= 0 && par3 < 256)
    {
        int l = par1World.getBlockId(par2, par3 - 1, par4);
        Block soil = Block.blocksList[l];
        return (l == Block.grass.blockID || par1World.getFullBlockLightValue(par2, par3, par4) < 13);
    }
    else
    {
        return false;
    }
}
public void registerIcons(IconRegister iconRegister)
{
         blockIcon = iconRegister.registerIcon("rpmod:blocksmallStones");
}

}