package cafe.siornya.item;

import cafe.siornya.AcademyCity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.BiFunction;

public class ElectroMasterItems {

	public static Item ELECTROMASTER_SWORD;
	public static Item ELECTROMASTER_SHOVEL;
	public static Item ELECTROMASTER_PICKAXE;
	public static Item ELECTROMASTER_AXE;
	public static Item ELECTROMASTER_HOE;

	public static Item ELECTROMASTER_SWORD_S;
	public static Item ELECTROMASTER_SHOVEL_S;
	public static Item ELECTROMASTER_PICKAXE_S;
	public static Item ELECTROMASTER_AXE_S;
	public static Item ELECTROMASTER_HOE_S;

	public static Item ELECTROMASTER_SWORD_X;
	public static Item ELECTROMASTER_SHOVEL_X;
	public static Item ELECTROMASTER_PICKAXE_X;
	public static Item ELECTROMASTER_AXE_X;
	public static Item ELECTROMASTER_HOE_X;

	private static ResourceKey<Item> keyOf(String id) {
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(AcademyCity.MOD_ID, id));
	}

	public static Item register(String id, float electroMasterDamage, BiFunction<Float, Item.Properties, Item> factory, Item.Properties settings) {
		return register(keyOf(id), electroMasterDamage, factory, settings);
	}

	public static Item register(ResourceKey<Item> key, float electroMasterDamage, BiFunction<Float, Item.Properties, Item> factory, Item.Properties settings) {
		Item item = factory.apply(electroMasterDamage, settings.setId(key));

		return Registry.register(BuiltInRegistries.ITEM, key, item);
	}

	public static void initialize() {
		ELECTROMASTER_SWORD = register("electromaster_sword", 6.0F, ElectroMasterItem::new, (new Item.Properties()).sword(ElectroMasterMaterial.ELECTROMASTER_MATERIAL, 0.0F, -2.4F));
		ELECTROMASTER_SHOVEL = register("electromaster_shovel", 4.5F, ElectroMasterItem::new, (new Item.Properties()).shovel(ElectroMasterMaterial.ELECTROMASTER_MATERIAL, 0.0F, -2.4F));
		ELECTROMASTER_PICKAXE = register("electromaster_pickaxe", 4.0F, ElectroMasterItem::new, (new Item.Properties()).pickaxe(ElectroMasterMaterial.ELECTROMASTER_MATERIAL, 0.0F, -2.8F));
		ELECTROMASTER_AXE = register("electromaster_axe", 9.0F, ElectroMasterItem::new, (new Item.Properties()).axe(ElectroMasterMaterial.ELECTROMASTER_MATERIAL, 0.0F, -2.8F));
		ELECTROMASTER_HOE = register("electromaster_hoe", 1.0F, ElectroMasterItem::new, (new Item.Properties()).hoe(ElectroMasterMaterial.ELECTROMASTER_MATERIAL, 0.0F, -2.8F));

		ELECTROMASTER_SWORD_S = register("electromaster_sword_s", 7.0F, ElectroMasterItem::new, (new Item.Properties()).sword(ElectroMasterMaterial.ELECTROMASTER_MATERIAL_S, 0.0F, -2.4F));
		ELECTROMASTER_SHOVEL_S = register("electromaster_shovel_s", 5.5F, ElectroMasterItem::new, (new Item.Properties()).shovel(ElectroMasterMaterial.ELECTROMASTER_MATERIAL_S, 0.0F, -2.4F));
		ELECTROMASTER_PICKAXE_S = register("electromaster_pickaxe_s", 5.0F, ElectroMasterItem::new, (new Item.Properties()).pickaxe(ElectroMasterMaterial.ELECTROMASTER_MATERIAL_S, 0.0F, -2.8F));
		ELECTROMASTER_AXE_S = register("electromaster_axe_s", 9.0F, ElectroMasterItem::new, (new Item.Properties()).axe(ElectroMasterMaterial.ELECTROMASTER_MATERIAL_S, 0.0F, -2.8F));
		ELECTROMASTER_HOE_S = register("electromaster_hoe_s", 1.0F, ElectroMasterItem::new, (new Item.Properties()).hoe(ElectroMasterMaterial.ELECTROMASTER_MATERIAL_S, 0.0F, -2.8F));

		ELECTROMASTER_SWORD_X = register("electromaster_sword_x", 8.0F, ElectroMasterItem::new, (new Item.Properties()).sword(ElectroMasterMaterial.ELECTROMASTER_MATERIAL_X, 0.0F, -2.4F));
		ELECTROMASTER_SHOVEL_X = register("electromaster_shovel_x", 6.5F, ElectroMasterItem::new, (new Item.Properties()).shovel(ElectroMasterMaterial.ELECTROMASTER_MATERIAL_X, 0.0F, -2.4F));
		ELECTROMASTER_PICKAXE_X = register("electromaster_pickaxe_x", 6.0F, ElectroMasterItem::new, (new Item.Properties()).pickaxe(ElectroMasterMaterial.ELECTROMASTER_MATERIAL_X, 0.0F, -2.8F));
		ELECTROMASTER_AXE_X = register("electromaster_axe_x", 10.0F, ElectroMasterItem::new, (new Item.Properties()).axe(ElectroMasterMaterial.ELECTROMASTER_MATERIAL_X, 0.0F, -2.8F));
		ELECTROMASTER_HOE_X = register("electromaster_hoe_x", 1.0F, ElectroMasterItem::new, (new Item.Properties()).hoe(ElectroMasterMaterial.ELECTROMASTER_MATERIAL_X, 0.0F, -2.8F));
	}
}
