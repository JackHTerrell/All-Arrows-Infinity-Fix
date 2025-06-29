package com.jackbusters.allarrowsinfinityfix.mixins;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
    <p>This class will modify some variables to allow all arrows, including modded ones, to work with the infinity enchantment.</p>
*/


@Mixin(EnchantmentHelper.class)
public class ArrowsFixAllArrows {
    @Inject(method = "processAmmoUse", at = @At("HEAD"), cancellable = true)
    private static void hasInfiniteInjection(ServerLevel pLevel, ItemStack pWeapon, ItemStack pAmmo, int pCount, CallbackInfoReturnable<Integer> cir){
        Holder<Enchantment> INFINITY = pLevel.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.INFINITY);
        boolean hasInfinity = EnchantmentHelper.getItemEnchantmentLevel(INFINITY, pWeapon) > 0;
        if (hasInfinity)
            cir.setReturnValue(0);
    }
}
