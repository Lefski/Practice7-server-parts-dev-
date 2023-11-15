package ru.mirea.mainservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.mainservice.model.Cart;
import ru.mirea.mainservice.model.Client;
import ru.mirea.mainservice.service.ClientServiceImpl;

@RestController
@RequestMapping("/clients")
public class ClientController extends BaseController<Client, Long, ClientServiceImpl> {


    @Autowired
    public ClientController(ClientServiceImpl clientService) {
        super(clientService);
    }

    @PostMapping("/create")
    ResponseEntity<Client> createClient(
            @RequestBody Client client
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createClient(client));
    }

    @GetMapping("/cart/{userId}/{cartId}")
    ResponseEntity<Cart> getCart(
            @PathVariable Long userId,
            @PathVariable Long cartId
    ) {
        return ResponseEntity.ok(service.getCart(userId, cartId));
    }

    @DeleteMapping("/cart/{userId}/{cartId}/{cartItemId}")
    ResponseEntity<Cart> deleteCartItem(
            @PathVariable Long userId,
            @PathVariable Long cartId,
            @PathVariable Long cartItemId
    ) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.deleteCartItem(userId, cartId, cartItemId));
    }

    @PatchMapping("/cart/{userId}/{cartId}/{cartItemId}/{cartItemAmount}")
    ResponseEntity<Cart> changeCartItemAmount(
            @PathVariable Long userId,
            @PathVariable Long cartId,
            @PathVariable Long cartItemId,
            @PathVariable Integer cartItemAmount
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(service.changeItemsAmount(userId, cartId, cartItemId, cartItemAmount));
    }

    @PostMapping("/cart/{userId}/{cartId}")
    ResponseEntity<Cart> makeOrder(
            @PathVariable Long userId,
            @PathVariable Long cartId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(service.makeOrder(userId, cartId));
    }
}

