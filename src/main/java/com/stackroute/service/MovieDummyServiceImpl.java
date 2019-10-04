package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.exception.MovieAlreadyExistsException;
import com.stackroute.exception.MovieNotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("dev")

public class MovieDummyServiceImpl implements MovieService {
    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        return null;
    }

    @Override
    public List<Movie> getMovieList() {
        return null;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return null;
    }

    @Override
    public Movie deleteMovie(int movieId) throws MovieNotFoundException {
        return null;
    }

    @Override
    public List<Movie> getMovieByName(String movieTitle) {
        return null;
    }
}
