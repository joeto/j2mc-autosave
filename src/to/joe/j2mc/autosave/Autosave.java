package to.joe.j2mc.autosave;

import org.bukkit.plugin.java.JavaPlugin;

public class Autosave extends JavaPlugin {

    public AutoSaver runner = new AutoSaver(this);

    @Override
    public void onDisable() {
        this.getLogger().info("Autosaver disabled");
        this.runner.run();
    }

    @Override
    public void onEnable() {
        this.getLogger().info("Autosaver enabled");
        this.getCommand("forcesave").setExecutor(new ForceSaveCommand(this));
    }

}
