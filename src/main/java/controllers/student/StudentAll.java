package controllers.student;

import connections.MySqlConnectionFactory;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentAll {
    public static List<Student> list() {
        // Preparar lista que irá retornar Students após consultar o banco de dados;
        List<Student> students = new ArrayList<>();

        try (Connection conn = MySqlConnectionFactory.getConnection()) {
            // Preparar consulta SQL.
            String sql = "SELECT * FROM student";

            // Preparar statement com os parâmetros recebidos (nesta função não tem parâmetros, pois irá retornar todos os valores da tabela aluno)
            PreparedStatement stmt = conn.prepareStatement(sql);

            //Executa consulta e armazena o retorno da consulta no objeto "rs".
            ResultSet rs = stmt.executeQuery();

            //Criar um objeto aluno e guardar na lista de students.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String state = rs.getString("state");

                students.add(new Student(id, name, age, state));
            }
        } catch (SQLException e) {
            System.out.println("Listagem de students FALHOU!");
            e.printStackTrace();
        }

        //Retornar todos os students encontrados no banco de dados.
        return students;
    }
}