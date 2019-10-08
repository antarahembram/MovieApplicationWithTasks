package com.stackroute.seeder;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//Pre filling data using Aplication Listner
@Component
public class DataSeeder implements ApplicationListener <ApplicationReadyEvent>{
  @Autowired
   private MovieRepository movieRepository;

    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    //As soom as movie Application started this method will be executed
   @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        Movie movie=new Movie("Drama","Fight Club2","en","Released",77890,new BigDecimal(5887889));
        movieRepository.save(movie);
    }
}
