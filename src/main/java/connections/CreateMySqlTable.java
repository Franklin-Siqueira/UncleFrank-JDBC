package connections;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateMySqlTable {
    public static void main(String[] args) {
        try (Connection conn = MySqlConnectionFactory.getConnection();
             // Prepare statement with statement variable 'sql'
             Statement stmt = conn.createStatement();) {
            // Prepare SQL statement
            String sql = "CREATE TABLE StateX " +
                    " ( id INT(64) AUTO_INCREMENT, " +
                    " name VARCHAR(80) NOT NULL, " +
                    " symbol CHAR(2) NOT NULL, " +
                    " PRIMARY KEY (`id`))";
            //Execute statement (with 'executeUpdate'), create table.
            stmt.executeUpdate(sql);
            System.out.println("New Table Created!...");
        } catch (SQLException e) {
            System.out.println("Table Creation Failed!");
            e.printStackTrace();
        }
    }
}