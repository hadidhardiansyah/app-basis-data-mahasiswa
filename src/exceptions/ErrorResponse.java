package exceptions;

public class ErrorResponse extends ResponseStatus {

    public ErrorResponse(Error error) {
        super(false, error);
    }

}
