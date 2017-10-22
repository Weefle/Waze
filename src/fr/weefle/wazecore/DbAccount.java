package fr.weefle.wazecore;

public class DbAccount {
    private String host;
    private String user;
    private String pass;
    private String dbname;
    private int port;

    public DbAccount(String host, String user, String pass, String dbname, int port) {
        this.host = host;
        this.user = user;
        this.pass = pass;
        this.dbname = dbname;
        this.port = port;
    }

    public String toURI(){
        final StringBuilder sb = new StringBuilder();
        sb.append("jdbc:mysql://").append(host).append(":").append(port).append("/").append(dbname);
        return sb.toString();
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
