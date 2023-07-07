package dev.krishna.movies.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import dev.krishna.movies.model.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    Optional<List<Movie>> findMovieByTitle(String title);

    Optional<Movie> findMovieByImdbId(String id);


}
