package dev.krishna.movies.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.krishna.movies.model.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}