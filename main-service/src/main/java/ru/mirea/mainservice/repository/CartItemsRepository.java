package ru.mirea.mainservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.mainservice.model.CartItem;

public interface CartItemsRepository extends JpaRepository<CartItem, Long> {
}
