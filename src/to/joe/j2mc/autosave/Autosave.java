package to.joe.j2mc.autosave;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import to.joe.j2mc.core.*;

public class Autosave extends JavaPlugin {
	
	private J2MC_Core core;
	private J2MC_Manager manager;
	private AutoSaver saver = new AutoSaver(this);
	private ForceSaveCommand CExec = new ForceSaveCommand(this);
	
	Logger log = Logger.getLogger("Minecraft");

	@Override
	public void onDisable() {
		saver.run();
		this.logInfo("[J2] AutoSaver disabled");
		
	}

	@Override
	public void onEnable() {
		
		this.logInfo("[J2] AutoSaver enabled");
		
		this.getServer().getScheduler().scheduleSyncRepeatingTask(this, this.saver, 1, 6000);
		this.getCommand("forcesave").setExecutor(CExec);
	}
	
	public void logInfo(String message){
		this.log.info(message);
	}

}
