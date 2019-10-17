package vn.study.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "classes")
public class LearnClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(targetEntity = Pupil.class)
    private Set<Pupil> pupils;

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

    public Set<Pupil> getPupils() {
        return pupils;
    }

    public void setPupils(Set<Pupil> pupils) {
        this.pupils = pupils;
    }
}
