package fr.weefle.wazecore;

import java.sql.SQLException;

public class DbManager {
    private DbConnect rankconnect;
    public DbManager(){
        this.rankconnect = new DbConnect(new DbAccount("mysql-weefle.alwaysdata.net", "weefle", "mrdata650", "weefle_data", 3306));
    }
    public void close(){
        try {
            this.rankconnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
