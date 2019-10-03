package com.stackroute.seeder;

import com.stackroute.controller.MovieController;
import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import com.stackroute.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataSeeder implements ApplicationListener <ApplicationReadyEvent>{
  @Autowired
   MovieRepository movieRepository;

    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

   @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        Movie movie=new Movie("Drama","Fight Club2","en","Released",77890,new BigDecimal(5887889));

    movieRepository.save(movie);
    }
}
