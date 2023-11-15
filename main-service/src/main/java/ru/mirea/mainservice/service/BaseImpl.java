package ru.mirea.mainservice.service;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.mainservice.model.Cart;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@AllArgsConstructor
public class BaseImpl<T, ID extends Serializable> implements Base<T, ID> {

    protected final JpaRepository<T, ID> repository;
    //protected final CartRepository cartRepository;

    @Override
    public T save(T item) {
        return repository.save(item);
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No such item in db"));
    }

    @Override
    public T update(T item) {
        AtomicBoolean flag = new AtomicBoolean(false);
//        repository.findAll().forEach(newItem -> {
//            if (newItem.equals(item)) {
//                flag.set(true);
//            }
//        });
//        if (!flag.get()) {
//            throw new RuntimeException("no such item in db");
//        } //todo refactor put functional, update should be update(id, item)
        return repository.save(item);
    }

    @Override
    public List<T> saveAll(List<T> items) {
        return repository.saveAll(items);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public Cart addToCart(ID itemId, ID userId, Integer cartItemsAmount) {
        return null;//todo add to cart separate to different services
    }
}