//package mk.ukim.finki.wp.lab.web;
//
//import mk.ukim.finki.wp.lab.service.CourseService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name = "courses-list-servlet", urlPatterns = "/listCourses")
//public class CoursesListServlet extends HttpServlet {
//    private final CourseService courseService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//
//    public CoursesListServlet(CourseService courseService, SpringTemplateEngine springTemplateEngine) {
//        this.courseService = courseService;
//        this.springTemplateEngine = springTemplateEngine;
//
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        WebContext webContext = new WebContext(req, resp, req.getServletContext());
//        webContext.setVariable("courses", this.courseService.listAll());
//        springTemplateEngine.process("listCourses.html", webContext, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String selectedCourse = req.getParameter("courseId");
//        if(selectedCourse != null){
//            String id = selectedCourse.split("-")[0];
//            req.getSession().setAttribute("courseId", id);
//        }
//        resp.sendRedirect("/AddStudent");
//    }
//
//}
