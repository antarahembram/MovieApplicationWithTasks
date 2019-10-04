package com.stackroute.seeder;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@PropertySource("application.properties")
public class SeederCommandLineRunner implements CommandLineRunner {
    @Autowired
    MovieRepository movieRepository;

    @Value("${genre}")
    private  String genre;

    @Value("${movieTitle}")
    private  String movieTitle;

    @Value("${language}")
    private  String language;

    @Value("${status}")
    private  String status;
    @Value("${voteCount}")
    private  long voteCount;
    @Value("${budget}")
    private  String budget;
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Movie movie=new Movie(2,genre,movieTitle,language,status,voteCount,new BigDecimal(budget));

        movieRepository.save(movie);
    }
}
