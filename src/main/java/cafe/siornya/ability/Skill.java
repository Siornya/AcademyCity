package cafe.siornya.ability;

import java.util.List;

public class Skill {
	public final String id;
	public final int unlock_level;
	public final List<String> prerequisites;
	public final float energycost;

	public Skill(String id, int unlockLevel, List<String> prerequisites, float energycost) {
		this.id = id;
		this.unlock_level = unlockLevel;
		this.prerequisites = prerequisites;
		this.energycost = energycost;
	}
}
