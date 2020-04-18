package com.vut.fit.pis2020.model.Service;

import com.vut.fit.pis2020.model.CartItem;
import com.vut.fit.pis2020.model.Repository.CartItemRepository;
import com.vut.fit.pis2020.model.Service.Interface.ICartItemService;
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
