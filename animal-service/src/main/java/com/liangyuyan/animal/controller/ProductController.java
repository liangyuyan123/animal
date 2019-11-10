package com.liangyuyan.animal.controller;

import com.liangyuyan.animal.domain.Product;
import com.liangyuyan.animal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
