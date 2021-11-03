package controllers.student;

import connections.MySqlConnectionFactory;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentUpdate {
    public static void update(Student student) {
        try (Connection conn = MySqlConnectionFactory.getConnection()) {
            // Preparar SQL para atualizar linhas.
            String sql = "UPDATE student SET name = ?, age = ?, state = ? WHERE id = ?";
            // Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getState());
            stmt.setInt(4, student.getId());
            // Executa atualização e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Atualização BEM SUCEDIDA! Foi atualizada: " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Atualização FALHOU!");
            e.printStackTrace();
        }
    }
}
