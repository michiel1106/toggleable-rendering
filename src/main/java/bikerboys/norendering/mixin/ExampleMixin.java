package bikerboys.norendering.mixin;


import net.minecraft.client.render.entity.ItemEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static bikerboys.norendering.noitemrenderingClient.RENDER_TOGGLE;


@Mixin(ItemEntityRenderer.class)
public class ExampleMixin {

	//toggles rendering by canceling the rendering method
	// im just testing the git pushing stuff so idk

	@Inject(method = "render(Lnet/minecraft/entity/ItemEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", at = @At("HEAD"), cancellable = true)
	private void onRender(CallbackInfo ci) {
		if (RENDER_TOGGLE) {
			ci.cancel();
		}
	}
}
