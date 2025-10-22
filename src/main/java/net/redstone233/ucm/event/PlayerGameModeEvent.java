package net.redstone233.ucm.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameMode;

public class PlayerGameModeEvent {
    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (player != null) {
                    if (player.interactionManager.getGameMode() == GameMode.CREATIVE) {
                        player.changeGameMode(GameMode.SURVIVAL);
                    }
                }
            }
        });

    }
}
