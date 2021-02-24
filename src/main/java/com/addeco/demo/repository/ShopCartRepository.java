package com.addeco.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.addeco.demo.entity.ShopCart;

public interface ShopCartRepository extends JpaRepository<ShopCart, Long> {



}
