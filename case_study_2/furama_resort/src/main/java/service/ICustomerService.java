package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    boolean save(Customer customer);
    boolean edit(Customer customer);
    boolean delete(int id);
    Customer search(int id,String name);
}
