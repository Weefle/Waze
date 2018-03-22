package fr.weefle.waze.bungeecord;

import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {
    private DbManager dbmanager;
    public String name;
    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        name = "§8[§cWaze§8] ";
        getProxy().registerChannel("BungeeCord");
        getProxy().getPluginManager().registerCommand(this, new AdvertCommand());
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
