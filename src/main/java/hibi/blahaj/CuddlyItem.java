package hibi.blahaj;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CuddlyItem extends Item {
    public CuddlyItem(String name) {
        this.setUnlocalizedName(name);
        this.setTextureName(Blahaj.MODID + ":" + name);
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabMisc);

        GameRegistry.registerItem(this, name, Blahaj.MODID);
    }
}
