package cafe.siornya.item;

import cafe.siornya.AcademyCity;
import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class Foods {
	public static Item CHOCOLATE;
	public static Item BLUEBERRY;
	public static Item CREAMCHEESE;
	public static Item FRUIT_TART_OF_SEASON;
	public static Item STRAWBERRY_CROSTATA;
	public static Item MONTE_BIANCO;
	public static Item CHOCOLATE_TART;

	private static ResourceKey<Item> keyOf(String id) {
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(AcademyCity.MOD_ID, "food." + id));
	}

	public static Item register(String id, Function<Item.Properties, Item> factory, Item.Properties settings) {
		return register(keyOf(id), factory, settings);
	}

	public static Item register(ResourceKey<Item> key, Function<Item.Properties, Item> factory, Item.Properties settings) {
		Item item = factory.apply(settings.setId(key));
		return Registry.register(BuiltInRegistries.ITEM, key, item);
	}

	public static void initialize() {
		CHOCOLATE = register("chocolate", settings -> new Item(settings.food(new FoodProperties.Builder()
				.nutrition(4).saturationModifier(0.4f).alwaysEdible().build())), new Item.Properties().stacksTo(64));
		BLUEBERRY = register("blueberry", settings -> new Item(settings.food(new FoodProperties.Builder()
				.nutrition(2).saturationModifier(0.3f).alwaysEdible().build())), new Item.Properties().stacksTo(64));
		CREAMCHEESE = register("creamcheese", settings -> new Item(settings.food(new FoodProperties.Builder()
				.nutrition(3).saturationModifier(0.5f).alwaysEdible().build())), new Item.Properties().stacksTo(1));
		FRUIT_TART_OF_SEASON = register("fruit_tart_of_season", settings -> new Item(settings.food(new FoodProperties.Builder()
				.nutrition(6).saturationModifier(0.6f).alwaysEdible().build())), new Item.Properties().stacksTo(1));
		STRAWBERRY_CROSTATA = register("strawberry_crostata", settings -> new Item(settings.food(new FoodProperties.Builder()
				.nutrition(7).saturationModifier(0.7f).alwaysEdible().build())), new Item.Properties().stacksTo(16));
		MONTE_BIANCO = register("monte_bianco", settings -> new Item(settings.food(new FoodProperties.Builder()
				.nutrition(8).saturationModifier(0.8f).alwaysEdible().build())), new Item.Properties().stacksTo(1));
		CHOCOLATE_TART = register("chocolate_tart", settings -> new Item(settings.food(new FoodProperties.Builder()
				.nutrition(6).saturationModifier(0.6f).alwaysEdible().build())), new Item.Properties().stacksTo(16));
	}
}
