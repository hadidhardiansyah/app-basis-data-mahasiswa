package repositories.implementation;

import exceptions.Error;
import exceptions.ErrorResponse;
import exceptions.ResponseStatus;
import exceptions.SuccessResponse;
import models.Student;
import repositories.interfaces.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private List<Student> studentList = new ArrayList<>();

    private Integer maxData;

    @Override
    public ResponseStatus create(Student student) {
        if (studentList.size() < maxData) {
            studentList.add(student);
            return new SuccessResponse();
        } else {
            return new ErrorResponse(Error.NOT_ENOUGH_SPACE);
        }
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student findByIndex(Integer index) {
        if (index >= 0 && index < studentList.size()) {
            return studentList.get(index);
        } else {
            return null;
        }
    }

    @Override
    public ResponseStatus delete() {
        if (!studentList.isEmpty()) {
            studentList.remove(studentList.size() - 1);
            return new SuccessResponse();
        } else {
            return new ErrorResponse(Error.DATA_IS_EMPTY);
        }
    }

}
