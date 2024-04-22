package dev.lecignejean.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * This is a Rest Controller for managing reviews.
 * It provides an endpoint to create a new review.
 */
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    // ReviewService is used to interact with the database.
    @Autowired
    private ReviewService reviewService;

    /**
     * This method is used to create a new review.
     * @param payload This is a map containing the review body and the IMDB id of the movie the review is for.
     * @return ResponseEntity<Review> This returns the created review with HTTP status code.
     */
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(reviewService.createReviewBy(payload.get("reviewBody"), payload.get("imdbId")),
                HttpStatus.CREATED);
    }
}