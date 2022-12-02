package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;

@Repository
public class CourseRepository {


    public List<Course> findAllCourses(){
        return DataHolder.courseList;
    }

    public Course findById(Long courseId){
        return DataHolder.courseList.stream().filter(r->r.getCourseId().equals(courseId)).findFirst().get();
    }

    public List<Student> findAllStudentsByCourse(Long courseId){
        return findById(courseId).getStudents();
    }

    public Course addStudentToCourse(Student student, Course course){
        course.getStudents().add(student);
        return course;
    }
    public Course save(Course course){
        if(course == null || course.getName()==null || course.getName().isEmpty()){
            return null;
        }
        DataHolder.courseList.removeIf(r->r.getName().equals(course.getName()));
        DataHolder.courseList.add(course);
        return course;
    }
    public void delete(Long courseId){
        DataHolder.courseList.removeIf(r->r.getCourseId().equals(courseId));
    }
}
