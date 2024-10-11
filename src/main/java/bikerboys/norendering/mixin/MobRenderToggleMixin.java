package bikerboys.norendering.mixin;



import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;


import static bikerboys.norendering.noitemrenderingClient.MOB_RENDER_TOGGLE;


@Mixin(Entity.class)
public abstract class MobRenderToggleMixin {


    /**
     * @author d
     * @reason d
     */
    @Overwrite
    public boolean shouldRender(double distance) {

        if (MOB_RENDER_TOGGLE) {
            return false;
        }
        return true;
    }
}