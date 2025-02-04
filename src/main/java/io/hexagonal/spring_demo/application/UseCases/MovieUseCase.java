package io.hexagonal.spring_demo.application.UseCases;

import io.hexagonal.spring_demo.adapters.output.MySQL.Entities.MovieEntity;
import io.hexagonal.spring_demo.application.DAO.MovieDAO;
import io.hexagonal.spring_demo.application.DTO.MovieDTO;
import io.hexagonal.spring_demo.domain.Movie;
import io.hexagonal.spring_demo.infrastructure.Exceptions.MovieAlreadyExistsException;
import io.hexagonal.spring_demo.infrastructure.Exceptions.MovieNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieUseCase{

    private final MovieDAO movieDAO;

    public String saveMovie(MovieEntity movieDTO){

        movieDAO.findMovieByTitle(movieDTO.Title()).ifPresent(movie -> {
            throw new MovieAlreadyExistsException("Movie already exists");
        });
        movieDAO.saveMovie(movieDTO);
        return "Movie saved successfully with title: " + movieDTO.Title();
    }

    public List<Movie> getAllMovies(){
        return movieDAO.findAllMovies();
    }

    public String deleteMovieByTitle(String title){
        movieDAO.findMovieByTitle(title).orElseThrow(
                () -> new MovieNotFoundException("Movie not found")
        );
        movieDAO.deleteMovieByTitle(title);
        return "Movie deleted successfully with title: " + title;
    }

    public String updateMovie(MovieDTO movieDTO){
        movieDAO.findMovieByTitle(movieDTO.Title()).orElseThrow(
                () -> new MovieNotFoundException("Movie not found")
        );
        movieDAO.updateMovie(movieDTO);
        return "Movie updated successfully with title: " + movieDTO.Title();
    }

    public Movie getMovieByTitle(String title){
        return movieDAO.findMovieByTitle(title).orElseThrow(
                () -> new MovieNotFoundException("Movie not found")
        );
    }

}
