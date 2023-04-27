package hibi.blahaj;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import hibi.blahaj.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = Blahaj.MODID, dependencies = "after:spongemixins@[1.1.0,)")
public class Blahaj {
    public static final String MODID = "blahaj";

    public static Item BLUE_SHARK_ITEM;
    public static Item GRAY_SHARK_ITEM;
    public static Item BREAD_PILLOW_ITEM;

    @SidedProxy(clientSide="hibi.blahaj.proxy.ClientProxy", serverSide="hibi.blahaj.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void ModInit(FMLInitializationEvent event) {
        BLUE_SHARK_ITEM = new CuddlyItem("blue_shark");
        GRAY_SHARK_ITEM = new CuddlyItem("gray_shark");
        BREAD_PILLOW_ITEM = new CuddlyItem("bread_pillow");
        proxy.initRender();

        GameRegistry.addShapedRecipe(new ItemStack(BLUE_SHARK_ITEM), " # " , "###", "PW ", '#', new ItemStack(Blocks.wool, 1, 3), 'P', new ItemStack(Items.dye, 1, 9), 'W', new ItemStack(Blocks.wool, 1, 0));
        GameRegistry.addShapedRecipe(new ItemStack(GRAY_SHARK_ITEM), " # " , "###", "PW ", '#', new ItemStack(Blocks.wool, 1, 8), 'P', new ItemStack(Items.dye, 1, 9), 'W', new ItemStack(Blocks.wool, 1, 0));
        GameRegistry.addShapedRecipe(new ItemStack(BREAD_PILLOW_ITEM), "###" , "###", '#', new ItemStack(Blocks.wool, 1, 1));
    }
}
