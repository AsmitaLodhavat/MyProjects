package com.asmita.service;

import java.util.List;

import com.asmita.Exception.CartException;
import com.asmita.Exception.OrderException;
import com.asmita.Exception.RestaurantException;
import com.asmita.Exception.UserException;
import com.asmita.model.Order;
import com.asmita.model.PaymentResponse;
import com.asmita.model.User;
import com.asmita.request.CreateOrderRequest;
import com.stripe.exception.StripeException;

public interface OrderService {
	
	 public PaymentResponse createOrder(CreateOrderRequest order, User user) throws UserException, RestaurantException, CartException, StripeException;
	 
	 public Order updateOrder(Long orderId, String orderStatus) throws OrderException;
	 
	 public void cancelOrder(Long orderId) throws OrderException;
	 
	 public List<Order> getUserOrders(Long userId) throws OrderException;
	 
	 public List<Order> getOrdersOfRestaurant(Long restaurantId,String orderStatus) throws OrderException, RestaurantException;
	 

}
