package controllers.jpa;

import model.StateX;
import model.StudentX;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MixedY {
    public static void main(String[] args) {

        // OBS: Esse codigo deve executar SEM ERROS com a implementacao JPA que foi definida no "persistence.xml".
        // Se estiver somente com o JPA baixado, o codigo NAO IRA funcionar.

        // O ideal é que nessa parte (Parte 2) o codigo EXECUTE SEM ERROS, pois aqui tera uma implementacao JPA sendo utilizada.

        // 1 - Passos iniciais para criar um gerenciadop de entidades com o banco de dados especificado no arquivo  "persistence.xml"
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MixedY");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 2.1 - Criar instancias para serem adicionadas no banco de dados
        // Add states
        StateX estadoParaAdicionar = new StateX("Rio de Janeiro", "RJ");
        StateX estadoParaAdicionar2 = new StateX("Rio Grande do Norte", "RN");
        StateX estadoParaAdicionar3 = new StateX("Rio Grande do Sul", "RS");
        StateX estadoParaAdicionar4 = new StateX("São Paulo", "SP");
        // Add students
        StudentX alunoParaAdicionar = new StudentX("Daniel Silva", 29, estadoParaAdicionar);
        StudentX alunoParaAdicionar2 = new StudentX("Franklin Siqueira", 55, estadoParaAdicionar2);
        StudentX alunoParaAdicionar3 = new StudentX("João Antônio", 33, estadoParaAdicionar2);
        StudentX alunoParaAdicionar4 = new StudentX("José Caetano", 43, estadoParaAdicionar3);
        StudentX alunoParaAdicionar5 = new StudentX("Antônio Gusmão", 29, estadoParaAdicionar4);
        StudentX alunoParaAdicionar6 = new StudentX("Humberto Crosta", 29, estadoParaAdicionar);
        StudentX alunoParaAdicionar7 = new StudentX("Ataide Moral", 29, estadoParaAdicionar3);
        StudentX alunoParaAdicionar8 = new StudentX("Carlos Gonoe", 29, estadoParaAdicionar4);

        // 2.2 - Iniciar uma trasacao para adiconar as instancias no banco de dados
        // Begin transaction
        entityManager.getTransaction().begin();
        // Persist data
        // States
        entityManager.persist(estadoParaAdicionar);
        entityManager.persist(estadoParaAdicionar2);
        entityManager.persist(estadoParaAdicionar3);
        entityManager.persist(estadoParaAdicionar4);
        /// Students
        entityManager.persist(alunoParaAdicionar);
        entityManager.persist(alunoParaAdicionar2);
        entityManager.persist(alunoParaAdicionar3);
        entityManager.persist(alunoParaAdicionar4);
        entityManager.persist(alunoParaAdicionar5);
        entityManager.persist(alunoParaAdicionar6);
        entityManager.persist(alunoParaAdicionar7);
        entityManager.persist(alunoParaAdicionar8);
        // Commit
        entityManager.getTransaction().commit();

        // 3 - Resgatar instâncias no banco de dados
        StateX estadoEncontrado = entityManager.find(StateX.class, 1);
        StudentX alunoEncontrado = entityManager.find(StudentX.class, 1);
        // Print
        System.out.println(estadoEncontrado + "\n");
        System.out.println(alunoEncontrado + "\n");

        // 4 - Alterar uma entidade
        entityManager.getTransaction().begin();

        alunoEncontrado.setName("Franklin Carrilho");
        alunoEncontrado.setAge(55);

        System.out.println(alunoEncontrado + "\n");

        entityManager.getTransaction().commit();

        // 5 - Remover uma entidade
        entityManager.getTransaction().begin();
        entityManager.remove(alunoEncontrado);
        entityManager.getTransaction().commit();

        // 6 - Encerrar o gerenciador de entidades e encerrar a fabrica de gerenciadores de entidade.
        // End transaction and close connection
        entityManager.close();
        entityManagerFactory.close();

    }
}