package com.example.Product_practice.Services;

import com.example.Product_practice.Data.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class Product_Service {

    List<Product> products = new ArrayList<>( Arrays.asList(
            new Product(101,"Ac",10000),
            new Product(102,"bat",500),
            new Product(103,"ball",100)
    ));

    public List<Product> getproducts(){
        return products;
    }


    public Product getById(int id){

        try {
            return products.stream().filter(x->x.getId()==id).findFirst().get();
        }
        catch (NoSuchElementException e){
            return new Product(0,null,0);
        }

    }

    public void addProduct(Product prod){
        products.add(prod);
    }

    public void updateProduct(Product prod){
        int index = -1;
        for(int i = 0;i<products.size();i++){
            if(products.get(i).getId()==prod.getId()){
                index = i;
                break;
            }
        }
        products.set(index,prod);
    }

    public void DeleteProduct(Product prod){
        int index = -1;
        for(int i = 0;i<products.size();i++){
            if(products.get(i).getId()==prod.getId()){
                index = i;
                break;
            }
        }
        products.remove(index);
    }
}
