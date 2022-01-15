package utills;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    public static final String dbUser = "postgres"; //user
    public static final String dbPassword = ""; //parol
    static String url; //murojaat yo'li
    static String host = "localhost"; //kun.uz //192.168.22.11

    static String dbName = "werhous";
    static String port = "5432"; //postgres  //oracle //345 //mysql// 123

    public static Connection ulanish () {
        Connection connection = null;
        url = "jdbc:postgresql://" + host + ":" + port + "/" + dbName;

        try {
            Class.forName("org.postgresql.Driver");
            try {
                connection = DriverManager.getConnection(url,dbUser,dbPassword);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;

    }

}
