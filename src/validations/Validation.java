package validations;

import exceptions.ResponseStatus;
import models.Student;

public interface Validation {

    ResponseStatus validation(Student student);

}
