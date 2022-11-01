package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Course> courseList = new ArrayList<>();
    public static List<Student> studentList = new ArrayList<>();

    @PostConstruct
    public void init(){
        courseList.add(new Course(1L, "Veb programiranje",
                "VP", new ArrayList<Student>()));
        courseList.add(new Course(2L, "Operativni Sistemi",
                "OS", new ArrayList<Student>()));
        courseList.add(new Course(3L, "Elektronska i mobilna trgovija",
                "EMT", new ArrayList<Student>()));
        courseList.add(new Course(4L, "Kompjuterski mrezi",
                "KM", new ArrayList<Student>()));
    }
}
