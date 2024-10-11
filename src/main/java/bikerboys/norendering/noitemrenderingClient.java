// noitemrenderingClient.java
package bikerboys.norendering;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class noitemrenderingClient implements ClientModInitializer {

    public static boolean RENDER_TOGGLE = false;
    public static boolean MOB_RENDER_TOGGLE = false;

    private static KeyBinding RENDER_TOGGLE_KEYBINDING;
    private static KeyBinding MOB_RENDER_TOGGLE_KEYBINDING;

    @Override
    public void onInitializeClient() {
        RENDER_TOGGLE_KEYBINDING = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.noitemrendering.itemrendertoggle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                "key.category.rendering")
        );

        MOB_RENDER_TOGGLE_KEYBINDING = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.noitemrendering.mobrendertoggle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_H,
                "key.category.rendering")
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            if (MOB_RENDER_TOGGLE_KEYBINDING.wasPressed()) {
                MOB_RENDER_TOGGLE = !MOB_RENDER_TOGGLE;
            }
            if (RENDER_TOGGLE_KEYBINDING.wasPressed()) {
                RENDER_TOGGLE = !RENDER_TOGGLE;
            }

        });

    }
}
