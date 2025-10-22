package net.redstone233.ucm;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.text.Text;
import net.redstone233.ucm.config.ConfigManager;
import net.redstone233.ucm.event.PlayerGameModeEvent;
import net.redstone233.ucm.gui.ConfigScreen;
import net.redstone233.ucm.keys.ModKeys;

public class UnCreateModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
            UnCreateMod.LOGGER.info("开始初始化模组客户端内容...");
            long startTime = System.currentTimeMillis();
        if (ConfigManager.getEnabledUnCreate()) {
            PlayerGameModeEvent.register();
            UnCreateMod.LOGGER.info("模组玩家游戏模式事件初加载完毕，总耗时 {}ms", System.currentTimeMillis() - startTime);
        }
        ModKeys.register();
            UnCreateMod.LOGGER.info("模组键位绑定成功，总耗时 {}ms", System.currentTimeMillis() - startTime);
            register();
            UnCreateMod.LOGGER.info("模组客户端键位初始化完毕，总耗时 {}ms", System.currentTimeMillis() - startTime);
            UnCreateMod.LOGGER.info("模组客户端初始化完毕，全部总共耗时 {}ms", System.currentTimeMillis() - startTime);
	}


    private static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (ModKeys.isAnnouncementKeyPressed()) {
                // TODO: 打开配置界面
                if (client.player != null && client.player.hasPermissionLevel(4)) {
                    // 打开配置屏幕
                    client.setScreen(ConfigScreen.create(client.currentScreen));
                    if (ConfigManager.getDebugMode()) {
                        UnCreateMod.LOGGER.info("UnCreateModClient: 打开配置界面");
                    }
                } else {
                    if (client.player != null) {
                        client.player.sendMessage(
                                Text.literal("§c你需要OP权限才能打开配置界面!"),
                                false
                        );
                    }
                    if (ConfigManager.getDebugMode()) {
                        UnCreateMod.LOGGER.info("UnCreateModClient: 需要OP权限才能打开配置界面");
                    }
                }
            }
        });
    }
}

