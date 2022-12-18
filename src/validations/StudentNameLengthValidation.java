package validations;

import exceptions.Error;
import exceptions.ErrorResponse;
import exceptions.ResponseStatus;
import exceptions.SuccessResponse;
import models.Student;

public class StudentNameLengthValidation implements Validation {

    private Integer minNameLength;

    private Integer maxNameLength;

    public StudentNameLengthValidation(Integer minNameLength, Integer maxNameLength) {
        this.minNameLength = minNameLength;
        this.maxNameLength = maxNameLength;
    }

    @Override
    public ResponseStatus validation(Student student) {
        if (student.getStudentName().length() >= minNameLength && student.getStudentName().length() <= maxNameLength) return new SuccessResponse();
            return new ErrorResponse(Error.INVALID_LENGTH_NAME);
    }

}
