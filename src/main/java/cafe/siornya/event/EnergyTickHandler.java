package cafe.siornya.event;

import cafe.siornya.attachment.EnergyAttachment;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.level.ServerPlayer;

public class EnergyTickHandler {
	public static void initialize() {
		ServerTickEvents.START_SERVER_TICK.register(server -> {
					for (ServerPlayer player : server.getPlayerList().getPlayers()) {
						EnergyAttachment.add(player, EnergyAttachment.getRegenPerTick(player));
					}
				}
		);
	}
}
