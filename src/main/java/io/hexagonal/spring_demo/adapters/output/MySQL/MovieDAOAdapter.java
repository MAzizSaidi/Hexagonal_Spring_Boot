package io.hexagonal.spring_demo.adapters.output.MySQL;

import io.hexagonal.spring_demo.adapters.output.MySQL.Entities.MovieEntity;
import io.hexagonal.spring_demo.adapters.output.MySQL.Repositories.MoviesRepository;
import io.hexagonal.spring_demo.application.DAO.MovieDAO;
import io.hexagonal.spring_demo.application.DTO.MovieDTO;
import io.hexagonal.spring_demo.domain.Movie;
import io.hexagonal.spring_demo.infrastructure.Exceptions.MovieNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
public class MovieDAOAdapter implements MovieDAO {

    private final MoviesRepository moviesRepository;

    @Override
    public Optional<Movie> findMovieByTitle(String title) {
        return moviesRepository.findByTitle(title);
    }

@Override
public List<Movie> findAllMovies() {
    var MoviesList = (List<MovieEntity>) moviesRepository.findAll();
    return MoviesList.stream()
            .map(MovieEntity -> new Movie(
                    MovieEntity.id(),
                    MovieEntity.Title(),
                    MovieEntity.Director(),
                    MovieEntity.Description(),
                    MovieEntity.Duration()
            )).toList();
}

    @Override
    public void saveMovie(MovieDTO movieDTO) {
        moviesRepository.save(new MovieEntity(
                null,
                movieDTO.Title(),
                movieDTO.Director(),
                movieDTO.Description(),
                movieDTO.Duration(),
                null
        ));
    }

    @Override
    public void deleteMovieByTitle(String title) {
        Movie deleteMovie = moviesRepository.findByTitle(title)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with title: " + title));
//        moviesRepository.delete(deleteMovie);
    }

    @Override
public void updateMovie(MovieDTO movieDTO) {
    Movie movieEntity = moviesRepository.findByTitle(movieDTO.Title())
            .orElseThrow(() -> new MovieNotFoundException("Movie not found with title: " + movieDTO.Title()));
    moviesRepository.save(new MovieEntity(
            movieEntity.id(),
            movieDTO.Title(),
            movieDTO.Director(),
            movieDTO.Description(),
            movieDTO.Duration(),
            null
    ));
}
}
