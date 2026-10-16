package cafe.siornya.item;

import cafe.siornya.attachment.DevAttachment;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DevItem extends Item {
	private final float effect;
	
	public DevItem(float effect, Properties settings) {
		super(settings);
		this.effect = effect;
	}
	
	@Override
	public InteractionResult use(Level world, Player player, InteractionHand hand) {
		if (world.isClientSide()) {
			return InteractionResult.PASS;
		}
		
		ItemStack stack = player.getItemInHand(hand);
		
		float cur = DevAttachment.get(player);
		float newVal = Mth.clamp(cur + effect, 0.0f, 100.0f);
		DevAttachment.set(player, newVal);
		
		player.playSound(SoundEvents.PLAYER_BURP, 1.0f, 1.0f);
		
		stack.shrink(1);
		
		return InteractionResult.SUCCESS;
	}
}
