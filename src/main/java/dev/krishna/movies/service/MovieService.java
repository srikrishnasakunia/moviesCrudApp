package dev.krishna.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import dev.krishna.movies.model.Movie;
import dev.krishna.movies.repository.MovieRepository;

/**
 * Service Class is annotated with @Service annotation.
 * It is responsible for handling the business logic of the respective endpoint by providing
 * Data and applying logic to the data and returning the result to the controller.
 * **/

@Service
public class MovieService {

/**
 * Autowired Annotation is responsible for providing the instance of the requested class.
 * It acts a dependency provider, initiating the class and then providing an instance of it
 * to the requested class.**/
    @Autowired
    private MovieRepository movieRepository;
/**
 * MongoTemplate is a pre-defined class provided by Spring Framework.
 * It is used for writing queries for fetching data from MongoDB.**/
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<List<Movie>> findMovieByTitle(String name){
        return movieRepository.findMovieByTitle(name);
    }

    public Optional<Movie> findMovieById(String id){
        return movieRepository.findMovieByImdbId(id);
    }

    /**
     * We use Query class of SpringFramework to write custom queries such as regex and others
     * to make our own query and then use Mongotemplate class to run those.**/
    public List<Movie> findMoviesContainingString(String name){
        Query query = new Query();
        query.addCriteria(Criteria.where("title").regex(name));
        return mongoTemplate.find(query, Movie.class);
    }
}
