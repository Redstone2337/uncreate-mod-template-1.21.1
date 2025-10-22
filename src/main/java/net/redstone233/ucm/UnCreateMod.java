package net.redstone233.ucm;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.redstone233.ucm.command.UnCreateCommand;
import net.redstone233.ucm.config.ClientConfig;
import net.redstone233.ucm.items.ModItemGroups;
import net.redstone233.ucm.items.ModItems;
import net.redstone233.ucm.transaction.CustomTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnCreateMod implements ModInitializer {
	public static final String MOD_ID = "ucm";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
        long startTime = System.currentTimeMillis();
        LOGGER.info("开始初始化模组内容...");
        // 初始化配置
        ClientConfig.init();
        LOGGER.info("模组配置初始化完毕，总耗时 {}ms", System.currentTimeMillis() - startTime);
        CommandRegistrationCallback.EVENT.register((commandDispatcher, commandRegistryAccess, registrationEnvironment) -> {
            commandDispatcher.register(UnCreateCommand.register());
        });
        LOGGER.info("指令注册加载完成，总耗时 {}ms", System.currentTimeMillis() - startTime);
        // 初始化物品
        ModItems.registerItems();
        LOGGER.info("模组物品注册完成，总耗时 {}ms", System.currentTimeMillis() - startTime);
        ModItemGroups.register();
        LOGGER.info("模组物品组注册完成，总耗时 {}ms", System.currentTimeMillis() - startTime);
        CustomTransaction.init();
        LOGGER.info("模组交易系统初始化完成，总耗时 {}ms", System.currentTimeMillis() - startTime);
        LOGGER.info("模组初始化完成，总耗时 {}ms", System.currentTimeMillis() - startTime);
        LOGGER.info("Hello Fabric world!");
	}
}