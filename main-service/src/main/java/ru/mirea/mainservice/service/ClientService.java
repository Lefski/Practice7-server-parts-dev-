package ru.mirea.mainservice.service;

import ru.mirea.mainservice.model.Cart;
import ru.mirea.mainservice.model.Client;

public interface ClientService extends Base<Client, Long> {
    Client createClient(Client client);
    Cart deleteCartItem(Long userId, Long cartId, Long cartItem);
    Cart changeItemsAmount (Long userId, Long cartId, Long cartItem, Integer cartItemAmount);
    Cart getCart(Long userId, Long cartId);
    Cart makeOrder(Long userId, Long cartId);
}
