package com.vapsi.app.demo.movies.repository;

import com.vapsi.app.demo.movies.dto.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MoviesRepository {

    List<Movie> allMovies = new ArrayList<>();
    public List<Movie> getAllMovies() {
        allMovies.add(new Movie("pirates of caribbean", "Johny Depp", "Gore Verbinsky"));
        allMovies.add(new Movie("The Fight club", "Brad pitt", "David Fincher"));
        allMovies.add(new Movie("Interstellar", "Mathew McConaughey", "Christopher Nolan"));
        allMovies.add(new Movie("pulp fiction", "Samuel L Johnson", "Quintine torentino"));
        return allMovies;
    }
}
