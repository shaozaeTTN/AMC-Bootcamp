package bean;

public class Student {

    private Integer id;
    private String name;
    private Integer marksObtained;
    private Integer age;

    public Student(Integer id, String name, Integer marks, Integer age){
        this.id = id;
        this.name = name;
        marksObtained = marks;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(Integer marksObtained) {
        this.marksObtained = marksObtained;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nNAME: " + name + "\nMARKS: " + marksObtained + "\nAGE: " + age + "\n";
    }
}
