package com.stackroute.controller;

import com.stackroute.domain.Movie;
import com.stackroute.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/")
public class MovieController {
    MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie)
    {
        ResponseEntity responseEntity;
        try{
            responseEntity=new ResponseEntity<Movie>(movieService.saveMovie(movie), HttpStatus.CREATED);
        }
        catch (Exception e){
            responseEntity=new ResponseEntity<String>("Failed in creation",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("movies")
    public ResponseEntity<?> getMovieList()
    {
        ResponseEntity responseEntity;
        try{

            responseEntity=new ResponseEntity<List<Movie>>(movieService.getMovieList(), HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity=new ResponseEntity<String>("Failed in getting the list of Movies",HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }



    @PatchMapping("movies")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie)
    {
        ResponseEntity responseEntity;
        try{

            responseEntity=new ResponseEntity<Movie>(movieService.updateMovie(movie), HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity=new ResponseEntity<String>("Update failed",HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @DeleteMapping("movies/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable("movieId") int movieId)
    {
        ResponseEntity responseEntity;
        try{

            responseEntity=new ResponseEntity<Movie>(movieService.deleteMovie(movieId), HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity=new ResponseEntity<String>("Deletion is failed",HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }


    @GetMapping("movies/{movieTitle}")
    public ResponseEntity<?> getMovieByName(@PathVariable("movieTitle") String movieTitle)
    {
        ResponseEntity responseEntity;
        try{
            responseEntity=new ResponseEntity<List<Movie>>(movieService.getMovieByName(movieTitle), HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity=new ResponseEntity<String>("Searching is failed",HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }


}
