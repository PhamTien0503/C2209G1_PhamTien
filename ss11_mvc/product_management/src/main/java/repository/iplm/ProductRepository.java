package repository.iplm;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Exciter Vip", 40000000, "Fast", "Yamaha"));
        productList.add(new Product(2, "Sirius", 12000000, "Slow", "Yamaha"));
        productList.add(new Product(3, "Air-black", 45000000, "Slow", "Honda"));
        productList.add(new Product(4, "Air-black", 45000000, "Slow", "Honda"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public boolean save(Product product) {
        return productList.add(product);
    }

    @Override
    public void update(int id, Product product) {
    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        productList.remove(product);
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        for (Product pr : productList) {
            if (pr.getId() == id) {
                product = pr;
            }
        }
        return product;
    }

    @Override
    public Product findByName(String name) {
        Product product = null;
        for (Product pr : productList) {
            if (pr.getName().contains(name)) {
                product = pr;
            }
        }
        return product;
    }
}
