package cafe.siornya.attachment;

import cafe.siornya.AcademyCity;
import cafe.siornya.ability.Abilities;
import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;

public class AbilityAttachment {
	
	public static final AttachmentType<Abilities> ABILITY_SYSTEM =
			AttachmentRegistry.create(Identifier.fromNamespaceAndPath(AcademyCity.MOD_ID, "ability_system"), builder -> {
				builder.initializer(() -> Abilities.ELECTROMASTER);
				builder.persistent(Abilities.CODEC);
				builder.copyOnDeath();
			});
	
	// 等级（0~6）
	public static final AttachmentType<Integer> LEVEL =
			AttachmentRegistry.create(Identifier.fromNamespaceAndPath(AcademyCity.MOD_ID, "level"), builder -> {
				builder.initializer(() -> 0);
				builder.persistent(Codec.INT);
				builder.copyOnDeath();
			});
	
	public static Abilities getAbility(Player player) {
		return player.getAttachedOrCreate(ABILITY_SYSTEM);
	}
	
	public static void setAbility(Player player, Abilities system) {
		player.setAttached(ABILITY_SYSTEM, system);
	}
	
	public static int getLevel(Player player) {
		return player.getAttachedOrCreate(LEVEL);
	}
	
	public static void setLevel(Player player, int value) {
		value = Math.max(0, Math.min(6, value));
		player.setAttached(LEVEL, value);
		
		float max = EnergyAttachment.getMaxEnergy(player);
		float cur = EnergyAttachment.get(player);
		
		if (cur > max) {
			EnergyAttachment.set(player, max);
		}
	}
	
	public static void addLevel(Player player, int delta) {
		setLevel(player, getLevel(player) + delta);
	}
}
