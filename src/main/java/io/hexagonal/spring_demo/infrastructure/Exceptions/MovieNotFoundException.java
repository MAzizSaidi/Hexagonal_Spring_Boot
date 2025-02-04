package io.hexagonal.spring_demo.infrastructure.Exceptions;

public class MovieNotFoundException  extends RuntimeException {
    public MovieNotFoundException(String message) {
        super(message);
    }
}
