## Conteúdo do Arquivo persistence.xml
---

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"
             version="2.2">
    
    <!-- ==========================================================================================================================  -->

    <!-- Persistence unit / Unidade de persistência da parte 1 do curso (Somente JPA)-->
    <!-- Course's Part 1 persistence unit (JPA only) -->
    <persistence-unit name="MixedX">

        <description>
            Unidade de persistência da parte 1 do tutorial básico de JPA
            da Digital Innovation One sem implementações (Somente JPA).
            Part 1 persistence unit from basic tutorial on Java Persistance API (JPA only) at DIO.
        </description>

        <!-- Classes (entidades) que serão mapeadas -->
        <!-- Mapped classes/entities -->
        <class>model.Student</class>
        <class>model.State</class>

        <!-- Configurações de conexão do banco de dados -->
        <!-- DB connection settings (all persistence units)-->
        <properties>
            <!-- Configurações do banco de dados -->
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost/dio" />
            <property name="javax.persistence.jdbc.user" value="root" />
            <property name="javax.persistence.jdbc.password" value="YOUR_PASSWORD" />
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
        </properties>

    </persistence-unit>

    <!-- ==========================================================================================================================  -->

    <!-- Unidade de persistência da parte 2 do curso (com implementação Hibernate) -->
    <!-- Persistence unit 2 (Hibernate implementation) -->
    <persistence-unit name="MixedY">

        <description>
            Unidade de persistencia da parte 2 do tutorial básico de JPA da
            Digital Innovation One com implementação Hibernate.
            Persistence unit 2 Hibernate implementation.
        </description>

        <!-- Implementação do JPA -->
        <!-- JPA's implementation -->
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <!--  <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider> -->

        <!-- Classes (entidades) que serão mapeadas -->
        <!-- Mapped classes/entities -->
        <class>model.StudentX</class>
        <class>model.StateX</class>

        <!-- Configurações de conexão ao banco de dados e do Hibernate/EclipseLink -->
        <!-- DB connection settings and Hibernate/EclipseLink data -->
        <properties>
            <!-- Configurações do banco de dados -->
            <!-- DB connection settings -->
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost/dio" />
            <property name="javax.persistence.jdbc.user" value="root" />
            <property name="javax.persistence.jdbc.password" value="245353f10@M!" />
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />

            <!-- Configurações do Hibernate
            (os parâmetros só são reconhecidos se estiver usando a implementação do Hibernate)
            -->
            <!-- Hibernate settings (only recognizable while using Hibernate implementation) -->
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect" />
            <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.format_sql" value="true" />
            <property name="hibernate.hbm2ddl.auto" value="create" />
            <!-- ABOVE-> Possible values for hibernate.hbm2ddl.auto are:
            validate: validate data and insert new records
            update:
            create: drop table (if exists) and create new one
            create-drop:
            -->

            <!-- EclipseLink settings / Configurações do EclipseLink
            (Only used on EclipseLink implementations / os parâmetros só reconhecidos usando a implementação do EclipseLink)
            -->
            <!--            <property name="eclipselink.target-database" value="MySQL"/>-->
            <!--            <property name="eclipselink.logging.level.sql" value="FINE" />-->
            <!--            <property name="eclipselink.logging.parameters" value="true" />-->
            <!--            <property name="eclipselink.ddl-generation" value="drop-and-create-tables" />-->
        </properties>

    </persistence-unit>

    <!-- ==========================================================================================================================  -->

    <!-- Unidade de persistência da parte 3 do curso (com implementação EclipseLink) -->
    <persistence-unit name="MixedZ">

        <description>
            Unidade de persistencia da parte 3 do tutorial básico de JPA da
            Digital Innovation One com implementação EclipseLink.
            Persistence unit 3 EclipseLink implementation.
        </description>

        <!-- Implementação do JPA -->
        <!-- JPA's implementation -->
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <!--  <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider> -->

        <!-- Classes (entidades) que serão mapeadas -->
        <!-- Mapped classes/entities -->
        <class>model.StudentX</class>
        <class>model.StateX</class>

        <!-- Configurações de conexão ao banco de dados e do Hibernate/EclipseLink -->
        <!-- DB connection settings and Hibernate/EclipseLink data -->
        <properties>
            <!-- Configurações do banco de dados -->
            <!-- DB connection settings -->
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost/dio" />
            <property name="javax.persistence.jdbc.user" value="root" />
            <property name="javax.persistence.jdbc.password" value="245353f10@M!" />
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />

            <!-- Configurações do Hibernate
            (os parâmetros só são reconhecidos se estiver usando a implementação do Hibernate)
            -->
            <!-- Hibernate settings (only recognizable while using Hibernate implementation) -->
            <!--            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect" />-->
            <!--            <property name="hibernate.show_sql" value="true" />-->
            <!--            <property name="hibernate.format_sql" value="true" />-->
            <!--            <property name="hibernate.hbm2ddl.auto" value="create" />-->
            <!-- ABOVE-> Possible values for hibernate.hbm2ddl.auto are:
            validate: validate data and insert new records
            update:
            create: drop table (if exists) and create new one
            create-drop:
            -->

            <!-- Configuracoes do EclipseLink
            (os parâmetros só são reconhecidos se estiver usando a implementação do EclipseLink)
            -->
            <property name="eclipselink.target-database" value="MySQL"/>
            <property name="eclipselink.logging.level.sql" value="FINE" />
            <property name="eclipselink.logging.parameters" value="true" />
            <property name="eclipselink.ddl-generation" value="drop-and-create-tables" />
        </properties>

    </persistence-unit>
</persistence>



```
