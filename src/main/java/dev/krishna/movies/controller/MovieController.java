package dev.krishna.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


import dev.krishna.movies.model.Movie;
import dev.krishna.movies.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @RequestMapping(value = "/searchByTitle={title}", method = RequestMethod.GET)
    public ResponseEntity<Optional<List<Movie>>> getMovieByTitle(@PathVariable String title){
        return new ResponseEntity<Optional<List<Movie>>>(movieService.findMovieByTitle(title), HttpStatus.OK);
    }

    @RequestMapping(value = "/searchById={id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String id){
        return new ResponseEntity<Optional<Movie>>(movieService.findMovieById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/searchAllMoviesContaining{letter}", method = RequestMethod.GET)
    public ResponseEntity<Optional<List<Movie>>> getMovieByQuery(@PathVariable String letter) {
        List<Movie> movieList = movieService.findMoviesContainingString(letter);
        if (movieList!=null) return new ResponseEntity<>(Optional.of(movieList),HttpStatus.OK);
        return null;
    }
}
