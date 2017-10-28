package fr.weefle.waze.spigot;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public String name;
    public static Main instance;
    private DbManager dbmanager;

    @Override
    public void onEnable() {
        instance = this;
        getCommand("lag").setExecutor(new LagCommand(this));
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new MessageListener());
        name = "§8[§cWaze§8] ";
        dbmanager = new DbManager();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.dbmanager.close();
        super.onDisable();
    }

    public DbManager getDbmanager() {
        return dbmanager;
    }
}
