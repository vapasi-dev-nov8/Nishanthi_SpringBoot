package com.vapsi.app.demo.movies.service;

import com.vapsi.app.demo.movies.dto.Movie;
import com.vapsi.app.demo.movies.repository.MoviesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest(classes = MoviesService.class)
@RunWith(MockitoJUnitRunner.class)
class MoviesServiceTest {

    @InjectMocks
    MoviesService moviesService;

    @MockBean
    MoviesRepository moviesRepository;

    @BeforeEach
    void setUp() {
        this.moviesService.moviesRepository = this.moviesRepository;
    }

    @Test
    public void getAllMoviesAddedToList(){
        List<Movie> allMovies = new ArrayList<>();
        allMovies.add(new Movie(101, "pirates of caribbean", "Johny Depp", "Gore Verbinsky"));
        allMovies.add(new Movie(102, "The Fight club", "Brad pitt", "David Fincher"));
        allMovies.add(new Movie(103, "Interstellar", "Mathew McConaughey", "Christopher Nolan"));
        allMovies.add(new Movie(104, "pulp fiction", "Samuel L Johnson", "Quintine torentino"));
        when(moviesRepository.getAllMovies()).thenReturn(allMovies);
        List<Movie> totalMovies = moviesService.getAllMovies();
        verify(moviesRepository, times(1)).getAllMovies();
        assertEquals(allMovies, totalMovies);
    }

    @Test
    public void getEmptyMoviesWhenNoMoviesAddedToList(){
        List<Movie> allMovies = new ArrayList<>();
        when(moviesRepository.getAllMovies()).thenReturn(allMovies);
        List<Movie> totalMovies = moviesService.getAllMovies();
        verify(moviesRepository, times(1)).getAllMovies();
        assertEquals(allMovies.size(), 0);
    }

}