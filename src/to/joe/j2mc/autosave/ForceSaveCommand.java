package to.joe.j2mc.autosave;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import to.joe.j2mc.core.J2MC_Core;
import to.joe.j2mc.core.command.MasterCommand;


public class ForceSaveCommand extends MasterCommand{
	
	private AutoSaver saver;
	private Autosave main;
	private J2MC_Core core;

	public ForceSaveCommand(JavaPlugin plugin) {
		super(plugin);
	}

	@Override
	public void exec(CommandSender sender, String commandName, String[] args, Player player, String playerName, boolean isPlayer) {
		if(isPlayer) {
			//player
			if(sender.hasPermission("J2MC.AutoSave")) {
				//perms
				if(args.length == 0) {
					//no args
					saver.run();
					core.adminAndLog(ChatColor.AQUA + playerName + " forced a save with no given reason");
				} else {
					//reason
					saver.run();
					String reason = J2MC_Core.combineSplit(0, args, " ");
					core.adminAndLog(ChatColor.AQUA + playerName + " forced a save with the reason: " + reason);
				}
			} else {
				//no perms
				sender.sendMessage(ChatColor.RED + "Your hat is not the right type");
			}
		} else {
			//console
		}
	}

}
