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
                .comment("启用调试模式（显示详细日志）")
                .define("debugMode", false);


        ClientConfig.BUILDER.pop();
    }


    public static final ModConfigSpec SPEC = BUILDER.build();

    public static void init() {
        NeoForgeConfigRegistry.INSTANCE.register(UnCreateMod.MOD_ID, ModConfig.Type.CLIENT, SPEC, "UnCreate-client.toml");
    }

    public static ModConfigSpec.BooleanValue ENABLED_UN_CREATE;
    public static ModConfigSpec.BooleanValue DEBUG_MODE;

    static {
        setupGeneralSettings();
        setupDebugSettings();
    }

    public static boolean getDebugMode() {
        return DEBUG_MODE.get();
    }

    public static boolean getEnabledUnCreate() {
        return ENABLED_UN_CREATE.get();
    }

    public static void setDebugMode(boolean debugMode) {
        DEBUG_MODE.set(debugMode);
    }

    public static void setEnabledUnCreate(boolean enabledUnCreate) {
        ENABLED_UN_CREATE.set(enabledUnCreate);
    }

    public static void saveConfig() {
        // 在 NeoForge 中，配置会自动保存
        // 这里可以添加额外的保存逻辑
        if (ClientConfig.SPEC.isLoaded()) {
            // 触发配置保存
            ClientConfig.SPEC.save();
        }
    }
}