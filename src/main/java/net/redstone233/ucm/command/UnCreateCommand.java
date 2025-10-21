package net.redstone233.ucm.command;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.redstone233.ucm.config.ClientConfig;

public class UnCreateCommand {
    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("ucm")
                .requires(source -> source.hasPermissionLevel(4))
                .then(CommandManager.literal("debug")
                        .then(CommandManager.argument("status", BoolArgumentType.bool())
                                .executes(null)
                        )
                )
                .then(CommandManager.literal("general")
                        .then(CommandManager.argument("status", BoolArgumentType.bool())
                                .executes(null)
                                )
                );
    }

    private static int execute(ServerCommandSource source, boolean status) {
        if (source instanceof ServerCommandSource && source.getPlayer() != null) {
            if (status) {
                ClientConfig.setDebugMode(true);
                ClientConfig.saveConfig();
            } else {
                ClientConfig.setDebugMode(false);
                ClientConfig.saveConfig();
            }
            source.sendFeedback(() -> Text.literal("执行成功！详细日志已开启。").formatted(Formatting.GREEN,Formatting.BOLD),true);
            return 1;
        } else {
            source.sendError(Text.literal("执行失败！请确保你在游戏中执行此命令。").formatted(Formatting.RED,Formatting.BOLD));
            return 0;
        }
    }

    private static int execute1(ServerCommandSource source, boolean status) {
        if (source instanceof ServerCommandSource && source.getPlayer() != null) {
            if (status) {
                ClientConfig.setEnabledUnCreate(true);
                ClientConfig.saveConfig();
            } else {
                ClientConfig.setEnabledUnCreate(false);
                ClientConfig.saveConfig();
            }
            source.sendFeedback(() -> Text.literal("执行成功！当前状态：" + status).formatted(Formatting.GREEN,Formatting.BOLD),true);
            return 1;
        } else {
            source.sendError(Text.literal("执行失败！请确保你在游戏中执行此命令。").formatted(Formatting.RED,Formatting.BOLD));
            return 0;
        }
    }
}
