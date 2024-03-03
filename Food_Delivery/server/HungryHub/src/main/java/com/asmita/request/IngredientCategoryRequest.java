package com.asmita.request;

import lombok.Data;

@Data
public class IngredientCategoryRequest {
	
	private String name;
	private Long RestaurantId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getRestaurantId() {
		return RestaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		RestaurantId = restaurantId;
	}

}
