package net.redstone233.ucm.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.GameMode;
import net.redstone233.ucm.UnCreateMod;
import net.redstone233.ucm.config.ClientConfig;
import net.redstone233.ucm.config.ConfigManager;

public class PlayerGameModeEvent {
    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (ConfigManager.getEnabledUnCreate()) {
                    if (player.interactionManager.getGameMode() == GameMode.CREATIVE) {
                        player.changeGameMode(GameMode.SURVIVAL);
                    }
                    if (ConfigManager.getDebugMode()) {
                        UnCreateMod.LOGGER.info("UnCreateMod: PlayerGameModeEvent is working!");
                    }
                } else {
                    if (ConfigManager.getDebugMode()) {
                        UnCreateMod.LOGGER.info("UnCreateMod: PlayerGameModeEvent is not working!");
                    }
                    player.sendMessage(Text.literal("似乎并没有正常运行！").formatted(Formatting.RED, Formatting.BOLD));
                }
            }
        });

    }
}
