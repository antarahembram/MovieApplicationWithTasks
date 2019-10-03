package com.stackroute.seeder;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@PropertySource("application.properties")
public class DataSeeder implements ApplicationListener <ApplicationReadyEvent>{

    @Autowired
    private Environment environment;

   // private  String genre=environment.getProperty("genre");

    @Value("${movieTitle}")
    private  String movieTitle;

    @Value("${language1}")
    private  String language;

    @Value("${status}")
    private  String status;
    @Value("${voteCount}")
    private  long voteCount;
    @Value("${budget}")
    private  String budget;

  @Autowired
   MovieRepository movieRepository;

    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

   @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
       Movie movie=new Movie(3,environment.getProperty("genre"),environment.getProperty("movieTitle"),environment.getProperty("language1"),environment.getProperty("status"),75758,new BigDecimal(environment.getProperty("budget")));

    movieRepository.save(movie);
    }
}
