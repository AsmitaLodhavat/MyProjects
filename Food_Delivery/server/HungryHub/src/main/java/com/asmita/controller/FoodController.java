package com.asmita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asmita.model.Food;
import com.asmita.model.Restaurant;
import com.asmita.model.User;
import com.asmita.request.CreateFoodRequest;
import com.asmita.service.FoodService;
import com.asmita.service.RestaurantService;
import com.asmita.service.UserService;

@RestController
@RequestMapping("/api/food")
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/search")
	public ResponseEntity<List<Food>>searchFood(@RequestParam String name,
			@RequestHeader("Authorization") String jwt) throws Exception {
		User user = userService.findUserByJwtToken(jwt);
		
		List<Food> foods = foodService.searchFood(name);
		
		return new ResponseEntity<>(foods, HttpStatus.CREATED);
	}
	
	@PostMapping("/restaurant/{restaurantId}")
	public ResponseEntity<List<Food>>getRestaurantFood(
			@RequestParam boolean vegetarian,
			@RequestParam boolean seasonal,
			@RequestParam boolean nonveg,
			@RequestParam(required = false) String food_category,
			@PathVariable Long restaurantId,
			@RequestHeader("Authorization") String jwt) throws Exception {
		User user = userService.findUserByJwtToken(jwt);
		
		List<Food> foods = foodService.getRestaurantsFood(restaurantId, vegetarian, nonveg, seasonal, food_category);
		
		return new ResponseEntity<>(foods, HttpStatus.OK);
	}
}
