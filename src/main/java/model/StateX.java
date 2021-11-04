package model;

import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;

@Entity
public class StateX {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String symbol;

    @OneToMany(
            mappedBy = "estado",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<StudentX> alunos = new ArrayList<>();

    public StateX() { }

    public StateX(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public StateX(String name, String symbol, List<StudentX> alunos) {
        this.name = name;
        this.symbol = symbol;
        this.alunos = alunos;
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<StudentX> getStudentX() {
        return alunos;
    }

    public void setStudentX(List<StudentX> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "StateX{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", alunos=" + alunos +
                '}';
    }
}