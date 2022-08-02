package in.ac.charusat.studentmgmtsystem.repository;

import in.ac.charusat.studentmgmtsystem.model.course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<course, Integer> {
}