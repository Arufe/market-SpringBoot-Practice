package com.market.martinmarket.domain.service;

import com.market.martinmarket.domain.Product;
import com.market.martinmarket.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product>getAll(){
        return productRepository.getAll();
    }

    public Optional<Product>getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>>getScarseProducts(int quantity){
        return productRepository.getScarseProducts(quantity);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete (int productId){
        if(getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        }else{
            return false;
        }
        /*
        La de abajo es mejor
         */
       /* return getProduct(productId).map(product ->{
            productRepository.delete(productId);
            return true;
        }).orElse(false);

        */
    }
}
