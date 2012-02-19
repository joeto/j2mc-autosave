package to.joe.j2mc.autosave;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;

import to.joe.j2mc.core.J2MC_Manager;

public class AutoSaver implements Runnable {
    Autosave plugin;

    public AutoSaver(Autosave autosave) {
        this.plugin = autosave;
    }

    @Override
    public void run() {
        final Server server = J2MC_Manager.getCore().getServer();
        this.plugin.getLogger().info(ChatColor.AQUA + "Saving players");
        server.savePlayers();
        this.plugin.getLogger().info(ChatColor.AQUA + "Saving worlds");
        for (final World world : server.getWorlds()) {
            this.plugin.getLogger().info(ChatColor.AQUA + "Saved world " + world.getName());
            world.save();
        }
    }
}
