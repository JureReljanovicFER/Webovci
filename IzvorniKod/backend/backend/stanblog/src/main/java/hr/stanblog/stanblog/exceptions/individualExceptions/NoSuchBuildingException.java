package hr.stanblog.stanblog.exceptions.individualExceptions;

public class NoSuchBuildingException extends RuntimeException{
    private String message;

    public NoSuchBuildingException() {}

    public NoSuchBuildingException(String msg) {
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
