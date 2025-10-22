package net.redstone233.ucm.keys;


import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.redstone233.ucm.UnCreateMod;
import org.lwjgl.glfw.GLFW;

public class ModKeys {
    public static KeyBinding ANNOUNCEMENT_KEY = new KeyBinding(
            "key.ucm.open_config",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_ALT,
            "category.ucm"
    );

    public static KeyBinding USE_ABILITY_KEY = new KeyBinding(
            "key.ucm.use_ability",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_CONTROL,
            "category.ucm"
    );

    public static void register() {
        KeyBindingHelper.registerKeyBinding(ANNOUNCEMENT_KEY);
        KeyBindingHelper.registerKeyBinding(USE_ABILITY_KEY);

        UnCreateMod.LOGGER.info("注册按键绑定成功");
    }


    public static boolean isAnnouncementKeyPressed() {
        return ANNOUNCEMENT_KEY.isPressed();
    }

    public static boolean isUseAbilityKeyPressed() {
        return USE_ABILITY_KEY.isPressed();
    }
}
