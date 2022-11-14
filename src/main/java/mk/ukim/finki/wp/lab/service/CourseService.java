package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;

import java.util.List;

public interface CourseService {
    List<Course> listAll();
    List<Student> listStudentsByCourse(Long courseId);
    Course addStudentInCourse(String username, Long courseId);

    Course findCourseById(Long courseId);
//    Course addCourse(String name,String description,Long teacherId);
}
