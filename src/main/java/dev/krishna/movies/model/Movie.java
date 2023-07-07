package dev.krishna.movies.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Document -> Specifies the collection or Table. In MongoDB, we store data in form of documents.
 * Data -> It's an annotation that creates getters and setters methods for the collection in background, instead of us
 *         having to create it manually. Helps in reducing boilerplate code.
 * AllArgsConstructor ->It's an annotation that specifies and generates constructor with all arguments.
 * NoArgsConstructor -> It's an annotation that specifies and generates constructor with no arguments.
 * DocumentReference -> It's an annotation that connects two different collection together.
 * **/
@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    private ObjectId id;

    private String imdbId;

    private String title;

    private String releaseDate;

    private String trailerLink;

    private String poster;

    private List<String> genres;

    private List<String> backdrops;

    @DocumentReference
    private List<Review> reviewIds;
}
