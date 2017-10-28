package fr.weefle.waze.bungeecord;

import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

    @Override
    public void onEnable() {
        getProxy().registerChannel("BungeeCord");
        getProxy().getPluginManager().registerCommand(this, new AdvertCommand());
        super.onEnable();
    }
}
