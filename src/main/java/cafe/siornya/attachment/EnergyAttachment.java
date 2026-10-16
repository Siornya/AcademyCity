package cafe.siornya.attachment;

import 	cafe.siornya.AcademyCity;
import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;

public class EnergyAttachment {
	
	private static final float LV_ENERGY_REGEN_PER_TICK = 0.25f;
	
	public static final AttachmentType<Float> ENERGY =
			AttachmentRegistry.create(Identifier.fromNamespaceAndPath(AcademyCity.MOD_ID, "energy"), builder -> {
				builder.initializer(() -> 0f);
				builder.persistent(Codec.FLOAT);
			});
	
	public static float get(Player player) {
		return player.getAttachedOrCreate(ENERGY);
	}
	
	public static void set(Player player, float value) {
		float max = getMaxEnergy(player);
		value = Math.max(0, Math.min(max, value));
		player.setAttached(ENERGY, value);
	}
	
	public static void add(Player player, float delta) {
		set(player, get(player) + delta);
	}
	
	public static float getMaxEnergy(Player player) {
		return getMaxEnergy(AbilityAttachment.getLevel(player));
	}
	
	private static float getMaxEnergy(int lv) {
		return switch (lv) {
			case 1 -> 100;
			case 2 -> 150;
			case 3 -> 200;
			case 4 -> 250;
			case 5 -> 300;
			case 6 -> 400;
			default -> 0;
		};
	}
	
	public static float getRegenPerTick(Player player) {
		return AbilityAttachment.getLevel(player) * LV_ENERGY_REGEN_PER_TICK;
	}
}
