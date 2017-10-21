package fr.weefle.wazecore;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public String name;

    @Override
    public void onEnable() {
        getCommand("lag").setExecutor(new CommandLag(this));
        name = "§8[§cWaze§8] ";
        super.onEnable();
        super.onEnable();
    }
}
