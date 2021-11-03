package controllers.course;

import connections.MySqlConnectionFactory;
import model.Course;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseOriginal {

    // 1 - Consulta
    public List<Course> list() {
        //Preparar lista que irá retornar alunos após consultar o banco de dados;
        List<Course> courses = new ArrayList<>();

        try (Connection conn = MySqlConnectionFactory.getConnection()) {
            //Preparar consulta SQL.
            String sql = "SELECT * FROM course";

            //Preparar statement com os parâmetros recebidos (nesta função não tem parâmetros, pois irá retornar todos os valores da tabela aluno)
            PreparedStatement stmt = conn.prepareStatement(sql);

            //Executa consulta e armazena o retorno da consulta no objeto "rs".
            ResultSet rs = stmt.executeQuery();

            //Criar um objeto curso e guardar na lista de alunos.
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int duration_hours = rs.getInt("duration_hours");

                courses.add(new Course(
                        id,
                        name,
                        duration_hours
                ));
            }
        } catch (SQLException e) {
            System.out.println("Listagem de cursos FALHOU!");
            e.printStackTrace();
        }

        //Retornar todos os alunos encontrados no banco de dados.
        return courses;
    }

    // 1.1 - Consulta com filtro
    public Course getById(int id) {
        //Preparar objeto aluno para receber os valores do banco de dados.
        Course course = new Course();

        try (Connection conn = MySqlConnectionFactory.getConnection()) {
            //Preparar consulta SQL
            String sql = "SELECT * FROM course WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //Executa consulta e armazena o retorno da consulta no objeto "rs".
            ResultSet rs = stmt.executeQuery();

            //Guardar valores retornados da tabela course no objeto course
            if (rs.next()){
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setDurationHours(rs.getInt("duration_hours"));
            }

        } catch (SQLException e) {
            System.out.println("Listagem de alunos FALHOU!");
            e.printStackTrace();
        }

        //Retorna aluno encontrado no banco de dados.
        return course;
    }

    // 2 - Inserção
    public void create(Course course) {
        try (Connection conn = MySqlConnectionFactory.getConnection()) {

            //Preparar SQL para inserção de dados do aluno.
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

    // 3 - Delete
    public void delete(int id) {
        try (Connection conn = MySqlConnectionFactory.getConnection()) {

            //Preparar SQL para deletar uma linha.
            String sql = "DELETE FROM course WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1 , id);

            //Executa delete e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Delete BEM SUCEDIDA! Foi deletada " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Delete FALHOU!");
            e.printStackTrace();
        }
    }

    // 4 - Atualizar
    public void update(Course course) {
        try (Connection conn = MySqlConnectionFactory.getConnection()) {

            //Preparar SQL para atualizar linhas.
            String sql = "UPDATE student SET name = ?, age = ?, state = ? WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, course.getName());
            stmt.setInt(2, course.getDurationHours());
            stmt.setInt(4, course.getId());

            //Executa atualização e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Atualização BEM SUCEDIDA! Foi atualizada: " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Atualização FALHOU!");
            e.printStackTrace();
        }
    }

}
