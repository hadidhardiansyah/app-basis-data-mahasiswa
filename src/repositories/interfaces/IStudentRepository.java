package repositories.interfaces;

import exceptions.ResponseStatus;
import models.Major;
import models.Student;

import java.util.List;

public interface IStudentRepository {

    ResponseStatus create(Student student);

    List<Student> findAll();

    Student findByIndex(Integer index);

    ResponseStatus delete();

}
