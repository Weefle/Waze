package fr.weefle.wazecore;

import fr.weefle.wazeapi.Ping;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandLag implements CommandExecutor {
    public Main main;
    public CommandLag(Main m) {
        this.main = m;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        Ping ping = new Ping();

        if(sender instanceof Player) {

            if(cmd.getName().equalsIgnoreCase("lag")) {

                if(args.length == 1) {

                    for(String s : args) {
                        Player pl = Bukkit.getServer().getPlayer(s);

                        if(Bukkit.getServer().getPlayer(s) == null) {
                            p.sendMessage(main.name + "§4Le joueur §3" + s + " §4n'existe pas ou n'est pas connecté!");
                        }else {
                            p.sendMessage(main.name + "§6Le ping de §3" + s + " §6est de: §2" + ping.getPing(pl) + " ms§6.");
                        }


                    }

                }else {
                    p.sendMessage(main.name + "§6Ton ping est de: §2" + ping.getPing(p) + " ms§6.");
                }


            }

        }

        return true;

    }
}
