package controllers.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.StateX;
import model.StudentX;

public class MixedX {
    public static void main(String[] args) {

        // OBS: Esse código pode ou não funcionar de acordo com a biblioteca que foi baixada.
        // Se estiver somente com o JPA baixado, o código NÃO IRÁ funcionar.
        // Porém se estiver com a biblioteca de algum framework com
        // implementação JPA (Hibernate ou EclipseLink), o JPA irá automaticamente utilizá-lo.

        // O ideal é que nessa parte (Parte 1) o código
        // EXECUTE COM ERROR. Ao tentar executar, irá mostrar um error, afirmando que não
        // foi encontradada nenhuma implementação do JPA,
        // pois aqui não deveria ter nenhuma implementação JPA sendo utilizada,
        // apenas o JPA puro para demonstrar que através dele é possivel definir a
        // estrutura do codigo e depois escolher
        // a implementação que irá utilizar. Apenas na parte 2 do
        // curso será escolhida uma implementacão para o código executar sem error.

        // 1 - Passos iniciais para criar um gerenciador de entidades com o
        // banco de dados especificado no arquivo "persistence.xml"
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MixedX");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 2.1 - Criar instâncias para serem adicionadas no banco de dados
        StateX estadoParaAdicionar = new StateX("Rio de Janeiro", "RJ");
        StudentX alunoParaAdicionar = new StudentX("Daniel", 29, estadoParaAdicionar);

        // 2.2 - Iniciar uma trasacao para adiconar as instancias no banco de dados
        //
        // Begin transaction
        entityManager.getTransaction().begin();
        // Persist data
        entityManager.persist(estadoParaAdicionar);
        entityManager.persist(alunoParaAdicionar);
        // Commit
        entityManager.getTransaction().commit();
        // 3 - Encerrar o gerenciador de entidades e encerrar a
        // fabrica de gerenciadores de entidade.
        //
        // End transaction and close connection
        entityManager.close();
        entityManagerFactory.close();

    }
}