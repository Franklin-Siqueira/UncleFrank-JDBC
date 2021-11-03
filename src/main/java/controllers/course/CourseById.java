package controllers.course;

import connections.MySqlConnectionFactory;
import model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseById {
    public static Course getById(int id) {
        //Preparar objeto aluno para receber os valores do banco de dados.
        Course course = new Course();

        try (Connection conn = MySqlConnectionFactory.getConnection()) {
            // Preparar consulta SQL
            String sql = "SELECT * FROM course WHERE id = ?";

            // Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            // Executa consulta e armazena o retorno da consulta no objeto "rs".
            ResultSet rs = stmt.executeQuery();

            // Guardar valores retornados da tabela aluno no objeto aluno
            if (rs.next()){
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setDurationHours(rs.getInt("duration_hours"));
            }

        } catch (SQLException e) {
            System.out.println("Listagem de cursos FALHOU!");
            e.printStackTrace();
        }

        //Retorna aluno encontrado no banco de dados.
        return course;
    }
}
