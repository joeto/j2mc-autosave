package to.joe.j2mc.autosave;

import org.bukkit.plugin.java.JavaPlugin;

import to.joe.j2mc.core.*;

public class Autosave extends JavaPlugin {
	
	private ForceSaveCommand CExec = new ForceSaveCommand(this);
	
	@Override
	public void onDisable() {
		J2MC_Manager.getLog().info("Autosaver disabled");
	}

	@Override
	public void onEnable() {
		J2MC_Manager.getLog().info("Autosaver enabled");
		
		this.getServer().getScheduler().scheduleSyncRepeatingTask(this, Autosave.getSaver(), 1, 6000);
		this.getCommand("forcesave").setExecutor(this.CExec);
	}
	
	public static AutoSaver getSaver(){
		return new AutoSaver();
	}
}
