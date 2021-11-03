package controllers.student;

import model.Student;

import java.util.List;

public class StudentIndex {
    public static void main(String[] args) {
//        final Student[] students = StudentAll.list();
        StudentAll studentAll = new StudentAll();
        // =========================== 1 - Consulta =================================================
        List<Student> students = studentAll.list();
        students.stream().forEach(System.out::println);

        // ======================= 1.1 - Consulta com filtro ========================================
        Student alunoParaConsulta = StudentById.getById(3);
        System.out.printf("\nFound student: %s\n", alunoParaConsulta.getName());
        System.out.println(alunoParaConsulta);

        // =========================== 2 - Inserção =================================================
        Student alunoParaInsercao = new Student(
                "Matheus",
                43,
                "SP"
        );

        StudentNew.create(alunoParaInsercao);

        // =========================== 3 - Delete ===================================================
        //alunoDAO.delete(1);

        // =========================== 4 - Atualizar ================================================
//        Student alunoParaAtualizar = StudentById.getById(3);
//        alunoParaAtualizar.setName("Joaquim");
//        alunoParaAtualizar.setAge(18);
//        alunoParaAtualizar.setState("RS");

        //alunoDAO.update(alunoParaAtualizar);
    }
}
