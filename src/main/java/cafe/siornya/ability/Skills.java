package cafe.siornya.ability;

import java.util.List;

public class Skills {
	public static Skill ELECTRIC_SHOCK;
	public static Skill IRON_SAND_BOOST;

	static {
		ELECTRIC_SHOCK = new Skill("electric_shock", 1, List.of(), 10.0f);
		IRON_SAND_BOOST = new Skill("iron_sand_boost", 3, List.of(), 5.0f);
	}
}
