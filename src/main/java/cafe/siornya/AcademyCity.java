package cafe.siornya;

import cafe.siornya.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AcademyCity implements ModInitializer {
	public static final String MOD_ID = "academy-city";
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
	@Override
	public void onInitialize() {
		ModItems.initialize();
		
		LOGGER.info("Academy City initialized.");
	}
	
	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
