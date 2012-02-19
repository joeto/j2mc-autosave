package to.joe.j2mc.autosave;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import to.joe.j2mc.core.J2MC_Manager;
import to.joe.j2mc.core.command.MasterCommand;

public class ForceSaveCommand extends MasterCommand {

    Autosave plugin;

    public ForceSaveCommand(Autosave plugin) {
        super(plugin);
        this.plugin = plugin;
    }

    @Override
    public void exec(CommandSender sender, String commandName, String[] args, Player player, boolean isPlayer) {
        if (sender.hasPermission("j2mc.forcesave") || !isPlayer) {
            J2MC_Manager.getCore().adminAndLog(ChatColor.AQUA + sender.getName() + " forced a save");
            this.plugin.runner.run();
        } else {
            sender.sendMessage(ChatColor.RED + "Incorrect hat type");
        }
    }

}
