package repository;

import model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();
    Employee findById(int id);
    boolean save(Employee employee);
    boolean edit(Employee employee);
    boolean delete(int id);
    List<Employee> search (String name,String positionId);
}
