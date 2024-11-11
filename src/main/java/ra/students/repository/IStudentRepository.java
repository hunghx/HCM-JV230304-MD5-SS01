package ra.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.students.model.entity.Student;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
    boolean existsByPhone(String phone);
}
