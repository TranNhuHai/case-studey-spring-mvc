package vn.study.model;

public class Pupil {
    private Long id;
    private String name;
    private String aClass;
    private String phone;

    public Pupil() {

    }

    public Pupil(Long id, String name, String aClass, String phone) {
        this.id = id;
        this.name = name;
        this.aClass = aClass;
        this.phone = phone;
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

    public String getaClass() {
        return aClass;
    }

    public void setaClass(String aClass) {
        this.aClass = aClass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
