package cafe.siornya.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import cafe.siornya.attachment.AbilityAttachment;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public final class AbilityCommand {
	
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher,
								CommandBuildContext registryAccess,
								Commands.CommandSelection environment) {
		
		dispatcher.register(Commands.literal("ability")
				
				.then(Commands.literal("getlevel")
						.executes(ctx -> {
							CommandSourceStack src = ctx.getSource();
							Entity e = src.getEntity();
							
							if (!(e instanceof Player player)) {
								src.sendSuccess(() ->
												Component.translatable("command.academy-city.player_only"),
										false
								);
								return 0;
							}
							
							int cur = AbilityAttachment.getLevel(player);
							src.sendSuccess(() ->
											Component.translatable("command.academy-city.level.get.success", cur),
									true
							);
							return 1;
						})
				)
				
				.then(Commands.literal("setlevel")
						.then(Commands.argument("value", IntegerArgumentType.integer(0, 6))
								.executes(ctx -> {
									CommandSourceStack src = ctx.getSource();
									Entity e = src.getEntity();
									
									if (!(e instanceof Player player)) {
										src.sendSuccess(() ->
														Component.translatable("command.academy-city.player_only"),
												false
										);
										return 0;
									}
									
									int v = IntegerArgumentType.getInteger(ctx, "value");
									AbilityAttachment.setLevel(player, v);
									
									src.sendSuccess(() ->
													Component.translatable("command.academy-city.level.set.success", v),
											true
									);
									return 1;
								})
						)
				)
		);
	}
}
