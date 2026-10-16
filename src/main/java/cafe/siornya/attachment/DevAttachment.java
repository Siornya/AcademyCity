package cafe.siornya.attachment;

import cafe.siornya.AcademyCity;
import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;

public class DevAttachment {
	
	public static final AttachmentType<Float> DEV_PROGRESS = AttachmentRegistry.create(Identifier.fromNamespaceAndPath(AcademyCity.MOD_ID, "dev_progress"), builder -> {
		builder.initializer(() -> 0f);
		builder.persistent(Codec.FLOAT);
		builder.copyOnDeath();
	});
	
	public static float get(Player player) {
		return player.getAttachedOrCreate(DEV_PROGRESS);
	}
	
	public static void set(Player player, float value) {
		value = Math.max(0f, Math.min(100f, value));
		player.setAttached(DEV_PROGRESS, value);
	}
	
	public static void add(Player player, float delta) {
		set(player, get(player) + delta);
	}
}
