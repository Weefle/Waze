package fr.weefle.waze.bungeecord;

import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {
    private DbManager dbmanager;

    @Override
    public void onEnable() {
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
