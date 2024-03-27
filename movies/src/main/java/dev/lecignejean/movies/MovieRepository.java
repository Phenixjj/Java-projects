package dev.lecignejean.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId>{

    // public Movie find by embedded id
    public Movie findByImdbId(String imdbId);
}
