package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.exception.MovieAlreadyExistsException;
import com.stackroute.exception.MovieNotFoundException;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod")
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        if(movieRepository.existsById(movie.getMovieId()))       //if movie exists with that movieId throw exception
        {
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        Movie savedMovie= movieRepository.save(movie);
        if(savedMovie==null)
        {
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        return savedMovie;
    }

    @Override
    public List<Movie> getMovieList() {
        return movieRepository.findAll();
    }


    @Override
    public Movie updateMovie(Movie movie) {
        Movie updatedMovie=movieRepository.findById(movie.getMovieId()).get();
        if(movie.getMovieTitle()!=null)
            updatedMovie.setMovieTitle(movie.getMovieTitle());
        if(movie.getGenre()!=null)
            updatedMovie.setGenre(movie.getGenre());
        if(movie.getLanguage()!=null)
            updatedMovie.setLanguage(movie.getLanguage());
        if(movie.getVoteCount()!=0)
            updatedMovie.setVoteCount(movie.getVoteCount());
        if(movie.getStatus()!=null)
            updatedMovie.setStatus(movie.getStatus());
        if(movie.getBudget().intValue()!=0)
            updatedMovie.setBudget(movie.getBudget());

        return movieRepository.save(updatedMovie);
    }

    @Override
    public Movie deleteMovie(int movieId) throws MovieNotFoundException {
        if(!movieRepository.existsById(movieId))  // if no movie exists with that movieId throw exception
        {
            throw new MovieNotFoundException("Movie is not found");
        }
        Movie movie=movieRepository.findById(movieId).get();
        if(movie==null)
        {
            throw new MovieNotFoundException("Movie is not found");
        }
        movieRepository.deleteById(movieId);
        return movie;
    }

    @Override
    public List<Movie> getMovieByName(String movieTitle) throws MovieNotFoundException {
        List<Movie> movies=movieRepository.getMovieByName(movieTitle);
        if(movies.size()==0) //if movies contains no movie then throw exception
        {
            throw new MovieNotFoundException("Movie is not found");
        }
        return movies;
    }


}