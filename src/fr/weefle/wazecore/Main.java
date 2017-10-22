package fr.weefle.wazecore;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class Main extends JavaPlugin {
    public String name;
    private DbManager dbmanager;

    @Override
    public void onEnable() {
        getCommand("lag").setExecutor(new CommandLag(this));
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
