package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.CourseRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final StudentService studentService;

    private final TeacherService teacherService;

    public CourseServiceImpl(CourseRepository courseRepository, StudentService studentService, TeacherService teacherService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    public List<Course> listAll(){
        return courseRepository.findAllCourses();
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return courseRepository.findAllStudentsByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        Course course = courseRepository.findById(courseId);
        Student student = studentService.searchByUsername(username);
        if(!course.getStudents().contains(student)){
            course.getStudents().add(student);
            courseRepository.save(course);
        }
        return course;
    }

    public Course findCourseById(Long courseId){
        Course course = courseRepository.findById(courseId);
        return course;
    }

    @Override
    public Course addCourse(String name, String description, Long teacherId) {
        Course course = new Course(name, description, new ArrayList<>(), teacherService.findTeacherById(teacherId));
        course.setName(name);
        course.setDescription(description);
        course.setTeacher(teacherService.findTeacherById(teacherId));
        courseRepository.save(course);
        return course;
    }
    public Course save(Course course){
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.delete(courseId);
    }


//    @Override
//    public Course addCourse(String name, String description, Long teacherId) {
//        Course vrati = new Course(name, description);
//    }
}
