package to.joe.j2mc.autosave;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class J2MC_Autosave extends JavaPlugin {

    @Override
    public void onDisable() {
        this.getLogger().info("Autosaver disabled");
    }

    @Override
    public void onEnable() {
        this.getLogger().info("Autosaver enabled");
        this.getCommand("forcesave").setExecutor(new ForceSaveCommand(this));
    }
    
    public void save(){
        this.getLogger().info(ChatColor.AQUA + "Saving players");
        this.getServer().savePlayers();
        this.getLogger().info(ChatColor.AQUA + "Saving worlds");
        for (final World world : this.getServer().getWorlds()) {
            this.getLogger().info(ChatColor.AQUA + "Saved world " + world.getName());
            world.save();
        }
    }

}
