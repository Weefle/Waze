package fr.weefle.waze;

import java.sql.SQLException;

public class DbManager {
    private DbConnect dbconnect;
    public DbManager(){
        this.dbconnect = new DbConnect(new DbAccount("mysql-weefle.alwaysdata.net", "weefle", "mrdata650", "weefle_data", 3306));
    }
    public void close(){
        try {
            this.dbconnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
