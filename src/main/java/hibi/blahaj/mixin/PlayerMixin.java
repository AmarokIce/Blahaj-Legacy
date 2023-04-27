package hibi.blahaj.mixin;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hibi.blahaj.Blahaj;
import hibi.blahaj.CuddlyItem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModelBiped.class)
@SideOnly(Side.CLIENT)
public abstract class PlayerMixin extends ModelBase {
    @Shadow
    public ModelRenderer bipedRightArm;

    @Shadow
    public ModelRenderer bipedLeftArm;

    @Inject(method = "setRotationAngles", at = @At(value = "TAIL", target = "Lnet/minecraft/client/Minecraft;setRotationAngles()V"))
    public void OnSetRotationAngles(float x, float y, float z, float px, float py, float pz, Entity entity, CallbackInfo ci) {
        if(entity instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) entity;
            if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof CuddlyItem) {
                this.bipedRightArm.rotateAngleX = -0.90F;
                this.bipedRightArm.rotateAngleZ = (float) (-Math.PI / 8);

                this.bipedLeftArm.rotateAngleX = -0.95F;
                this.bipedLeftArm.rotateAngleZ = (float) (Math.PI / 8);
            }
        }
    }
}
