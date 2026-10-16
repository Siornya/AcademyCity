package cafe.siornya.item;

import cafe.siornya.AcademyCity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.BiFunction;

public class DevItems {
	
	public static Item DRUG_ALPHA;
	public static Item DRUG_BETA;
	public static Item DRUG_GAMMA;
	
	private static ResourceKey<Item> keyOf(String id) {
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(AcademyCity.MOD_ID, id));
	}
	
	public static Item register(String id, float effect, BiFunction<Float, Item.Properties, Item> factory, Item.Properties settings) {
		return register(keyOf(id), effect, factory, settings);
	}
	
	public static Item register(ResourceKey<Item> key, float effect, BiFunction<Float, Item.Properties, Item> factory, Item.Properties settings) {
		Item item = factory.apply(effect, settings.setId(key));
		
		return Registry.register(BuiltInRegistries.ITEM, key, item);
	}
	
	public static void initialize() {
		DRUG_ALPHA = register("drug_alpha", 12.5f, DevItem::new, new Item.Properties().stacksTo(16));
		DRUG_BETA = register("drug_beta", 20.0f, DevItem::new, new Item.Properties().stacksTo(16));
		DRUG_GAMMA = register("drug_gamma", 25.0f, DevItem::new, new Item.Properties().stacksTo(16));
	}
}
