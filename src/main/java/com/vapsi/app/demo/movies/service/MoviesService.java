package com.vapsi.app.demo.movies.service;

import com.vapsi.app.demo.movies.dto.Movies;
import com.vapsi.app.demo.movies.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {
    MoviesRepository moviesRepository;

    @Autowired
    public MoviesService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public List<Movies> getAllMovies(){
        return moviesRepository.getAllMovies();
    }



}
