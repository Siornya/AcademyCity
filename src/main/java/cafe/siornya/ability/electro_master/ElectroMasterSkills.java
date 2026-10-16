package cafe.siornya.ability.electro_master;

import cafe.siornya.ability.Skill;
import cafe.siornya.attachment.AbilityAttachment;
import java.util.*;
import net.minecraft.world.entity.player.Player;

public class ElectroMasterSkills {

	private static final Map<String, Skill> SKILL_MAP = new HashMap<>();

	static {
		SKILL_MAP.put("electric_shock",
				new Skill("electric_shock", 3, Collections.emptyList(), 5f));

		SKILL_MAP.put("iron_sand_armor",
				new Skill("iron_sand_armor", 3, Collections.emptyList(), 0.2f));

		SKILL_MAP.put("iron_sand_weapon",
				new Skill("iron_sand_weapon", 3, Collections.emptyList(), 0.5f));

		// 其他技能可在此添加
		// SKILL_MAP.put("新技能", new Skill("新技能", 解锁等级, List.of("前置技能id1","前置技能id2"), 能量消耗));
	}

	public static Skill getSkill(String skillId) {
		return SKILL_MAP.get(skillId);
	}

	public static Collection<Skill> getAllSkills() {
		return SKILL_MAP.values();
	}

	public static boolean canUnlock(Player player, String skillId) {
		Skill skill = SKILL_MAP.get(skillId);
		if (skill == null) return false;

		int level = AbilityAttachment.getLevel(player);
		if (level < skill.unlock_level) return false;

		// 检查前置技能是否解锁
//        for (String pre : skill.prerequisites) {
//            if (!ElectroMasterSkillState.isUnlocked(player, pre)) return false;
//        }
		return true;
	}
}
