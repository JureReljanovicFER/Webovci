package hr.stanblog.stanblog.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseObj {

    private String message;

    private Object data;

    public ResponseObj() {

    }
    public ResponseObj(String message) {
        this.message = message;
    }

    public ResponseObj(String message, Object data) {
        this.message = message;
        this.data = data;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }


}
