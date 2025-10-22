package net.redstone233.ucm.config;

import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.redstone233.ucm.UnCreateMod;

public class ClientConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static void setupGeneralSettings() {
        ClientConfig.BUILDER.push("general");

        ENABLED_UN_CREATE = ClientConfig.BUILDER
                .comment("是否启用功能")
                .define("enabledUnCreate", true);


        ClientConfig.BUILDER.pop();
    }

    private static void setupDebugSettings() {
        ClientConfig.BUILDER.push("debug");

        DEBUG_MODE = ClientConfig.BUILDER
                .comment("是否启用调试模式")
                .define("debugMode", false);


        ClientConfig.BUILDER.pop();
    }


    public static final ModConfigSpec SPEC = BUILDER.build();

    public static void init() {
        NeoForgeConfigRegistry.INSTANCE.register(UnCreateMod.MOD_ID, ModConfig.Type.SERVER, SPEC, "UnCreate-server.toml");
    }

    public static ModConfigSpec.BooleanValue ENABLED_UN_CREATE;
    public static ModConfigSpec.BooleanValue DEBUG_MODE;

    static {
        setupGeneralSettings();
        setupDebugSettings();
    }
}