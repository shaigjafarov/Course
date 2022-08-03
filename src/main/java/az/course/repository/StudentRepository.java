package az.course.repository;

import az.course.model.Student;
import java.util.List;

public interface StudentRepository {

    List<Student> getAllStudent();

    boolean  addStudent(Student student);

    boolean updateStudent(Student student);

    Student getStudentById(Integer id);


}
