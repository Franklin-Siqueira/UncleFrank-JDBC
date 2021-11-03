package controllers.course;

import connections.MySqlConnectionFactory;
import model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseAll {
    public static List<Course> list() {
        // Preparar lista que irá retornar Students após consultar o banco de dados;
        List<Course> courses = new ArrayList<>();

        try (Connection conn = MySqlConnectionFactory.getConnection()) {
            // Preparar consulta SQL.
            String sql = "SELECT * FROM course";

            // Preparar statement com os parâmetros recebidos (nesta função não tem parâmetros, pois irá retornar todos os valores da tabela aluno)
            PreparedStatement stmt = conn.prepareStatement(sql);

            //Executa consulta e armazena o retorno da consulta no objeto "rs".
            ResultSet rs = stmt.executeQuery();

            //Criar um objeto curso e guardar na lista de students.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int duration_hours = rs.getInt("duration_hours");

                courses.add(new Course(id, name, duration_hours));
            }
        } catch (SQLException e) {
            System.out.println("Listagem de students FALHOU!");
            e.printStackTrace();
        }

        //Retornar todos os courses encontrados no banco de dados.
        return courses;
    }
}