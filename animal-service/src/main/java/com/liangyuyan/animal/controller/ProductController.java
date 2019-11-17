package com.liangyuyan.animal.controller;

import com.liangyuyan.animal.domain.Product;
import com.liangyuyan.animal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/product/insert")
    public String insert(@RequestBody Product product){
        int isSuccess=productService.insert(product);
        return String.valueOf(isSuccess);
    }

    @RequestMapping("/product/selectAll")
    public List<Product> selectAll(){
        List<Product> productList=productService.selectAll();
        return productList;
    }
    @RequestMapping("/product/selectByType")
    public List<Product> selectByType(@RequestParam String type) {
        List<Product> productList = productService.selectByType(type);
        return productList;
    }

    @RequestMapping("/product/deleteById")
    public int deleteById(@RequestParam int id){
        int isSuccess=productService.deleteById(id);
        return isSuccess;
    }
    @RequestMapping("/product/updateById")
    public int updateById(@RequestBody Product product){
        int isSuccess=productService.updateById(product);
        return isSuccess;
    }
}
