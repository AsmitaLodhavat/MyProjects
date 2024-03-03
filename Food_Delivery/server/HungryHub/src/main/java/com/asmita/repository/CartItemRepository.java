package com.asmita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asmita.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

}
