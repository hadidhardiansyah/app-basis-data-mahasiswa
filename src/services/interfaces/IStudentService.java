package services.interfaces;

import models.Student;

import java.util.List;

public interface IStudentService {

    boolean registerStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentByIndex(Integer index);

    boolean unregisterStudent();

}
