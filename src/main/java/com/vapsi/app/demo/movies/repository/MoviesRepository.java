package com.vapsi.app.demo.movies.repository;

import com.vapsi.app.demo.movies.dto.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MoviesRepository {

    List<Movie> allMovies = new ArrayList<Movie>(Arrays.asList(new Movie(101, "pirates of caribbean", "Johny Depp", "Gore Verbinsky"),
            new Movie(102, "The Fight club", "Brad pitt", "David Fincher"),
            new Movie(103, "Interstellar", "Mathew McConaughey", "Christopher Nolan"),
            new Movie(104, "pulp fiction", "Samuel L Johnson", "Quintine torentino")));

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public Movie saveMovie(Movie movie) {
        int newId = allMovies.get(allMovies.size() - 1).getId() + 1;
        Movie movieToBeSaved = new Movie(newId, movie.getName(),
                movie.getActorName(), movie.getDirectorName());
        allMovies.add(movieToBeSaved);
        return movieToBeSaved;
    }
}
