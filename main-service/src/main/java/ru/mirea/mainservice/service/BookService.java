package ru.mirea.mainservice.service;

import ru.mirea.mainservice.model.Book;
import ru.mirea.mainservice.model.Cart;

public interface BookService extends Base<Book, Long> {

    Cart addToCart(Long itemId, Long userId, Integer cartItemsAmount);

}
