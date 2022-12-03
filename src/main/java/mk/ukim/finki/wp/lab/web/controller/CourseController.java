package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    private final TeacherService teacherService;

    public CourseController(CourseService courseService, TeacherService teacherService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
    }

    @GetMapping()
    public String getCoursesPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("courses", courseService.listAll());
        return "listCourses";
    }
    @PostMapping("/courses")
    public String saveCourse(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam Long teacherId){

        Course course = courseService.addCourse(name, description, teacherId);
        courseService.save(course);

        return "redirect:/courses";

    }


    @GetMapping("/courses/add")
    public String addCourse(Model model){
        model.addAttribute("teachers", teacherService.findAll());
        return "add-course";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }

    @GetMapping("/edit/{id}")
    public String getEditCoursePage(@PathVariable Long id, Model model){
        Course toEdit = courseService.findCourseById(id);
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("course", toEdit);
        return "edit-course";
    }

    @PostMapping("/edit/{id}")
    public String editCoursePage(@PathVariable Long id,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) String description,
                                 @RequestParam(required = false) Teacher teacher, Model model){
        Course course = courseService.findCourseById(id);
        course.setName(name);
        course.setDescription(description);
        course.setTeacher(teacher);
        courseService.save(course);

        return "redirect:/courses";
    }


}
