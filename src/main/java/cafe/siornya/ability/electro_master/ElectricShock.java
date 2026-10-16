package cafe.siornya.ability.electro_master;

import cafe.siornya.ability.Skills;
import cafe.siornya.attachment.AbilityAttachment;
import cafe.siornya.attachment.EnergyAttachment;
import cafe.siornya.damagesource.ModDamageTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;

public class ElectricShock {

	private static final float DAMAGE = 5.0f;  // 电击伤害
	private static final float ENERGY_COST = Skills.ELECTRIC_SHOCK.energycost;  // 电击技能的能量消耗

	// 检查玩家是否满足技能解锁条件
	public static boolean canActivate(Player player) {
		// 检查玩家的能力等级是否达到解锁条件
		int playerLevel = AbilityAttachment.getLevel(player);
		return playerLevel >= Skills.ELECTRIC_SHOCK.unlock_level;
	}

	// 激活电击技能
	public static void activate(Player player, LivingEntity target) {
		if (canActivate(player)) {
			// 检查能量是否足够
			if (EnergyAttachment.get(player) >= ENERGY_COST) {
				// 消耗能量
				EnergyAttachment.add(player, -ENERGY_COST);

				// 造成电击伤害
				if (!target.level().isClientSide()) {
					ServerLevel world = (ServerLevel) target.level();
					DamageSource damageSource = new DamageSource(world.registryAccess()
							.lookupOrThrow(Registries.DAMAGE_TYPE)
							.get(ModDamageTypes.ELECTRO_MASTER_DAMAGE.identifier()).get()
					);

					// 这里是电击伤害，使用玩家原本的攻击伤害，或者你也可以设置为固定伤害
					target.hurtServer(world, damageSource, DAMAGE);
				}

				// 执行电击技能的其他效果（如果有的话）
				onActive(player, target);
			}
		}
	}

	// 电击技能的额外效果（例如击退、特殊效果等）
	private static void onActive(LivingEntity player, LivingEntity target) {
		// 这里可以增加电击技能的额外效果，比如击退敌人等
		// 例如：target.knockback(1.0, player.getX() - target.getX(), player.getZ() - target.getZ());
	}
}
