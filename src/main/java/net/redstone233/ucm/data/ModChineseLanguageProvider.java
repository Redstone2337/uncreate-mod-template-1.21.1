package net.redstone233.ucm.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.redstone233.ucm.items.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModChineseLanguageProvider extends FabricLanguageProvider {
    public ModChineseLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("key.ucm.open_config", "打开 UnCreateMod 配置");
        translationBuilder.add("key.atm.use_ability", "使用剑武器技能");
        translationBuilder.add("category.ucm", "UCM 模组");
        translationBuilder.add("itemGroup.ucm.mod_items", "UCM模组 | 定制物品");

        translationBuilder.add("tooltip.ability_sword.display1","按住 [");
        translationBuilder.add("key.use_ability.item","%s");
        translationBuilder.add("tooltip.ability_sword.display2"," ] 使用武器技能");

        translationBuilder.add(ModItems.BLAZING_FLAME_SWORD, "炽燃之剑");
        translationBuilder.add(ModItems.ICE_FREEZE_SWORD, "冰霜之剑");
    }
}