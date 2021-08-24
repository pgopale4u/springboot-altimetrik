package com.vts.eoffice.exception;


public class Unauthorized extends RuntimeException {

    public Unauthorized() {
        super();
    }

    public Unauthorized(final String message, final Throwable cause) {
        super(message, cause);
    }

    public Unauthorized(final String message) {
        super(message);
    }

    public Unauthorized(final Throwable cause) {
        super(cause);
    }
}
