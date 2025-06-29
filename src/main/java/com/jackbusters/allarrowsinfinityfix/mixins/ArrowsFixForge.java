package com.jackbusters.allarrowsinfinityfix.mixins;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArrowItem.class)
public class ArrowsFixForge {
    @Inject(at = @At("HEAD"), method = "isInfinite", cancellable = true, remap=false)
    public void isInfinite(ItemStack stack, ItemStack bow, LivingEntity livingEntity, CallbackInfoReturnable<Boolean> cir) {
        Holder<Enchantment> INFINITY = livingEntity.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.INFINITY);
        boolean hasInfinity = EnchantmentHelper.getItemEnchantmentLevel(INFINITY, bow) > 0;
        if (hasInfinity)
            cir.setReturnValue(true);
    }
}
