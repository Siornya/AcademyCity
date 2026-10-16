package cafe.siornya.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import cafe.siornya.attachment.DevAttachment;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.permissions.Permission;
import net.minecraft.server.permissions.PermissionLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public final class DevCommand {
	
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher,
								CommandBuildContext registryAccess,
								Commands.CommandSelection environment) {
		
		dispatcher.register(Commands.literal("dev_progress")
				.requires(source -> source.permissions()
						.hasPermission(new Permission.HasCommandLevel(PermissionLevel.GAMEMASTERS)))
				
				.then(Commands.literal("get")
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
							
							float cur = DevAttachment.get(player);
							src.sendSuccess(() ->
											Component.translatable("command.academy-city.dev_progress.get.success", cur),
									true
							);
							return 1;
						})
				)
				
				.then(Commands.literal("set")
						.then(Commands.argument("value", FloatArgumentType.floatArg(0f, 100f))
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
									
									float v = FloatArgumentType.getFloat(ctx, "value");
									DevAttachment.set(player, v);
									
									src.sendSuccess(() ->
													Component.translatable("command.academy-city.dev_progress.set.success", v),
											true
									);
									return 1;
								})
						)
				)
				
				.then(Commands.literal("add")
						.then(Commands.argument("delta", FloatArgumentType.floatArg(-100f, 100f))
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
									
									float delta = FloatArgumentType.getFloat(ctx, "delta");
									DevAttachment.add(player, delta);
									
									float cur = DevAttachment.get(player);
									src.sendSuccess(() ->
													Component.translatable("command.academy-city.dev_progress.add.success", cur),
											true
									);
									return 1;
								})
						)
				)
		);
	}
}
