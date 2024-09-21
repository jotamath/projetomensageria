package io.github.jotamath.projetomensageria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.jotamath.projetomensageria.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
