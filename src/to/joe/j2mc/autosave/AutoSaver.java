package to.joe.j2mc.autosave;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;

import to.joe.j2mc.core.J2MC_Core;
import to.joe.j2mc.core.J2MC_Manager;

public class AutoSaver implements Runnable {
	
	private Autosave autosave;
	private J2MC_Core core = new J2MC_Core();
	private J2MC_Manager manager;
	
	public AutoSaver(Autosave autosave) {
        this.autosave = autosave;
    }

	@Override
	public void run() {
		final Server server = this.core.getServer();
        this.autosave.logInfo(ChatColor.AQUA + "Saving players");
        server.savePlayers();
        this.autosave.logInfo(ChatColor.AQUA + "Saving worlds");
        for (final World world : server.getWorlds()) {
            this.autosave.logInfo(ChatColor.AQUA + "Saved world " + world.getName());
            world.save();
        }
	}

}
