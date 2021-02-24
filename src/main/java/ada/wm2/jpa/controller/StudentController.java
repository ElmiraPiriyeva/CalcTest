package ada.wm2.jpa.controller;

import ada.wm2.jpa.entity.Course;
import ada.wm2.jpa.entity.Student;
import ada.wm2.jpa.repository.CourseRepository;
import ada.wm2.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    Logger logger = LoggerFactory.getLogger("StudentController");

    @GetMapping("/")
    public String getIndex(Model model){
        return "redirect:/student/studentList";}

    @GetMapping("/studentList")
    public String getStudentList(Model model){
        logger.info("GetStudentList() method is in process");
        Iterable<Student> students = studentRepository.findAll();
        model.addAttribute("students",students);

        return "student/studentList"; }

    @GetMapping("/{id}")
    public String getStudentInfo(Model model, @PathVariable(name="id") String id) {
        logger.info("GetStudentInfo() method is retrieving student information");
        Optional<Student> student = studentRepository.findById(Integer.parseInt(id));
        Iterable<Course> courses = studentRepository.findById(Integer.parseInt(id)).get().getCourses();

        model.addAttribute("courses",courses);
        model.addAttribute("student",student.get());

        return "student/studentInformation"; }

    @GetMapping("/studentAdd")
    public String AddNewStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student",student);

        return "student/studentNew"; }

    @GetMapping("/scholars")
    public String getScholarList(Model model, Student student) {
        logger.info("GetScholarList() method is in process");
        List<Student> scholars = studentRepository.getListOfScholars();
        model.addAttribute("gpa",scholars);

        return "student/studentGPA"; }

    @GetMapping("/probation")
    public String getProbationList(Model model, Student student) {
        logger.info("GetProbationList() method is in process");
        List<Student> probation= studentRepository.getListOfProbation();
        model.addAttribute("gpa",probation);

        return "student/studentGPA"; }

    @GetMapping("/studentDelete/{id}")
    public String deleteStudent(@PathVariable(name="id") String id) {
        logger.info("DeleteStudent() method is in process");
        Optional<Student> student = studentRepository.findById(Integer.parseInt(id));
        studentRepository.delete(student.get());
        logger.info("DeleteStudent() method successfully deleted a student");
        return "redirect:/student/studentList"; }

    @GetMapping("/studentUpdate/{id}")
    public String UpdateStudent(@PathVariable(name="id") @Valid Integer id, Student student, Model model, BindingResult bindingResult) {
        logger.info("UpdateStudent() method is in process");
        Optional<Student> result = studentRepository.findById(id);
        if (result.isPresent()) {
            Student st = result.get();
            model.addAttribute("student",st);
        }
        Iterable<Course> courses = courseRepository.findAll();
        model.addAttribute("courses",courses);

        if(bindingResult.hasErrors()){
            logger.error("While modifying, Student ---> " + student.getFirstName()+" got some errors:(");
            return "student/studentUpdate";
        }

        logger.debug("UpdateStudent() method has no errors");
        logger.info("UpdateStudent() method successfully updated student: " + student.getFirstName());
        return "student/studentUpdate"; }

    @PostMapping("/save")
    public String SaveStudent(@Valid Student student, BindingResult bindingResult)  {
        logger.info("SaveStudent() method is in process");
        if(bindingResult.hasErrors()){
            logger.error("While modifying, Student ---> " + student.getFirstName()+" got some errors:(");
            return "student/studentNew";
        }
        logger.debug("SaveStudent() method has no errors");
        studentRepository.save(student);

        logger.info("SaveStudent() method successfully saved new student --->" +student.getFirstName()+" "+student.getLastName());
        return "redirect:/student/studentList"; }

}
