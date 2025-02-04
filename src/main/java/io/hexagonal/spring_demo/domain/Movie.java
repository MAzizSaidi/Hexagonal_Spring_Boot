package io.hexagonal.spring_demo.domain;

public record Movie(
        Long id,
        String title,
        String director,
        String Description,
        Integer duration
) {
}
