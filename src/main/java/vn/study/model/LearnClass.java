package vn.study.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="LearnClass")
public class LearnClass {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;

    public LearnClass() {
    }

    public LearnClass(String name) {
        this.name = name;
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
}
