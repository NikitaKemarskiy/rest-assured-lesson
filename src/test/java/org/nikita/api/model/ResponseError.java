package org.nikita.api.model;

public class ResponseError {
    private ErrorData[] errors;

    public ErrorData[] getErrors() {
        return errors;
    }

    public void setErrors(ErrorData[] errors) {
        this.errors = errors;
    }
}
