package com.sparta.greeypeople.order.repository;

import com.sparta.greeypeople.order.entity.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
