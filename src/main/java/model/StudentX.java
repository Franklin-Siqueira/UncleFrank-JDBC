package model;

import javax.persistence.*;

@Entity
public class StudentX {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    // Remark:
    // Other options relate to type of relationships, like:
    //      @ManyToMany
    //      @OneToMany
    //      @OneToOne
    // Present case illustrates a @ManyToOne, as each state should be
    // many students' places of residence, but each student should live in only
    // state.
    @ManyToOne(fetch = FetchType.LAZY)
    private StateX estado;

    public StudentX() { }

    public StudentX(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public StudentX(String name, int age, StateX estado) {
        this.name = name;
        this.age = age;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StateX getStateX() {
        return estado;
    }

    public void setStateX(StateX estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "StudentX{" +
                "id=" + id +
                ", nome='" + name + '\'' +
                ", idade=" + age +
                ", estado=" + estado.getSymbol() +
                '}';
    }
}