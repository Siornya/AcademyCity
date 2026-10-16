package cafe.siornya.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ToolMaterial;

public class ElectroMasterMaterial {
	
	public static final ToolMaterial ELECTROMASTER_MATERIAL =
			new ToolMaterial(
					BlockTags.INCORRECT_FOR_IRON_TOOL,
					250,
					6.0F,
					0.0F,
					14,
					ItemTags.IRON_TOOL_MATERIALS
			);
	
	public static final ToolMaterial ELECTROMASTER_MATERIAL_S =
			new ToolMaterial(
					BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
					800,
					7.0F,
					0.0F,
					18,
					ItemTags.IRON_TOOL_MATERIALS
			);
	
	public static final ToolMaterial ELECTROMASTER_MATERIAL_X =
			new ToolMaterial(
					BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
					2000,
					9.0F,
					0.0F,
					22,
					ItemTags.NETHERITE_TOOL_MATERIALS
			);
	
	private ElectroMasterMaterial() {
	}
}
