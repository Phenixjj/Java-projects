package dev.lecignejean.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId>{

    // public Movie find by embedded id
    Optional<Movie> findByImdbId(String imdbId);
}
