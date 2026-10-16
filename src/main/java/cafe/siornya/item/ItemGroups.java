package cafe.siornya.item;

import cafe.siornya.AcademyCity;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ItemGroups {
	public static final ResourceKey<CreativeModeTab> ACADEMY_CITY_DEV = keyOf("dev");
	public static final ResourceKey<CreativeModeTab> ACADEMY_CITY_ABILITY = keyOf("ability");

	private static ResourceKey<CreativeModeTab> keyOf(String id) {
		return ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(AcademyCity.MOD_ID, id));
	}

	public static void initialize() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ACADEMY_CITY_DEV,
				FabricCreativeModeTab.builder()
						.title(Component.translatable("itemGroup." + AcademyCity.MOD_ID + ".dev"))
						.icon(() -> new ItemStack(DevItems.DRUG_ALPHA))
						.displayItems((params, output) -> {
							output.accept(DevItems.DRUG_ALPHA);
							output.accept(DevItems.DRUG_BETA);
							output.accept(DevItems.DRUG_GAMMA);
						})
						.build());

		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ACADEMY_CITY_ABILITY,
				FabricCreativeModeTab.builder()
						.title(Component.translatable("itemGroup." + AcademyCity.MOD_ID + ".ability"))
						.icon(() -> new ItemStack(ElectroMasterItems.ELECTROMASTER_SWORD))
						.displayItems((params, output) -> {
							output.accept(ElectroMasterItems.ELECTROMASTER_SWORD);
							output.accept(ElectroMasterItems.ELECTROMASTER_SHOVEL);
							output.accept(ElectroMasterItems.ELECTROMASTER_PICKAXE);
							output.accept(ElectroMasterItems.ELECTROMASTER_AXE);
							output.accept(ElectroMasterItems.ELECTROMASTER_HOE);

							output.accept(ElectroMasterItems.ELECTROMASTER_SWORD_S);
							output.accept(ElectroMasterItems.ELECTROMASTER_SHOVEL_S);
							output.accept(ElectroMasterItems.ELECTROMASTER_PICKAXE_S);
							output.accept(ElectroMasterItems.ELECTROMASTER_AXE_S);
							output.accept(ElectroMasterItems.ELECTROMASTER_HOE_S);

							output.accept(ElectroMasterItems.ELECTROMASTER_SWORD_X);
							output.accept(ElectroMasterItems.ELECTROMASTER_SHOVEL_X);
							output.accept(ElectroMasterItems.ELECTROMASTER_PICKAXE_X);
							output.accept(ElectroMasterItems.ELECTROMASTER_AXE_X);
							output.accept(ElectroMasterItems.ELECTROMASTER_HOE_X);
						})
						.build());
	}
}
