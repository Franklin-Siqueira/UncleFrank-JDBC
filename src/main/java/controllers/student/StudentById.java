package controllers.student;

import connections.MySqlConnectionFactory;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentById {
    public static Student getById(int id) {
        //Preparar objeto aluno para receber os valores do banco de dados.
        Student student = new Student();

        try (Connection conn = MySqlConnectionFactory.getConnection()) {
            // Preparar consulta SQL
            String sql = "SELECT * FROM student WHERE id = ?";

            // Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            // Executa consulta e armazena o retorno da consulta no objeto "rs".
            ResultSet rs = stmt.executeQuery();

            // Guardar valores retornados da tabela aluno no objeto aluno
            if (rs.next()){
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setState(rs.getString("state"));
            }

        } catch (SQLException e) {
            System.out.println("Listagem de alunos FALHOU!");
            e.printStackTrace();
        }

        //Retorna aluno encontrado no banco de dados.
        return student;
    }
}
