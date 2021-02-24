package ada.wm2.jpa.repository;

import ada.wm2.jpa.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StudentRepository extends  CrudRepository<Student,Integer> {

    @Query(value="SELECT * FROM STUDENTS S WHERE S.GPA>=3.00", nativeQuery = true)
    List<Student> getListOfScholars();

    @Query(value="SELECT * FROM STUDENTS S WHERE S.GPA<2.00", nativeQuery = true)
    List<Student> getListOfProbation();


}
