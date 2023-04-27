package hibi.blahaj.proxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hibi.blahaj.Blahaj;
import hibi.blahaj.client.BlueSharkRenderer;
import hibi.blahaj.client.BreadRenderer;
import hibi.blahaj.client.GraySharkRenderer;
import hibi.blahaj.proxy.CommonProxy;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
    @SideOnly(Side.CLIENT)
    @Override
    public void initRender() {
        MinecraftForgeClient.registerItemRenderer(Blahaj.BLUE_SHARK_ITEM, new BlueSharkRenderer());
        MinecraftForgeClient.registerItemRenderer(Blahaj.GRAY_SHARK_ITEM, new GraySharkRenderer());
        MinecraftForgeClient.registerItemRenderer(Blahaj.BREAD_PILLOW_ITEM, new BreadRenderer());
    }
}
