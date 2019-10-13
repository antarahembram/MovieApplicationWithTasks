package com.stackroute.seeder;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@PropertySource("application.properties")
/*
 CommandLineRunner is used to pre-fill data
 */
public class SeederCommandLineRunner implements CommandLineRunner {
    @Autowired
    private MovieRepository movieRepository; // MovieRepository is needed to save the data

    @Value("${genre}")    //setting the variable genre = the value of genre propertysource
    private  String genre;

    @Value("${movieTitle}")  //setting the variable movieTitle = the value of movieTitle propertysource
    private  String movieTitle;

    @Value("${language1}") //setting the variable language = the value of language1 propertysource
    private  String language;

    @Value("${status}")    //setting the variable status = the value of status propertysource
    private  String status;
    @Value("${voteCount}") //setting the variable voteCount = the value of voteCount propertysource
    private  long voteCount;
    @Value("${budget}")    //setting the variable budget = the value of budget propertysource
    private  String budget;
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Movie movie=new Movie(2,genre,movieTitle,language,status,voteCount,new BigDecimal(budget));

        movieRepository.save(movie); // saving movie in repository
    }
}
