package com.asmita.service;

import com.asmita.Exception.CartException;
import com.asmita.Exception.CartItemException;
import com.asmita.Exception.FoodException;
import com.asmita.Exception.UserException;
import com.asmita.model.Cart;
import com.asmita.model.CartItem;
import com.asmita.model.Food;
import com.asmita.model.User;
import com.asmita.request.AddCartItemRequest;
import com.asmita.request.UpdateCartItemRequest;

public interface CartSerive {

	public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws UserException, FoodException, CartException, CartItemException;

	public CartItem updateCartItemQuantity(Long cartItemId,int quantity) throws CartItemException;

	public Cart removeItemFromCart(Long cartItemId, String jwt) throws UserException, CartException, CartItemException;

	public Long calculateCartTotals(Cart cart) throws UserException;
	
	public Cart findCartById(Long id) throws CartException;
	
	public Cart findCartByUserId(Long userId) throws CartException, UserException;
	
	public Cart clearCart(Long userId) throws CartException, UserException;
	

	

}
