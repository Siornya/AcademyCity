package cafe.siornya.ability;

import cafe.siornya.ability.electro_master.ElectroMasterSkills;
import cafe.siornya.attachment.AbilityAttachment;
import cafe.siornya.attachment.EnergyAttachment;
import cafe.siornya.item.ElectroMasterItems;
import net.minecraft.world.entity.player.Player;

public class ElectroMaster {

	private final Player player;

	// 技能状态
	private boolean electroShockActive = false;
	private boolean ironSandArmorActive = false;
	private boolean ironSandWeaponActive = false;

	public ElectroMaster(Player player) {
		this.player = player;
	}

	// 返回 true 表示当前无法使用该技能（未解锁 或 能量耗尽）
	// 注意：旧框架中此方法名为 canUseSkill 但语义相反，迁移时更名为 cannotUseSkill
	private boolean cannotUseSkill(String skillId) {
		return !ElectroMasterSkills.canUnlock(player, skillId) || !(EnergyAttachment.get(player) > 0);
	}

	public void activateElectroShock() {
		if (cannotUseSkill("electric_shock")) return;

		electroShockActive = true;
		float cost = ElectroMasterSkills.getSkill("electric_shock").energycost;
		EnergyAttachment.add(player, -cost);

		// 这里触发电击逻辑，例如攻击目标
	}

	public void deactivateElectroShock() {
		electroShockActive = false;
	}

	public boolean isElectroShockActive() {
		return electroShockActive;
	}

	public boolean isIronSandArmorActive() {
		return ironSandArmorActive;
	}

	/* ------------------------------
	 *         铁砂武器技能
	 * ----------------------------- */
	public void activateIronSandWeapon() {
		if (cannotUseSkill("iron_sand_weapon")) return;

		ironSandWeaponActive = true;
		float cost = ElectroMasterSkills.getSkill("iron_sand_weapon").energycost;
		EnergyAttachment.add(player, -cost);

		int level = AbilityAttachment.getLevel(player);
		if (level >= 5) {
			giveWeapon(ElectroMasterItems.ELECTROMASTER_SWORD_X);
		} else if (level >= 4) {
			giveWeapon(ElectroMasterItems.ELECTROMASTER_SWORD_S);
		} else {
			giveWeapon(ElectroMasterItems.ELECTROMASTER_SWORD);
		}
	}

	public void deactivateIronSandWeapon() {
		ironSandWeaponActive = false;
	}

	public boolean isIronSandWeaponActive() {
		return ironSandWeaponActive;
	}

	private void giveWeapon(net.minecraft.world.item.Item weapon) {
		player.getInventory().add(new net.minecraft.world.item.ItemStack(weapon));
	}

	/* ------------------------------
	 *         每 tick 更新
	 * ----------------------------- */
	public void tick() {
		if (ironSandWeaponActive && EnergyAttachment.get(player) <= 0) deactivateIronSandWeapon();
	}
}
