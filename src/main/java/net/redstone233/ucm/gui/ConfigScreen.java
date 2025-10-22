package net.redstone233.ucm.gui;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.redstone233.ucm.UnCreateMod;
import net.redstone233.ucm.config.ClientConfig;

public class ConfigScreen {

    public static Screen create(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.literal("模组配置"))
                .setSavingRunnable(ConfigScreen::saveConfig);

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        setupGeneralCategory(builder, entryBuilder);
        setupDebugCategory(builder, entryBuilder);

        return builder.build();
    }

    private static void setupGeneralCategory(ConfigBuilder builder, ConfigEntryBuilder entryBuilder) {
        ConfigCategory general = builder.getOrCreateCategory(Text.literal("功能设定"));

        general.addEntry(entryBuilder.startBooleanToggle(Text.literal("启用禁止调创造"),
                        ClientConfig.getEnabledUnCreate())
                .setDefaultValue(true)
                .setTooltip(Text.literal("设定是否启用禁止创造模式"))
                .setSaveConsumer(ClientConfig::setEnabledUnCreate)
                .build());

    }

    private static void setupDebugCategory(ConfigBuilder builder, ConfigEntryBuilder entryBuilder) {
        ConfigCategory debug = builder.getOrCreateCategory(Text.literal("调试设定"));

        debug.addEntry(entryBuilder.startBooleanToggle(Text.literal("启用调试功能"),
                        ClientConfig.getEnabledUnCreate())
                .setDefaultValue(true)
                .setTooltip(Text.literal("设定是否启用调试"))
                .setSaveConsumer(ClientConfig::setEnabledUnCreate)
                .build());

    }

    private static void saveConfig() {
        try {
            ClientConfig.saveConfig();
            UnCreateMod.LOGGER.info("公告模组配置已保存");
        } catch (Exception e) {
            UnCreateMod.LOGGER.error("保存配置时出错", e);
        }
    }
}
