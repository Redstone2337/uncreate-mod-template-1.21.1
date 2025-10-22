package net.redstone233.ucm;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.redstone233.ucm.data.ModChineseLanguageProvider;
import net.redstone233.ucm.data.ModEnglishLanguageProvider;
import net.redstone233.ucm.data.ModModelsProvider;

public class UnCreateModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModEnglishLanguageProvider::new);
        pack.addProvider(ModChineseLanguageProvider::new);
        pack.addProvider(ModModelsProvider::new);
    }
}
