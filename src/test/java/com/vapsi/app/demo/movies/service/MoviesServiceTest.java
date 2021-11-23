package com.vapsi.app.demo.movies.service;

import com.vapsi.app.demo.movies.dto.Movies;
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
import java.util.UUID;

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
        List<Movies> allMovies = new ArrayList<>();
        allMovies.add(new Movies("pirates of caribbean", "Johny Depp", "Gore Verbinsky"));
        allMovies.add(new Movies("The Fight club", "Brad pitt", "David Fincher"));
        allMovies.add(new Movies("Interstellar", "Mathew McConaughey", "Christopher Nolan"));
        allMovies.add(new Movies("pulp fiction", "Samuel L Johnson", "Quintine torentino"));
        when(moviesRepository.getAllMovies()).thenReturn(allMovies);
        List<Movies> totalMovies = moviesService.getAllMovies();
        verify(moviesRepository, times(1)).getAllMovies();
        assertEquals(allMovies, totalMovies);
    }

    @Test
    public void getEmptyMoviesWhenNoMoviesAddedToList(){
        List<Movies> allMovies = new ArrayList<>();
        when(moviesRepository.getAllMovies()).thenReturn(allMovies);
        List<Movies> totalMovies = moviesService.getAllMovies();
        verify(moviesRepository, times(1)).getAllMovies();
        assertEquals(allMovies.size(), 0);
    }

}