package com.stackroute.seeder;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


//pre filling data using commandlineRunner
@Component
public class SeederCommandLineRunner implements CommandLineRunner {
    @Autowired
    private MovieRepository movieRepository;

    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Movie movie=new Movie("Drama","Fight Club","en","Released",77890,new BigDecimal(5887889));
        movieRepository.save(movie);
    }
}
