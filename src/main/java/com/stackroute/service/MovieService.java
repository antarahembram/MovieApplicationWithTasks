package com.stackroute.service;


import com.stackroute.domain.Movie;

import java.util.List;

public interface MovieService {
    public Movie saveMovie(Movie movie);

    public List<Movie> listMovie();

    public Movie update(Movie movie);

    public Movie deleteMovie(Integer movieId);
}

