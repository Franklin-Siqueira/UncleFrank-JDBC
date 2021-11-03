package controllers.course;

import connections.MySqlConnectionFactory;
import model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseUpdate {
    public static void update(Course course) {
        try (Connection conn = MySqlConnectionFactory.getConnection()) {
            // Preparar SQL para atualizar linhas.
            String sql = "UPDATE course SET name = ?, duration_hours = ? WHERE id = ?";
            // Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, course.getName());
            stmt.setInt(2, course.getDurationHours());
            stmt.setInt(4, course.getId());
            // Executa atualização e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Atualização BEM SUCEDIDA! Foi atualizada: " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Atualização FALHOU!");
            e.printStackTrace();
        }
    }
}
