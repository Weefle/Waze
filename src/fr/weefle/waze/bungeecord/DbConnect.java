package fr.weefle.waze.bungeecord;

import fr.weefle.waze.bungeecord.DbAccount;
import fr.weefle.waze.spigot.Main;
import net.md_5.bungee.api.ProxyServer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    private Connection connection;
    private DbAccount dbaccount;
    public DbConnect(DbAccount dbaccount){
        this.dbaccount = dbaccount;
        this.connect();
    }
    private void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.dbaccount.toURI(), this.dbaccount.getUser(), this.dbaccount.getPass());
            ProxyServer.getInstance().getLogger().info(Main.instance.name + "§3Connecté à la base de données!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void close() throws SQLException {
        if(this.connection != null){
            if(!this.connection.isClosed()) {
                this.connection.close();
                ProxyServer.getInstance().getLogger().info(Main.instance.name + "§3Déconnecté de la base de données!");
            }
        }
    }
    public Connection getConnection() throws SQLException {
        if(this.connection != null){
            if(!this.connection.isClosed()){
                return this.connection;
            }
        }
        connect();
        return this.connection;
    }
}
