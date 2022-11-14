package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
//Da se implementira prebaruvanje na studenti na stranata kade istite se prikazuvaat ili
//da se prebaruvanje na kursevi na stranata na tie se prikazuvaat
@Component
public class DataHolder {
    public static List<Course> courseList = new ArrayList<>();
    public static List<Student> studentList = new ArrayList<>();

    public static List<Teacher> teacherList = new ArrayList<>();
    @PostConstruct
    public void init(){
        studentList.add(new Student("petar.petrov", "petar.petrov",
                "Petar", "Petrov"));
        studentList.add(new Student("mile.milev", "mile.milev",
                "Mile", "Milev"));
        studentList.add(new Student("gjorgji.gjorgjiev", "gjorgji.gjorgjiev",
                "Gjorgji", "Gjorgjiev"));

        List<Student> temp = new ArrayList<>();
        temp.add(studentList.get(0));
        Teacher teacher = new Teacher (1L, "P", "O");

        courseList.add(new Course("Veb programiranje",
                "VP", temp, teacher));
        courseList.add(new Course("Operativni Sistemi",
                "OS", new ArrayList<Student>(), teacher));
        courseList.add(new Course("Elektronska i mobilna trgovija",
                "EMT", new ArrayList<Student>(), teacher));
        courseList.add(new Course("Kompjuterski mrezi",
                "KM", new ArrayList<Student>(),teacher));


    }
}
