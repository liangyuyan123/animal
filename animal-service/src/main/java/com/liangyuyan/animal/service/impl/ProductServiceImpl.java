package com.liangyuyan.animal.service.impl;

import com.liangyuyan.animal.dao.ProductMapper;
import com.liangyuyan.animal.domain.Product;

import com.liangyuyan.animal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    public int insert(Product product) {
        int isSuccess = 0;
        isSuccess = productMapper.insert(product);
        return isSuccess;
    }
}
