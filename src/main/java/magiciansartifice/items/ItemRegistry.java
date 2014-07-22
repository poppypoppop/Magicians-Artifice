package magiciansartifice.items;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.items.misc.ItemDustMeta;
import magiciansartifice.items.misc.ItemIngotMeta;
import magiciansartifice.items.misc.ItemLetterMerlin;
import magiciansartifice.items.tools.ItemMagicBook;
import magiciansartifice.libs.ModInfo;
import magiciansartifice.items.tools.ItemToolChisel;
import magiciansartifice.items.wand.Wand;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class ItemRegistry
{
    public static Item ingotsMeta;
    public static ArrayList<Item> items = new ArrayList<Item>();
    
    public static Item dustsMeta;
    public static Item magiciansWand;
    public static Item level3Test;
    public static Item chiselTool;
    public static Item book;
    public static Item merlinLetter;
    
    public static void initItems() {
        dustsMeta = new ItemDustMeta();
        ingotsMeta = new ItemIngotMeta();
        
        magiciansWand = new Wand(1);
        level3Test = new Wand(3);
        book = new ItemMagicBook();
        chiselTool = new ItemToolChisel();
        merlinLetter = new ItemLetterMerlin();
        
        for (Item item : items) {
            GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
        }
    }
}
