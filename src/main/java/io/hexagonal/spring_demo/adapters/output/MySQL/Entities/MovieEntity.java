package io.hexagonal.spring_demo.adapters.output.MySQL.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;



@Table("movies")
public record MovieEntity(
        @Id
        Long id,
        String Title,
        String Director,
        String Description,
        Integer Duration,
        @Version
        Integer Version
) {
}
