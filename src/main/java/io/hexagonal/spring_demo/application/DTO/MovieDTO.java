package io.hexagonal.spring_demo.application.DTO;

public record MovieDTO(
        String Title,
        String Director,
        String Description,
        Integer Duration
) {
}
