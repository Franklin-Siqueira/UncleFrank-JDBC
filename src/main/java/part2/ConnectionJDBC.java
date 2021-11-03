package part2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    public static void main(String[] args) {
        String driver = "mysql";
        String dataBaseAddress = "localhost";
        String dataBaseName = "dio";
        String user = "root";
        String password = "245353f10@M!";

        StringBuilder Sb = new StringBuilder("jdbc:")
                .append(driver)
                .append("://")
                .append(dataBaseAddress)
                .append("/")
                .append(dataBaseName);

        String connectionUrl = Sb.toString(); // sb.toString() == "jdbc:mysql://localhost/dio"

        // 4 - Criar conexão usando o DriverManager, passando como parâmetros a string de conexão, usuário e senha do usuário.
        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            System.out.println("SUCESSO ao se conectar ao banco MySQL!");
        } catch (SQLException e) {
            System.out.println("FALHA ao se conectar ao banco MySQL!");
            e.printStackTrace();
        }
    }
}
