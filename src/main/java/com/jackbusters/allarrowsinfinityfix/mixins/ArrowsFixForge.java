package com.jackbusters.allarrowsinfinityfix.mixins;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemArrow.class)
public class arrowsFixForge {
    
    @Inject(at = @At("HEAD"), method = "isInfinite", cancellable = true, remap=false)
    public void isInfinite(ItemStack stack, ItemStack bow, EntityPlayer player, CallbackInfoReturnable<Boolean> cir)
    {
        if(Enchantments.INFINITY != null && EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, bow) > 0)
            cir.setReturnValue(true);
    }
}
