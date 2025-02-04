package io.hexagonal.spring_demo.adapters.output.MySQL.Repositories;

import io.hexagonal.spring_demo.adapters.output.MySQL.Entities.MovieEntity;
import io.hexagonal.spring_demo.domain.Movie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MoviesRepository extends CrudRepository<MovieEntity, Long> {
    @Query("SELECT * FROM movies WHERE title = :title")
    Optional<Movie> findByTitle(String title);

}
