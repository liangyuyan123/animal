package com.liangyuyan.animal.service;

import com.liangyuyan.animal.domain.Product;

import java.util.List;

public interface ProductService {
    public int insert(Product product);

    public List<Product> selectAll();
    public List<Product> selectByType(String type);
    public int deleteById(int id);
    public int updateById(Product product);
}
