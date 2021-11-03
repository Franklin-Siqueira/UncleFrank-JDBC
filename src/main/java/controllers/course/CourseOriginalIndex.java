package controllers.course;

import controllers.student.StudentOriginal;
import model.Course;
import model.Student;

import java.util.List;

public class CourseOriginalIndex {

    public static void main(String[] args) {

        CourseOriginal courseDAO = new CourseOriginal();

        // =========================== 1 - Consulta =================================================
        List<Course> cursos = courseDAO.list();

        cursos.stream().forEach(System.out::println);


        // ======================= 1.1 - Consulta com filtro ========================================
//        Student alunoParaConsulta = alunoDAO.getById(1);
//
//        System.out.println(alunoParaConsulta);


        // =========================== 2 - Inserção =================================================
//        Student alunoParaInsercao = new Student(
//                "Matheus",
//                43,
//                "SP"
//        );
//
//        alunoDAO.create(alunoParaInsercao);


        // =========================== 3 - Delete ===================================================
        //alunoDAO.delete(1);


        // =========================== 4 - Atualizar ================================================
//        Student alunoParaAtualizar = alunoDAO.getById(3);
//        alunoParaAtualizar.setName("Joaquim");
//        alunoParaAtualizar.setAge(18);
//        alunoParaAtualizar.setState("RS");
//
//        alunoDAO.update(alunoParaAtualizar);
    }

}

