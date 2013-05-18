package hac.RPAddon;

import hac.RPAddon.Common.CommonProxy;
import hac.RPAddon.blocks.BlockHayBail;
import hac.RPAddon.blocks.BlocksmallStones;
import hac.RPAddon.blocks.TileEntitysmallStones;
import hac.RPAddon.items.ItemBranch;
import hac.RPAddon.items.itemAxeBasic;
import hac.RPAddon.items.itemStoneChips;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "RPAddon", name = "RPAddon", version = "0.01")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class RPAddon
{

	@Instance("RPAddon")
	public static RPAddon instance;

	//Materials
	public static EnumToolMaterial BasicMaterial = EnumHelper.addToolMaterial("Basic Material", 0, 59, 2.0F, 0, 15);
	
	//Blocks
	public static Block blocksmallStones = new BlocksmallStones(2011, Material.rock);
	public static Block blockHayBail = new BlockHayBail(2012, Material.cloth);
	
	//Items
	public static Item itemBranch = new ItemBranch(3011).setUnlocalizedName("itemBranch");
	public static Item itemStoneChips = new itemStoneChips(3012).setUnlocalizedName("itemStoneChips");
	public static Item itemAxeBasic = new itemAxeBasic(3013, BasicMaterial).setUnlocalizedName("itemAxeBasic");
	
	//Models
	public static int modelsmallStones;
	
	//Proxies
	@SidedProxy(clientSide="hac.RPAddon.Client.ClientProxy", serverSide="hac.RPAddon.Common.CommonProxy")
    public static CommonProxy proxy;
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		//Block Registry
		
		GameRegistry.registerBlock(blocksmallStones, "RPAddon" + blocksmallStones.getUnlocalizedName());
		
		GameRegistry.registerTileEntity(TileEntitysmallStones.class, "2011");
		
		GameRegistry.registerBlock(blockHayBail, "RPAddon" + blockHayBail.getUnlocalizedName());
		
		//Language Registry
		
		LanguageRegistry.addName(blocksmallStones, "Small Stones");
		
		LanguageRegistry.addName(itemBranch, "Branch");
		
		LanguageRegistry.addName(itemStoneChips, "Stone Chips");
		
		LanguageRegistry.addName(itemAxeBasic, "Rock Axe");
		
		LanguageRegistry.addName(blockHayBail, "Hay Bail");
		
		//Item Stacks
		
		ItemStack branchStack = new ItemStack(RPAddon.itemBranch, 64);
		
		ItemStack stoneChipsStack = new ItemStack(RPAddon.itemStoneChips, 64);
		
		ItemStack stickStack = new ItemStack(Item.stick, 64);
		
		ItemStack basicaxeStack = new ItemStack(RPAddon.itemAxeBasic, 1);
		
		
		//Recipe Registry
		
		GameRegistry.addShapelessRecipe(new ItemStack(Item.stick, 1), new ItemStack(itemBranch));
		
		GameRegistry.addRecipe(new ItemStack(RPAddon.itemAxeBasic, 1), "xy", " y", 'x', stoneChipsStack, 'y', stickStack);
		
		GameRegistry.addRecipe(new ItemStack(RPAddon.blockHayBail, 1), "xxx", "xxx", "xxx", 'x', Item.wheat);
		
		
		proxy.registerRenderers();
		proxy.addNames();
	}
	
    @PostInit
    public void postInit(FMLPostInitializationEvent event)
    {
            // Stub Method
    }
}
