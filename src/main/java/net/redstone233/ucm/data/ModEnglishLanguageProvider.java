package net.redstone233.ucm.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.redstone233.ucm.items.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModEnglishLanguageProvider extends FabricLanguageProvider {
    public ModEnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("key.ucm.open_config", "Open UnCreateMod Config");
        translationBuilder.add("category.ucm", "Un Create Mod");
        translationBuilder.add("itemGroup.ucm.mod_items", "Un Create Mod | Customization Items");

        translationBuilder.add(ModItems.BLAZING_FLAME_SWORD, "Blazing Flame Sword");
        translationBuilder.add(ModItems.ICE_FREEZE_SWORD, "Ice Freeze Sword");
    }
}
