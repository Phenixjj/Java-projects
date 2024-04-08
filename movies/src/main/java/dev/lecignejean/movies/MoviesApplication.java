package dev.lecignejean.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the main application class for the Movies application.
 * It is annotated with @SpringBootApplication, indicating that it is a Spring Boot application.
 * It also includes a Rest Controller for the root ("/") endpoint.
 */
@SpringBootApplication
@RestController
public class MoviesApplication {

	/**
	 * This is the main method that starts the Spring Boot application.
	 * @param args Command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	/**
	 * This is a Rest Controller method for the root ("/") endpoint.
	 * It returns a simple "Hello, world!" message.
	 * @return A String containing "Hello, world!".
	 */
	@GetMapping("/")
	public String apiRoot() {
		return "Hello, world!";
	}
}