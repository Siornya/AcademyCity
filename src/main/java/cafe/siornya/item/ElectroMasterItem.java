package cafe.siornya.item;

import cafe.siornya.attachment.EnergyAttachment;
import cafe.siornya.damagesource.ModDamageTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ElectroMasterItem extends Item {
	private final float electroMasterDamage;
	
	public ElectroMasterItem(float electroMasterDamage, Properties settings) {
		super(settings);
		this.electroMasterDamage = electroMasterDamage;
	}
	
	@Override
	public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.setInvulnerableTime(0);
		if (!target.level().isClientSide()) {
			ServerLevel world = (ServerLevel) target.level();
			
			DamageSource damageSource = new DamageSource(
					world.registryAccess()
							.lookupOrThrow(Registries.DAMAGE_TYPE)
							.get(ModDamageTypes.ELECTRO_MASTER_DAMAGE.identifier()).get()
			
			);
			target.hurtServer(world, damageSource, electroMasterDamage);
		}
		super.hurtEnemy(stack, target, attacker);
	}
	
	@Override
	public void inventoryTick(ItemStack itemStack, ServerLevel serverLevel, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		if (entity instanceof Player player) {
			EnergyAttachment.add(player, -0.25f);
			
			if (EnergyAttachment.get(player) <= 0f) {
				player.getInventory().removeItem(itemStack);
			}
		}
	}
}
