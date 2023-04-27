package hibi.blahaj.client;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class BreadRenderer implements IItemRenderer {
    IModelCustom model = AdvancedModelLoader.loadModel(TexturesManager.BREAD_MODEL);
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();
        GL11.glTranslatef(0.82F, 0.9F, 1.78F);
        GL11.glScalef(2.5F, 2.5F, 2.5F);
        GL11.glRotated(50.0D, 0, 1, 0);
        GL11.glRotated(45.0D, 1, 0, 0);
        GL11.glRotated(167.0D, 0, 0, 1);
        (FMLClientHandler.instance().getClient()).renderEngine.bindTexture(TexturesManager.BREAD_TEXTURES);
        model.renderAll();
        GL11.glPopMatrix();
    }
}
