package to.joe.j2mc.autosave;

import org.bukkit.plugin.java.JavaPlugin;

public class Autosave extends JavaPlugin {
	
	private ForceSaveCommand CExec = new ForceSaveCommand(this);
	public AutoSaver runner = new AutoSaver(this);
	@Override
	public void onDisable() {
		this.getLogger().info("Autosaver disabled");
		runner.run();
	}

	@Override
	public void onEnable() {
		this.getLogger().info("Autosaver enabled");
		this.getServer().getScheduler().scheduleSyncRepeatingTask(this, runner, 1, 6000);
		this.getCommand("forcesave").setExecutor(this.CExec);
	}
	

}
