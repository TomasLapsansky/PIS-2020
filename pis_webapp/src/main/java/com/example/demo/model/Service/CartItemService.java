package com.example.demo.model.Service;

import com.example.demo.model.CartItem;
import com.example.demo.model.Repository.CartItemRepository;
import com.example.demo.model.Service.Interface.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartItemService implements ICartItemService {

    @Autowired
    private CartItemRepository repository;

    @Override
    public List<CartItem> findAll() {
        return (List<CartItem>) repository.findAll();
    }

}
