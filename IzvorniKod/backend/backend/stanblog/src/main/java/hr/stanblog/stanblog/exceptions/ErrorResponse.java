package hr.stanblog.stanblog.exceptions;

 public class ErrorResponse {

    private int statusCode;
    private String message;

    public ErrorResponse(int statusCode, String message)
    {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }
} 
