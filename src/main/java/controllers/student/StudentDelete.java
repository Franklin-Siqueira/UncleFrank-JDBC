package controllers.student;

import connections.MySqlConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDelete {
    public void delete(int id) {
        try (Connection conn = MySqlConnectionFactory.getConnection()) {
            // Preparar SQL para deletar uma linha.
            String sql = "DELETE FROM student WHERE id = ?";
            // Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1 , id);
            // Executa delete e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Delete BEM SUCEDIDA! Foi deletada " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Delete FALHOU!");
            e.printStackTrace();
        }
    }
}
