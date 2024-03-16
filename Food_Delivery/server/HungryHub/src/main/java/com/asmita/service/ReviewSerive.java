package com.asmita.service;

import java.util.List;

import com.asmita.Exception.ReviewException;
import com.asmita.model.Review;
import com.asmita.model.User;
import com.asmita.request.ReviewRequest;

public interface ReviewSerive {
	
    public Review submitReview(ReviewRequest review,User user);
    public void deleteReview(Long reviewId) throws ReviewException;
    public double calculateAverageRating(List<Review> reviews);
}
