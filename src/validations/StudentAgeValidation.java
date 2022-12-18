package validations;

import exceptions.Error;
import exceptions.ErrorResponse;
import exceptions.ResponseStatus;
import exceptions.SuccessResponse;
import models.Student;

public class StudentAgeValidation implements Validation {

    private Integer minAge;

    public StudentAgeValidation(Integer minAge) {
        this.minAge = minAge;
    }

    @Override
    public ResponseStatus validation(Student student) {
        if (student.getAge() >= minAge) return new SuccessResponse();
        return new ErrorResponse(Error.INVALID_AGE);
    }
}
