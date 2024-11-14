package hr.stanblog.stanblog.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseObj {

    private String message;
    public ResponseObj() {

    }
    public ResponseObj(String message) {
        this.message = message;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
