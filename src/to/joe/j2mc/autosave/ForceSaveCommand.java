package to.joe.j2mc.autosave;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import to.joe.j2mc.core.J2MC_Manager;
import to.joe.j2mc.core.command.MasterCommand;

public class ForceSaveCommand extends MasterCommand{
	
	public ForceSaveCommand(JavaPlugin plugin) {
		super(plugin);
	}

	@Override
	public void exec(CommandSender sender, String commandName, String[] args, Player player, String playerName, boolean isPlayer) {
		if(sender.hasPermission("j2mc.forcesave") || !isPlayer) {
			J2MC_Manager.getCore().adminAndLog(ChatColor.AQUA + sender.getName() + " forced a save");
			Autosave.getSaver().run();
		} else {
			sender.sendMessage(ChatColor.RED + "Incorrect hat type");
		}
	}

}
