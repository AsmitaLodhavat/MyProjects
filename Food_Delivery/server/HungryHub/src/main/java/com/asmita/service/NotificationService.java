package com.asmita.service;

import java.util.List;

import com.asmita.model.Notification;
import com.asmita.model.Order;
import com.asmita.model.Restaurant;
import com.asmita.model.User;

public interface NotificationService {
	
	public Notification sendOrderStatusNotification(Order order);
	public void sendRestaurantNotification(Restaurant restaurant, String message);
	public void sendPromotionalNotification(User user, String message);
	
	public List<Notification> findUsersNotification(Long userId);

}
