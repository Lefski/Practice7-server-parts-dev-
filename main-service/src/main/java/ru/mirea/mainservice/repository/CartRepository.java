package ru.mirea.mainservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.mainservice.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
