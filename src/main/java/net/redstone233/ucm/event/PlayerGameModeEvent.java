package net.redstone233.ucm.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.GameMode;
import net.redstone233.ucm.config.ClientConfig;

public class PlayerGameModeEvent {
    public static void register() {
        ServerTickEvents.START_SERVER_TICK.register(server -> {
            if (server != null && ClientConfig.getEnabledUnCreate()) {
                server.getPlayerManager().getPlayerList().forEach(player ->
                {
                    if (player != null) {
                        if (player.isCreative()) {
                            player.changeGameMode(GameMode.SURVIVAL);
                        }
                    }
                });
            } else {
                if (server != null) {
                    server.getPlayerManager().getPlayerList().forEach(player -> {
                        player.sendMessage(Text.literal("模组未启用！请检查是否正常加载。").formatted(Formatting.BOLD,Formatting.RED));
                        }
                    );
                }
            }
        });
    }
}
