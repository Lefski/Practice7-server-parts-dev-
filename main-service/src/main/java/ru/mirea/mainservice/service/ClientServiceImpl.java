package ru.mirea.mainservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.mainservice.exception.AccessException;
import ru.mirea.mainservice.exception.ValidationException;
import ru.mirea.mainservice.model.Cart;
import ru.mirea.mainservice.model.CartItem;
import ru.mirea.mainservice.model.Client;
import ru.mirea.mainservice.repository.CartItemsRepository;
import ru.mirea.mainservice.repository.CartRepository;
import ru.mirea.mainservice.repository.ClientRepository;

import java.util.List;
import java.util.Objects;

@Service
public class ClientServiceImpl extends BaseImpl<Client, Long> implements ClientService {
    private final CartRepository cartRepository;
    private final CartItemsRepository cartItemsRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository repository, CartRepository cartRepository, CartItemsRepository cartItemsRepository) {
        super(repository);
        this.cartRepository = cartRepository;
        this.cartItemsRepository = cartItemsRepository;
    }

    private static void checkAccess(Long userId, Long cartId) {
        if (!Objects.equals(userId, cartId)) {
            throw new AccessException("У вас нет доступа к данной корзине");
        }
    }

    @Override
    public Client createClient(Client client) {
        Client savedClient = repository.save(client);
        Cart cart = Cart.builder()
                .id(savedClient.getId())
                .build();
        cartRepository.save(cart);
        return savedClient;
    }

    @Override
    public Cart deleteCartItem(Long userId, Long cartId, Long cartItem) {
        checkAccess(userId, cartId);
        cartItemsRepository.deleteById(cartId);
        return cartRepository.findById(cartId).orElseThrow();
    }

    @Override
    public Cart changeItemsAmount(Long userId, Long cartId, Long cartItem, Integer cartItemAmount) {
        checkAccess(userId, cartId);
        if (cartItemAmount > 10) {
            throw new ValidationException("Невозможно добавить в корзину, товара нет на складе");
        }
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        List<CartItem> cartItemList = cart.getCartItems();
        for (CartItem cartItemIter : cartItemList) {
            if (cartItemIter.getCartItemId().equals(cartItem)) {
                cartItemIter.setCartItemsAmount(cartItemAmount);
                cartItemsRepository.save(cartItemIter);
            }
        }
        return cartRepository.findById(cartId).orElseThrow();
    }

    @Override
    public Cart getCart(Long userId, Long cartId) {
        checkAccess(userId, cartId);
        return cartRepository.findById(cartId).orElseThrow();
    }

    @Override
    public Cart makeOrder(Long userId, Long cartId) {
        checkAccess(userId, cartId);
        cartRepository.deleteById(cartId);
        return cartRepository.save(
                Cart.builder()
                        .id(userId)
                        .build()
        );
    }
}
