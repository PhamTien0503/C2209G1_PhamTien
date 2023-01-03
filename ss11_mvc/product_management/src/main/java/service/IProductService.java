package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    boolean save(Product product);

    void update(int id, Product product);

    void remove(int id);

    Product findById(int id);

    Product findByName(String name);
}
