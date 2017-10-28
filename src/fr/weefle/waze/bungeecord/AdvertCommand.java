package fr.weefle.waze.bungeecord;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.Title;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class AdvertCommand extends Command {

    public AdvertCommand() {
        super("advert", "waze.advert");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        ProxiedPlayer p = (ProxiedPlayer) sender;

        if(sender instanceof ProxiedPlayer){
            if(args.length == 1){
                if(args[0] != null){
                    Title title = ProxyServer.getInstance().createTitle();
                    title.title(new TextComponent("§4" + args[0]));
                    for(ProxiedPlayer pl : ProxyServer.getInstance().getPlayers()){
                        title.send(pl);
                    }
                }else{
                    p.sendMessage(new TextComponent("§4Tu n'as pas entré de phrase!"));
                }
            }else{
                p.sendMessage(new TextComponent("§4Il y a trop ou pas assez d'argument(s)!"));
            }

        }else{
            sender.sendMessage(new TextComponent("§4Tu n'es pas un joueur!"));
        }

    }
}
