package net.redstone233.ucm;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.redstone233.ucm.config.ClientConfig;
import net.redstone233.ucm.event.PlayerGameModeEvent;

public class UnCreateModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
        if (ClientConfig.getDebugMode()) {
            UnCreateMod.LOGGER.info("开始初始化模组客户端内容...");
            long startTime = System.currentTimeMillis();
            PlayerGameModeEvent.register();
            UnCreateMod.LOGGER.info("模组客户端内容初始化完毕，总耗时 {}ms", System.currentTimeMillis() - startTime);
        } else {
            PlayerGameModeEvent.register();
        }
	}
}

