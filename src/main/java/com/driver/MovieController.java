package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moves")
public class MovieController {
    @Autowired
    MovieService movieService;

    // 1
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        String ans = movieService.addMovie(movie);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
    // 2
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        String ans = movieService.addDirector(director);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
    // 3
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie")String movieName, @RequestParam("directorName")String directorName) {
        String ans = movieService.pairMovieDirector(movieName, directorName);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
    // 4
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("movieName") String movieName) {
        Movie movie = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }
    // 5
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("director")String directorName) {
        Director director = movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }
    // 6
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(@PathVariable("directorName")String directorName) {
        List<Movie> list = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }
    // 7
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies() {
        List<Movie> list = movieService.findAllMovies();
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }
    // 8
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName") String directorName) {
        String ans = movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
    // 9
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        String ans = movieService.deleteAllDirectors();
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
}
