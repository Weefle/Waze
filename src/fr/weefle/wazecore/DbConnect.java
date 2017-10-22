package fr.weefle.wazecore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

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
            Logger.getLogger("Minecraft").info("Connecté à la base de données!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void close() throws SQLException {
        if(this.connection != null){
            if(!this.connection.isClosed()) {
                this.connection.close();
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
