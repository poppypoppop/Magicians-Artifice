package mysticartifice;

import magiciansartifice.ModInfo;
import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.guis.CreativeTab;
import magiciansartifice.guis.GuiHandler;
import magiciansartifice.proxies.CommonProxy;
import magiciansartifice.tileentities.TileEntityRegistry;
import mysticartifice.items.ItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "after:NotEnoughItems")
public class MysticArtifice {
    @Instance("mysticartifice")
    public static MysticArtifice instance;

    @SidedProxy(clientSide = "mysticartifice.proxies.ClientProxy", serverSide = "mysticartifice.proxies.CommonProxy")
    public static CommonProxy proxy;

    public static CreativeTabs tab = new CreativeTab("mysticartifice");

    Configuration config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());

        BlockRegistry.registerBlocks();
        ItemRegistry.registerItems();
        TileEntityRegistry.registerTEs();

        proxy.load();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        new GuiHandler();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
