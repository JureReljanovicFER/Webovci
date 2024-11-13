
package hr.stanblog.stanblog.exceptions.individualExceptions;

public class NoSuchUserException extends RuntimeException {
    private String message;

    public NoSuchUserException() {}

    public NoSuchUserException(String msg) {
        super(msg);
        this.message = msg;
    }


    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}