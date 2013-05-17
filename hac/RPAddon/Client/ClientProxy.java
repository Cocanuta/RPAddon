package hac.RPAddon.Client;


import hac.RPAddon.RPAddon;
import hac.RPAddon.Common.CommonProxy;
import hac.RPAddon.blocks.BlocksmallStonesRenderer;
import hac.RPAddon.blocks.ItemsmallStonesRender;
import hac.RPAddon.blocks.TileEntitysmallStones;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	
	
    @Override
    public void registerRenderers() {
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntitysmallStones.class, new BlocksmallStonesRenderer());
    	MinecraftForgeClient.registerItemRenderer(RPAddon.blocksmallStones.blockID, new ItemsmallStonesRender());
    }
       
       
}
