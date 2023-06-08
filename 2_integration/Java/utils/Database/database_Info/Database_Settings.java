package utils.Database.database_Info;

public class Database_Settings {
    public final String ip = "@localhost"; //Standart
    public final String schema;
    public final String username;
    public final String password;

    public Database_Settings(String schema, String username, String password) {
        this.schema = schema;
        this.username = username;
        this.password = password;
    }
}
