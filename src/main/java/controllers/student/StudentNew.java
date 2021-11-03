package controllers.student;

import connections.MySqlConnectionFactory;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentNew {
    public static void create(Student student) {

        try (Connection conn = MySqlConnectionFactory.getConnection()) {
            //Preparar SQL para inserção de dados do aluno.
            String sql = "INSERT INTO student(name, age, state) VALUES(?, ?, ?)";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1 , student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3 , student.getState());

            //Executa inserção e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Inserção BEM SUCEDIDA!. Foi adicionada " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Inserção FALHOU!");
            e.printStackTrace();
        }
    }
}
