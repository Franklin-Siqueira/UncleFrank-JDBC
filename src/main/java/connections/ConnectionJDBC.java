package connections;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionJDBC {
    public static void main(String[] args) {
        // Create an input stream from the properties defined in the file
        // accessed with .getResourceAsStream
        try (InputStream input = ConnectionJDBC.class.getClassLoader().getResourceAsStream("connection.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAddress = prop.getProperty("db.address");
            String dataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");

            // Before using connection.properties settings
//            String driver = "mysql";
//            String dataBaseAddress = "localhost";
//            String dataBaseName = "dio";
//            String user = "root";
//            String password = "2...!";

            StringBuilder Sb = new StringBuilder("jdbc:")
                    .append(driver)
                    .append("://")
                    .append(dataBaseAddress)
                    .append("/")
                    .append(dataBaseName);

            String connectionUrl = Sb.toString(); // sb.toString() == "jdbc:mysql://localhost/dio"

            // Criar conexão usando o DriverManager,
            // passando como parâmetros a string de conexão, usuário e senha do usuário.
            // Create connection using DriverManager
            try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
                System.out.println("Success! Connected to MySQL Table...");
            } catch (SQLException e) {
                System.out.println("MySQL connection failed!...");
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("Failed to connect to properties' file!...");
            e.printStackTrace();
        }
    }
}
