package dev.lecignejean.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

/**
 * Represents a movie in the application.
 * This class is a MongoDB document stored in the "movies" collection.
 */
@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    /**
     * The unique identifier of the movie.
     * This field is automatically generated by MongoDB.
     */
    @Id
    private ObjectId id;

    /**
     * The unique identifier of the movie in the IMDb database.
     */
    private String imdbId;

    /**
     * The title of the movie.
     */
    private String title;

    /**
     * The release date of the movie.
     */
    private String releaseDate;

    /**
     * The link to the movie's trailer.
     */
    private String trailerLink;

    /**
     * The genres of the movie.
     * This is a list of strings, each representing a genre.
     */
    private List<String> genres;

    /**
     * The backdrops of the movie.
     * This is a list of strings, each representing a backdrop.
     */
    private List<String> backdrops;

    /**
     * The reviews of the movie.
     * This is a list of Review objects, each representing a review.
     * The reviews are stored as references, not embedded documents.
     */
    @DocumentReference
    private List<Review> reviewIds;
}