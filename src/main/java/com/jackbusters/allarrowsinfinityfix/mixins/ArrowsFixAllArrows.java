package com.jackbusters.allarrowsinfinityfix.mixins;

import net.minecraft.item.ItemBow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/*
    This class will modify some variables to allow all arrows, including modded ones, to work with the infinity enchantment.
    If a custom bow overrides this class's releaseUsing method without calling the super, this fix will not work with that bow.
    Should fix most cases though.
*/


@Mixin(ItemBow.class)
public class arrowsFixAllArrows {
    boolean globalFlag; // true if player is in creative or if the bow has infinity on it.
    boolean globalFlag1; // true if player is in creative or if the projectile item is an instance of the arrow item which also returns true on isInfinite... that is until we change it to be the same value as the first flag.

    @ModifyVariable(method = "onPlayerStoppedUsing", at = @At("STORE"), ordinal = 0)
            private boolean injectedFlag(boolean x) {
                globalFlag = x;
                return x;
            }
    @ModifyVariable(method = "onPlayerStoppedUsing", at = @At("STORE"), ordinal = 1)
            private boolean injectedFlag1(boolean x) {
                globalFlag1 = x;
                return globalFlag;
            }


          
}
