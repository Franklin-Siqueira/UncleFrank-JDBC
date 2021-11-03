package controllers.course;

import connections.MySqlConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseDelete {
    public void delete(int id) {
        try (Connection conn = MySqlConnectionFactory.getConnection()) {
            // Preparar SQL para deletar uma linha.
            String sql = "DELETE FROM course WHERE id = ?";
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
