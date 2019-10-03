package com.stackroute.service;


import com.stackroute.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieService {
    //To save the movie in repository
    public Movie saveMovie(Movie movie);

    //to get the list of stored movies
    public List<Movie> getMovieList();

    //to update the movie
    public Movie updateMovie(Movie movie);

    //to delete the movie with given movieId
    public Movie deleteMovie(Integer movieId);

    //to search movie by movieTitle
    public List<Movie> getMovieByName(String movieTitle);

}

