package com.vapsi.app.demo.movies.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vapsi.app.demo.movies.dto.Movie;
import com.vapsi.app.demo.movies.service.MoviesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MoviesController.class)
class MoviesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MoviesService moviesService;

    @Test
    void shouldExpectOKForMoviesReturned() throws Exception {
        mockMvc.perform(get("/api/v1/movies/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(moviesService, times(1)).getAllMovies();
    }

    @Test
    void shouldExpectNotFoundErrorWhenUrlIsWrong() throws Exception {
        mockMvc.perform(get("/api/v1/movies")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
        verify(moviesService, times(0)).getAllMovies();
    }

    @Test
    void shouldExpectCreatedIfMovieIsSavedCorrectly() throws Exception {
        Movie movie = new Movie(null, "Movie Name", "Actor Name", "Director Name");
        Movie savedMovie = new Movie(1, "Movie Name", "Actor Name", "Director Name");

        when(moviesService.saveMovie(movie)).thenReturn(savedMovie);

        mockMvc.perform(post("/api/v1/movies/")
                        .content(asJsonString(movie))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(asJsonString(savedMovie)));

        verify(moviesService, times(1)).saveMovie(movie);
    }

    private String asJsonString(Movie movie) {
        try {
            return new ObjectMapper().writeValueAsString(movie);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}