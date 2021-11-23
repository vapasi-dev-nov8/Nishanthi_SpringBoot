package com.vapsi.app.demo.movies.repository;

import com.vapsi.app.demo.movies.dto.Movies;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MoviesRepository {

    public List<Movies> getAllMovies() {
        List<Movies> allMovies = new ArrayList<>();
        allMovies.add(new Movies("pirates of caribbean", "Johny Depp", "Gore Verbinsky"));
        allMovies.add(new Movies("The Fight club", "Brad pitt", "David Fincher"));
        allMovies.add(new Movies("Interstellar", "Mathew McConaughey", "Christopher Nolan"));
        allMovies.add(new Movies("pulp fiction", "Samuel L Johnson", "Quintine torentino"));
        return allMovies;
    }
}
