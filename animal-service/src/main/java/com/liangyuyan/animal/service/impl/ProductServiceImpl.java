package com.liangyuyan.animal.service.impl;

import com.liangyuyan.animal.dao.ProductMapper;
import com.liangyuyan.animal.domain.Product;

import com.liangyuyan.animal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    public int insert(Product product) {
        int isSuccess = 0;
        isSuccess = productMapper.insert(product);
        return isSuccess;
    }

    @Override
    public List<Product> selectAll() {
        List<Product> productList=productMapper.selectAll();

        return productList;
    }

    @Override
    public List<Product> selectByType(String type) {
        List<Product> productList=productMapper.selectByType(type);

        return productList;

    }

    @Override
    public int deleteById(int id) {
        int isSuccess=0;
        isSuccess=productMapper.deleteById(id);
        return isSuccess;
    }

    @Override
    public int updateById(Product product) {
        int isSuccess=0;
        isSuccess=productMapper.updateById(product);
        return isSuccess;
    }
}
