package io.hexagonal.spring_demo.application.DAO;

import io.hexagonal.spring_demo.application.DTO.MovieDTO;
import io.hexagonal.spring_demo.domain.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieDAO {
    Optional<Movie> findMovieByTitle(String title);
    List<Movie> findAllMovies();
    void saveMovie(MovieDTO movieDTO);
    void deleteMovieByTitle(String title);
    void updateMovie(MovieDTO movieDTO);
}
