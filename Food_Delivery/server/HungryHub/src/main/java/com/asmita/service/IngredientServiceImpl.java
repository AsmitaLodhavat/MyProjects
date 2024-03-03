package com.asmita.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asmita.model.IngredientCategory;
import com.asmita.model.IngredientsItem;
import com.asmita.model.Restaurant;
import com.asmita.repository.IngredientCategoryRepository;
import com.asmita.repository.IngredientItemRepository;

@Service
public class IngredientServiceImpl implements IngredientsService{
	
	
	@Autowired
	private IngredientItemRepository ingredientItemRepository;
	
	@Autowired
	private IngredientCategoryRepository ingredientCategoryRepository;
	
	@Autowired
	private RestaurantService restaurantService;

	@Override
	public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception {
		// TODO Auto-generated method stub
		
		Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);
		
		IngredientCategory category = new IngredientCategory();
		category.setRestaurant(restaurant);
		category.setName(name);
		
		return ingredientCategoryRepository.save(category);
	}

	@Override
	public IngredientCategory findIngredientCategoryById(Long id) throws Exception {

		Optional<IngredientCategory> opt = ingredientCategoryRepository.findById(id);
		
		if(opt.isEmpty()) {
			throw new Exception("Ingredient Category Not Found.");
		}
		return opt.get();
	}

	@Override
	public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception {
		restaurantService.findRestaurantById(id);
		return ingredientCategoryRepository.findByRestaurantId(id);
	}

	@Override
	public IngredientsItem createIngredientItem(Long restaurantId, String ingredientName, Long categoryId)
			throws Exception {
		Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);
		IngredientCategory category = findIngredientCategoryById(categoryId);
		IngredientsItem item = new IngredientsItem();
		item.setName(ingredientName);
		item.setRestaurant(restaurant);
		item.setCategory(category);
		
		IngredientsItem ingredient = ingredientItemRepository.save(item);
		category.getIngredients().add(ingredient);
		return ingredient;
	}

	@Override
	public List<IngredientsItem> findRestaurantsIngredients(Long RestaurantId) {
		
		return ingredientItemRepository.findByRestaurantId(RestaurantId);
	}

	@Override
	public IngredientsItem updateStock(Long id) throws Exception {
		// TODO Auto-generated method stub
		Optional<IngredientsItem> optionalIngredientsItem = ingredientItemRepository.findById(id);
		if(optionalIngredientsItem.isEmpty()) {
			throw new Exception("Ingredient Not Found");
		}
		IngredientsItem ingredientsItem = optionalIngredientsItem.get();
		ingredientsItem.setInStock(!ingredientsItem.isInStock());
		return ingredientItemRepository.save(ingredientsItem);
	}
	

}
