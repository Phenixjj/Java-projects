package dev.lecignejean.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

/**
 * This is a Rest Controller for managing movies.
 * It provides endpoints to get all movies, get a movie by its id and get a movie by its IMDB id.
 */
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    // MovieService is used to interact with the database.
    @Autowired
    private MovieService movieService;

    /**
     * This method is used to get all the movies.
     * @return ResponseEntity<List<Movie>> This returns a list of all movies with HTTP status code.
     */
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    /**
     * This method is used to get a movie by its id.
     * @param id This is the id of the movie to be fetched.
     * @return ResponseEntity<Optional<Movie>> This returns the movie with the given id with HTTP status code.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(id), HttpStatus.OK);
    }

    /**
     * This method is used to get a movie by its IMDB id.
     * @param imdbId This is the IMDB id of the movie to be fetched.
     * @return ResponseEntity<Optional<Movie>> This returns the movie with the given IMDB id with HTTP status code.
     */
    @GetMapping("/imdb/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieByImbId(imdbId), HttpStatus.OK);
    }
}