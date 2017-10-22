package fr.weefle.waze;


import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Ping {
    public int getPing(Player p) {

        CraftPlayer pl = (CraftPlayer) p;
        int ping = pl.getHandle().ping;
        return ping;

    }
}
