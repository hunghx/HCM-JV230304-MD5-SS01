package ra.students.service;

import ra.students.model.dto.req.StudentCreateDto;
import ra.students.model.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void add(StudentCreateDto request);


}
