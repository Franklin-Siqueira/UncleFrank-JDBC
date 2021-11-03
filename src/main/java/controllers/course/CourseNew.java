package controllers.course;

import connections.MySqlConnectionFactory;
import model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseNew {
    public static void create(Course course) {

        try (Connection conn = MySqlConnectionFactory.getConnection()) {
            //Preparar SQL para inserção de dados do curso.
            String sql = "INSERT INTO course(name, duration_hours) VALUES(?, ?)";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1 , course.getName());
            stmt.setInt(2, course.getDurationHours());

            //Executa inserção e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Inserção BEM SUCEDIDA!. Foi adicionada " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Inserção FALHOU!");
            e.printStackTrace();
        }
    }
}
