package com.vts.eoffice.exception;


public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException() {
        super();
    }

    public DepartmentNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFoundException(final String message) {
        super(message);
    }

    public DepartmentNotFoundException(final Throwable cause) {
        super(cause);
    }
}
