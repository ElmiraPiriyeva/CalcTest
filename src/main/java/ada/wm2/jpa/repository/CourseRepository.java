package ada.wm2.jpa.repository;

import ada.wm2.jpa.entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,Integer> {

   @Query(value="SELECT * FROM COURSES WHERE CR_ID NOT IN (SELECT CR_ID FROM ENROLLMENTS WHERE ST_ID=?1)", nativeQuery = true)
    List<Course> findRemainingCourses(Integer id);

    @Query(value="SELECT * FROM COURSES  WHERE PREREQUISITE IS NULL", nativeQuery = true)
    List<Course> findNonPrerequisiteCourses();
}
