package com.liangyuyan.animal.dao;

import com.liangyuyan.animal.domain.Product;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    List<Product> selectAll();
    List<Product> selectByType(String type);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateById(Product record);
    int deleteById(int id);

}