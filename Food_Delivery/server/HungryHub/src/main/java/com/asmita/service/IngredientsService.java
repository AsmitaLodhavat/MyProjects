package com.asmita.service;

import java.util.List;

import com.asmita.model.IngredientCategory;
import com.asmita.model.IngredientsItem;

public interface IngredientsService {
	
	public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception;
	
	public IngredientCategory findIngredientCategoryById(Long id) throws Exception;
	
	public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception;
	
	public IngredientsItem createIngredientItem(Long restaurantId, String ingredientName, Long CategoryId) throws Exception;
	
	public List<IngredientsItem> findRestaurantsIngredients(Long RestaurantId);
	
	public IngredientsItem updateStock(Long id) throws Exception;

}
