package com.vut.fit.pis2020.model.Service.Interface;

import com.vut.fit.pis2020.model.CartItem;

import java.util.List;

public interface ICartItemService {
    List<CartItem> findAll();
}
