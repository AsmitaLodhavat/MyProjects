package com.asmita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asmita.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
