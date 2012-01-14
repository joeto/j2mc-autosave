package to.joe.j2mc.autosave;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;

import to.joe.j2mc.core.J2MC_Manager;

public class AutoSaver implements Runnable {
	
	public void run(){
		final Server server = J2MC_Manager.getCore().getServer();
        J2MC_Manager.getLog().info(ChatColor.AQUA + "Saving players");
        server.savePlayers();
        J2MC_Manager.getLog().info(ChatColor.AQUA + "Saving worlds");
        for (final World world : server.getWorlds()) {
        	J2MC_Manager.getLog().info(ChatColor.AQUA + "Saved world " + world.getName());
            world.save();
        }
	}
}
