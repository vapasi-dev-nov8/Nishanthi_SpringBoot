package com.vapsi.app.demo.movies.controller;

import com.vapsi.app.demo.movies.service.MoviesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

}