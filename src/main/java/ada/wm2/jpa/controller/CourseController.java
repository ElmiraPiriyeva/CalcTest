package ada.wm2.jpa.controller;

import ada.wm2.jpa.entity.Course;
import ada.wm2.jpa.entity.Student;
import ada.wm2.jpa.repository.CourseRepository;
import ada.wm2.jpa.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    Logger logger = LoggerFactory.getLogger("CourseController");


    @GetMapping("/")
    public String getIndex(Model model){
        return "redirect:/course/courseList"; }

    @GetMapping("/courseList")
    public String getCourseList(Model model){
        logger.info("GetCourseList() method is in process");
        Iterable<Course> courses = courseRepository.findAll();
        model.addAttribute("courses",courses);

        return "course/courseList"; }


   @GetMapping("/{id}")
   public String getCourseInfo(Model model, @PathVariable(name="id") Integer id) {
       logger.info("GetCourseInformation() method is in process");
       Optional<Course> course = courseRepository.findById(id);
       Iterable<Student> student= courseRepository.findById(id).get().getEnrolledStudents();
       model.addAttribute("student",student);
       model.addAttribute("course",course.get());

       return "course/courseInformation"; }

    @GetMapping("/coursePrereq")
    public String CoursePrereq(Model model) {
        logger.info("CoursePrerequisite() method is in process");
        Iterable<Course> noprerequisite = courseRepository.findNonPrerequisiteCourses();
        model.addAttribute("nonprereq",noprerequisite);
        return "course/coursePrerequisites"; }

    @GetMapping("/courseAdd")
    public String AddNewCourse(Model model) {
        Course course = new Course();
        model.addAttribute("course",course);

        return "course/courseNew"; }

    @GetMapping("/courseUpdate/{id}")
    public String UpdateCourse(@PathVariable(name = "id") @Valid Integer id, Course course, Model model,BindingResult bindingResult) {
        logger.info("UpdateCourse() method is in process");
        if(bindingResult.hasErrors()){
            logger.error("While modifying, Course ---> " + course.getCourseName()+" got some errors:(");
            return "course/courseUpdate";
        }
        logger.debug("UpdateCourse() method has no errors");
        model.addAttribute("course", course);
        logger.info("UpdateCourse() method successfully updated course: " + course.getCourseName());
        return "course/courseUpdate"; }

   @GetMapping("/courseDelete/{id}")
    public String deleteCourse(@PathVariable(name="id") Integer id) {
       logger.info("DeleteCourse() method is in process");
        Optional<Course> course = courseRepository.findById(id);
        courseRepository.delete(course.get());
       logger.info("DeleteCourse() method deleted a course");
        return "redirect:/course/courseList"; }

    @PostMapping("/save")
    public String SaveCourse(@Valid Course course, BindingResult bindingResult) {
        logger.info("SaveCourse() method is in process");

        if(bindingResult.hasErrors()){
            logger.error("While modifying, Course --->" + course.getCourseName()+" got some errors:(");
            return "course/courseNew";
        }
        logger.debug("SaveCourse() method has no errors");
        courseRepository.save(course);

        logger.info("SaveCourse() method successfully saved new course --->" +course.getCourseName());
        return "redirect:/course/courseList"; }

}
