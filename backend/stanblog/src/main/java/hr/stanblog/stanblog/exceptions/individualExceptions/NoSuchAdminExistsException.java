
package hr.stanblog.stanblog.exceptions.individualExceptions;

public class NoSuchAdminExistsException extends RuntimeException {
    private String message;

    public NoSuchAdminExistsException() {}

    public NoSuchAdminExistsException(String msg) {
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