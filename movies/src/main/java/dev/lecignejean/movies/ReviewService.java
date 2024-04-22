package dev.lecignejean.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * Service class for handling operations related to reviews.
 */
@Service
public class ReviewService {

    // Autowired instance of ReviewRepository for database operations related to reviews.
    @Autowired
    private ReviewRepository reviewRepository;

    // Autowired instance of MongoTemplate for executing MongoDB operations.
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Method to create a new review and associate it with a movie.
     *
     * @param reviewBody The content of the review.
     * @param imdbId The IMDB ID of the movie to which the review is to be associated.
     * @return The created review.
     */
    public Review createReviewBy(String reviewBody, String imdbId) {
        // Create and insert a new review into the database.
        Review review = reviewRepository.insert(new Review(reviewBody));

        // Update the movie document associated with the given IMDB ID to include the new review.
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        // Return the created review.
        return review;
    }
}