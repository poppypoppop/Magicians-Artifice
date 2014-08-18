package magiciansartifice.blocks.misc;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class BlockPotato extends Block {
    public BlockPotato() {
        super(Material.cactus);
        this.setBlockTextureName(ModInfo.MODID + ":misc/potatoBlock");
        this.setBlockName("potatoBlock");
        this.setCreativeTab(MagiciansArtifice.tab);
        MinecraftForge.EVENT_BUS.register(this);
        BlockRegistry.blocks.add(this);
    }

    @SubscribeEvent
    public void potatoToolTip(ItemTooltipEvent event) {
        if (event.itemStack != null && event.itemStack.getItem() == new ItemStack(this).getItem()) {
            event.toolTip.add("I added a potato block... because why not?");
        }
    }
}
