package com.kitaplik.libraryservice.exception;

public class BookNotFoundException extends RuntimeException {

    private final ExceptionMessage exceptionMessage;
    public BookNotFoundException(ExceptionMessage message) {
        this.exceptionMessage = message;
    }

    public ExceptionMessage getExceptionMessage() {
        return exceptionMessage;
    }
}
