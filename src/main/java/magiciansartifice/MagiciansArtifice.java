package magiciansartifice;

import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.guis.CreativeTab;
import magiciansartifice.guis.GuiHandler;
import magiciansartifice.items.ItemRegistry;
import magiciansartifice.proxies.CommonProxy;
import magiciansartifice.tileentities.TileEntityRegistry;
import magiciansartifice.utils.PlayerHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "after:NotEnoughItems")
public class MagiciansArtifice {
    @Instance(ModInfo.MODID)
    public static MagiciansArtifice instance;

    @SidedProxy(clientSide = ModInfo.CLIENT, serverSide = ModInfo.SERVER)
    public static CommonProxy proxy;

    public static CreativeTabs tab = new CreativeTab(ModInfo.MODID);

    Configuration config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());

        BlockRegistry.registerBlocks();
        ItemRegistry.registerItems();
        TileEntityRegistry.registerTEs();

        NetworkRegistry.INSTANCE.registerGuiHandler(MagiciansArtifice.instance, new GuiHandler());

        proxy.load();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Optional.Method(modid="cAPI")
    @EventHandler
    public void capeInit(FMLPreInitializationEvent event) {
        PlayerHelper.players.add("Mitchellbrine");
        PlayerHelper.players.add("poppypoppop");
        PlayerHelper.players.add("allout58");
        PlayerHelper.players.add("isomgirl6");
        PlayerHelper.players.add("MrComputerGhost");
        PlayerHelper.players.add("hawks008");
        PlayerHelper.players.add("theminecoder");
//        CAPI.instance.addCape("http://i.imgur.com/BrLFljO.png","magician");
//        for (int i = 0;i < PlayerHelper.players.size();i++) {
//            CAPI.instance.addPlayerCape(PlayerHelper.players.get(i),"magician");
//        }
    }

}
