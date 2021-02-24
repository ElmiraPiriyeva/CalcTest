package ada.wm2.jpa.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name ="STUDENTS")
public class Student {

    @Id
    @NotNull(message = "Please enter your ID")
    @Column(name="ST_ID")
    Integer id;

    @NotNull(message = "Please enter your First Name")
    @Size(min=2,message="First name must contain at least 2 characters")
    String firstName;

    @NotNull(message = "Please enter Last Name")
    @Size(min=2,message="Last name must contain at least 2 characters")
    String lastName;

    @NotNull(message = "Please enter your GPA")
    @Max(value = 4,message = "GPA can not be grater than 4")
    Double GPA;

    @NotNull(message = "Please enter Graduation Year")
    @Min(value=2020, message = "Graduation class starts from 2020!")
    Integer classOf;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="ENROLLMENTS",
            joinColumns = @JoinColumn(name = "ST_ID"),
            inverseJoinColumns = @JoinColumn(name = "CR_ID"))

    List<Course> courses;

}
