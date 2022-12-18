package services.implementation;

import exceptions.ResponseStatus;
import models.Student;
import repositories.interfaces.IStudentRepository;
import services.interfaces.IStudentService;
import validations.Validation;

import java.util.List;

public class StudentService implements IStudentService {

    private IStudentRepository studentRepository;

    private Validation ageValidation;

    private Validation nameLengthValidation;

    public StudentService(IStudentRepository studentRepository, Validation ageValidation, Validation nameLengthValidation) {
        this.studentRepository = studentRepository;
        this.ageValidation = ageValidation;
        this.nameLengthValidation = nameLengthValidation;
    }

    @Override
    public boolean registerStudent(Student newStudent) {
        ResponseStatus ageStatus = this.ageValidation.validation(newStudent);
        if (!ageStatus.isValid()) return ageStatus.isValid();

        ResponseStatus nameLengthStatus = this.nameLengthValidation.validation(newStudent);
        if (nameLengthStatus.isValid()) return nameLengthStatus.isValid();

        ResponseStatus registerStatus = studentRepository.create(newStudent);
        return registerStatus.isValid();
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByIndex(Integer index) {
        return studentRepository.findByIndex(index);
    }

    @Override
    public boolean unregisterStudent() {
        return studentRepository.delete().isValid();
    }

}
