package io.hexagonal.spring_demo.adapters.input.Web;

import io.hexagonal.spring_demo.adapters.output.MySQL.Entities.MovieEntity;
import io.hexagonal.spring_demo.application.DTO.MovieDTO;
import io.hexagonal.spring_demo.application.UseCases.MovieUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieUseCase movieUseCase;

    @GetMapping("/all")
    public ResponseEntity<?> getAllMovies(){
        return ResponseEntity.ok(movieUseCase.getAllMovies());
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getMovieByTitle(@PathVariable String title){
        return ResponseEntity.ok(movieUseCase.getMovieByTitle(title));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveMovie(@RequestBody MovieEntity movieDTO){
        return ResponseEntity.ok(movieUseCase.saveMovie(movieDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateMovie(@RequestBody MovieDTO movieDTO){
        return ResponseEntity.ok(movieUseCase.updateMovie(movieDTO));
    }

    @DeleteMapping("/delete/{title}")
    public ResponseEntity<?> deleteMovieByTitle(@PathVariable String title){
        return ResponseEntity.ok(movieUseCase.deleteMovieByTitle(title));
    }
}
