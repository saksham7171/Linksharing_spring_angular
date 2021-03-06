package com.ttnd.pojo;

public class Response {

    String status;
    String message;

    public Response(String status, String message) {
        this.status = status;
        this.message = message;
    }
    public Response() {}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
