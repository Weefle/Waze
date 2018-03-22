package fr.weefle.waze.spigot;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
    public String name;
    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        getCommand("lag").setExecutor(new LagCommand(this));
        getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new MessageListener());
        name = "§8[§cWaze§8] ";
        super.onEnable();
    }

}
