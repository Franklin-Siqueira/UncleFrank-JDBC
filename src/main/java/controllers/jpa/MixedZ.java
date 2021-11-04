package controllers.jpa;

import model.StateX;
import model.StudentX;
import model.StudentX_;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MixedZ {
    public static void main(String[] args) {

        // 1 - Dados instanciados para serem utilizados como exemplo
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MixedY");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        StateX estadoParaAdicionar = new StateX("Rio de Janeiro", "RJ");
        entityManager.persist(estadoParaAdicionar);
        entityManager.persist(new StateX("Sao Paulo", "SP"));
        entityManager.persist(new StudentX("Daniel", 29, estadoParaAdicionar));
        entityManager.persist(new StudentX("Joao", 20, estadoParaAdicionar));
        entityManager.persist(new StudentX("Pedro", 30, estadoParaAdicionar));
        entityManager.getTransaction().commit();
        // =============================================================================================================
        // 2 - Vamos utilizar o método do EntityManager find(), SQL nativo, JPQL e
        // JPA Criteria API para realizar uma consulta que retornar o mesmo valor
        // equivalente aos seguintes SQL:
        // SELECT * FROM StudentX WHERE id = 1 (Equivalente ao método find do entityManager na parte 2.2)
        // SELECT * FROM StudentX WHERE name = 'Daniel' (Sera o equivalente para as outras consultas nas partes 2.3 - 2.4 - 2.5)

        // 2.1 O parametro de busca que será utilizado nas proximas consultas
        String nome = "Daniel";

        // 2.2 - Utilizando o método find do entityManager
        // Trazendo somente 1 resultado
        StudentX alunoEntityManager = entityManager.find(StudentX.class, 1);

        // Trazendo uma lista como resultado
        // Nao eh possivel!!! Deve utilizar um dos métodos utilizados abaixos nas partes 2.3 - 2.4 - 2.5

        // Resultados das consultas acima
        System.out.println("Consulta alunoEntityManager: " + alunoEntityManager);

        // =============================================================================================================
        // 2.3 - SQL nativo
        // Trazendo somente 1 resultado
        String sql = "SELECT * FROM StudentX WHERE name = :nome ";
        StudentX alunoSQL = (StudentX) entityManager
                .createNativeQuery(sql, StudentX.class)
                .setParameter("nome", nome)
                .getSingleResult();

        // Trazendo uma lista como resultado
        String sqlList = "SELECT * FROM StudentX";
        List<StudentX> alunoSQLList = entityManager
                .createNativeQuery(sqlList, StudentX.class)
                .getResultList();

        // Resultados das consultas acima
        System.out.println("Consulta alunoSQL: " + alunoSQL);
        alunoSQLList.forEach(StudentX -> System.out.println("Consulta alunoSQLList: " + StudentX));

        // =============================================================================================================
        // 2.4 - JPQL
        // Trazendo somente 1 resultado
        String jpql = "select a from StudentX a where a.name = :name";
        StudentX alunoJPQL = entityManager
                .createQuery(jpql, StudentX.class)
                .setParameter("name", nome)
                .getSingleResult();

        // Trazendo uma lista como resultado
        String jpqlList = "select a from StudentX a where a.estado = :estado";
        List<StudentX> alunoJPQLList = entityManager
                .createQuery(jpqlList, StudentX.class)
                .setParameter("estado", estadoParaAdicionar)
                .getResultList();

        // Resultados das consultas acima
        System.out.println("Consulta alunoJPQL: " + alunoJPQL);
        alunoJPQLList.forEach(StudentX -> System.out.println("Consulta alunoJPQLList: " + StudentX));

        // =============================================================================================================
        // 2.5 - JPA Criteria API + JPA Metamodel

        // Trazendo somente 1 resultado
        CriteriaQuery<StudentX> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(StudentX.class);
        Root<StudentX> alunoRoot = criteriaQuery.from(StudentX.class);
        CriteriaBuilder.In<String> inClause = entityManager.getCriteriaBuilder().in(alunoRoot.get(StudentX_.name));
        inClause.value(nome);
        criteriaQuery.select(alunoRoot).where(inClause);
        StudentX alunoAPICriteria = entityManager.createQuery(criteriaQuery).getSingleResult();

        // Trazendo uma lista como resultado
        CriteriaQuery<StudentX> criteriaQueryList = entityManager.getCriteriaBuilder().createQuery(StudentX.class);
        Root<StudentX> alunoRootList = criteriaQueryList.from(StudentX.class);
        List<StudentX> alunoAPICriteriaList = entityManager.createQuery(criteriaQueryList).getResultList();

        // Resultados das consultas acima
        System.out.println("Consulta alunoAPICriteria: " + alunoAPICriteria);
        alunoAPICriteriaList.forEach(StudentX -> System.out.println("Consulta alunoAPICriteriaList: " + StudentX));
    }
}
