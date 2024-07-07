package it.apuliadigital.bibliotecaproject.exception;

import java.util.Objects;

public class SuccessResponse<T> {
    private int statusCode;
    private String message;
    private T object;

    public SuccessResponse() {
    }

    public SuccessResponse(String message) {
        super();
        this.message = message;
    }

    public SuccessResponse(int statusCode, String message) {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }

    public SuccessResponse(int statusCode, String message, T object) {
        super();
        this.statusCode = statusCode;
        this.message = message;
        this.object = object;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public SuccessResponse<T> statusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public SuccessResponse<T> message(String message) {
        this.message = message;
        return this;
    }

    public SuccessResponse<T> object(T object) {
        this.object = object;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SuccessResponse successResponse)) {
            return false;
        }
        return statusCode == successResponse.statusCode && Objects.equals(message, successResponse.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, message);
    }

    @Override
    public String toString() {
        return "SuccessResponse{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                '}';
    }
}