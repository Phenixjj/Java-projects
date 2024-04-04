package dev.lecignejean.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * This service class is responsible for handling operations related to movies.
 */
@Service
public class MovieService {

    // MovieRepository instance for interacting with the database
    @Autowired
    private MovieRepository movieRepository;

    /**
     * This method is used to fetch all the movies from the database.
     * @return List<Movie> This returns a list of all movies.
     */
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    /**
     * This method is used to fetch a movie by its ObjectId.
     * @param id This is the id of the movie to be fetched.
     * @return Optional<Movie> This returns an Optional that contains the movie if it exists, else returns an empty Optional.
     */
    public Optional<Movie> getMovieById(ObjectId id){
        return movieRepository.findById(id);
    }

    /**
     * This method is used to fetch a movie by its IMDB id.
     * @param imdbId This is the IMDB id of the movie to be fetched.
     * @return Optional<Movie> This returns an Optional that contains the movie if it exists, else returns an empty Optional.
     */
    public Optional<Movie> getMovieByImbId(String imdbId){
        return movieRepository.findByImdbId(imdbId);
    }
}