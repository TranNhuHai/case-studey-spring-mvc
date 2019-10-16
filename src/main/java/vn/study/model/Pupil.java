package vn.study.model;

import javax.persistence.*;

@Entity
@Table(name = "pupils")
public class Pupil {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String phone;
    private String mail;

    @ManyToOne
    @JoinColumn(name = "classes_id")
    private LearnClass learnClass;

    public Pupil() {

    }

    public Pupil(String name, String phone, String mail) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
    }

    public Pupil(String name, String phone, String mail, LearnClass learnClass) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.learnClass = learnClass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LearnClass getLearnClass() {
        return learnClass;
    }

    public void setLearnClass(LearnClass learnClass) {
        this.learnClass = learnClass;
    }
}
