package com.asmita.controller;

import com.asmita.Exception.ReviewException;
import com.asmita.Exception.UserException;
import com.asmita.model.Review;
import com.asmita.model.User;
import com.asmita.request.ReviewRequest;
import com.asmita.service.ReviewSerive;
import com.asmita.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {
	@Autowired
	private ReviewSerive reviewService;
	@Autowired
	private UserService userService;
	
	@PostMapping("/review")
	public ResponseEntity<Review> createReview(@RequestBody ReviewRequest review,@RequestHeader("Authorization") String jwt) throws UserException{
		User user =userService.findUserProfileByJwt(jwt);
		Review submitedReview = reviewService.submitReview(review,user);
		return ResponseEntity.ok(submitedReview);
	}

	  

	    @DeleteMapping("/delete/{reviewId}")
	    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) throws ReviewException {
	        reviewService.deleteReview(reviewId);
	        return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
	    }

	    @GetMapping("/average-rating")
	    public ResponseEntity<Double> calculateAverageRating(@RequestBody List<Review> reviews) {
	        double averageRating = reviewService.calculateAverageRating(reviews);
	        return new ResponseEntity<>(averageRating, HttpStatus.OK);
	    }
	}



