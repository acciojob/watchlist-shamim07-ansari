package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    Map<String, Movie> movieDb = new HashMap<>();
    Map<String, Director> directorDb = new HashMap<>();
    Map<String, String> movieDirectorPair = new HashMap<>();
    // 1
    public String addMovie(Movie movie) {
        String key = movie.getName();
        movieDb.put(key, movie);
        return "Movie added successfully";
    }
    // 2
    public String addDirector(Director director) {
        String key = director.getName();
        directorDb.put(key, director);
        return "Director added successfully";
    }
    // 3
    public String pairMovieDirector(String movieName, String directorName) {
        movieDirectorPair.put(movieName, directorName);
        return "Connected them successfully";
    }
    // 4
    public Movie getMovieByName(String movieName) {
        Movie movie = movieDb.get(movieName);
        return movie;
    }
    // 5
    public Director getDirectorByName(String directorName) {
        Director director = directorDb.get(directorName);
        return director;
    }
    // 6
    public List<Movie> getMoviesByDirectorName(String directorName) {
        List<Movie> list = new ArrayList<>();
        for(Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
            if(entry.getValue().equals(directorName)) {
                String movieName = entry.getKey();
                Movie movie = movieDb.get(movieName);
                list.add(movie);
            }
        }
        return list;
    }
    // 7
    public List<Movie> findAllMovies() {
        List<Movie> list = new ArrayList<>();
        for(Movie movie : movieDb.values()) {
            list.add(movie);
        }
        return list;
    }
    // 8
    public String deleteDirectorByName(String directorName) {
        directorDb.remove(directorName);

        for(Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
            if(entry.getValue().equals(directorName)) {
                String movieName = entry.getKey();
                movieDb.remove(movieName);
                movieDirectorPair.remove(movieName);
            }
        }
        return "Director remove successfully";
    }
    // 9
    public String deleteAllDirectors() {
        for(String directorName : directorDb.keySet()) {
            directorDb.remove(directorName);
            for(Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
                if (entry.getValue().equals(directorName)) {
                    String movieName = entry.getKey();
                    movieDb.remove(movieName);
                    movieDirectorPair.remove(movieName);
                }
            }
        }
        return "All director remove successfully";
    }
}
