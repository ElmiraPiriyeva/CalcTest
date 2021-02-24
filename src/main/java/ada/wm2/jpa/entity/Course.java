package ada.wm2.jpa.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="COURSES")
public class Course {

    @Id
    @NotNull(message = "Please enter CRN")
    @Column(name="CR_ID")
    Integer id;

    @NotNull(message = "Please enter Course Name")
    @Size(min=2,message="Course name must contain at least 2 characters")
    @Column(name="COURSE_NAME")
    String courseName;

    @NotNull(message = "Please enter Course Credit")
    @Max(value=6,message="The maximum number of credits is 6")
    @Column(name="COURSE_CREDIT")
    Integer courseCredit;

    @NotNull(message = "Please enter Passing Grade")
    @Min(value=69, message="The minimum passing grade is 69")
    @Column(name="PASSING_GRADE")
    Integer passingGrade;

    @NotBlank(message="The course must have at least one prerequisite")
    @Column(name="PREREQUISITE")
    String prerequisite;

    @ManyToMany(mappedBy = "courses")
    List<Student> enrolledStudents;

}
