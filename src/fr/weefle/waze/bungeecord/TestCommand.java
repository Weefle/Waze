package fr.weefle.waze.bungeecord;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class TestCommand extends Command {

    public TestCommand() {
        super("test");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(sender instanceof ProxiedPlayer){//joueur
            ProxiedPlayer p = (ProxiedPlayer) sender;
            p.sendMessage(new TextComponent(p.getPing() + ""));
        }else{
            sender.sendMessage(new TextComponent("§4nan!"));
        }

    }
}
