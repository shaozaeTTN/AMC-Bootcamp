package Service.Implementation;

import Service.StudentClassService;
import bean.Student;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import java.util.List;
import java.util.ArrayList;

@Component(service = StudentClassService.class)
@Designate(ocd = ClassConfigurationService.class)
public class StudentServiceImpl implements StudentClassService {


    int count;
    List<Student> studentList = new ArrayList<Student>();

    @Activate
    ClassConfigurationService classConfigurationService;

    public boolean isClassLimitReached(List<Student> studentList) {
        return (studentList.size() > classConfigurationService.Max_Students());
    }

    public Integer getPassingMarks() {
        return classConfigurationService.Min_Marks();
    }


    public void addStudent(Integer id, String name, Integer marks, Integer age) {

        if(!isClassLimitReached(studentList)){
            studentList.add(new Student(id, name, marks, age));
            count++;
        } else {
            System.out.println("Class Limit reached. Can't add more students to class");
        }

    }

    public void deleteStudent(Integer studentId) {
        if(!studentList.isEmpty()){
            studentList.remove(getStudent(studentId));
        } else {
            System.out.println("Student List is empty");
        }
    }

    public boolean isStudentPassed(Integer studentId) {
        return getStudent(studentId).getMarksObtained() >= classConfigurationService.Min_Marks();
    }

    public Student getStudent(Integer studentId) {
        return studentList.stream().filter(student -> student.getId() == studentId).findFirst().orElse(null);
    }

    public void getAllStudents() {
        System.out.println("List of all student");
        for (Student student : studentList) {
            System.out.println(student);
        }

    }
}
