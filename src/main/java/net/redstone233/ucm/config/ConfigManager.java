package net.redstone233.ucm.config;

public class ConfigManager {
    public static boolean getDebugMode() {
        return ClientConfig.DEBUG_MODE.getAsBoolean();
    }

    public static void setDebugMode(boolean debugMode) {
        ClientConfig.DEBUG_MODE.set(debugMode);
    }

    public static boolean getEnabledUnCreate() {
        return ClientConfig.ENABLED_UN_CREATE.getAsBoolean();
    }


    public static void setEnabledUnCreate(boolean enabledUnCreate) {
        ClientConfig.ENABLED_UN_CREATE.set(enabledUnCreate);
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
