package cafe.siornya.command;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class ModCommands {
	public static void initialize() {
		CommandRegistrationCallback.EVENT.register(DevCommand::register);
		CommandRegistrationCallback.EVENT.register(AbilityCommand::register);
	}
}
