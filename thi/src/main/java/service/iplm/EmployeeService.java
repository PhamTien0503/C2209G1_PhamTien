package service.iplm;

import model.Employee;
import repository.IEmployeeRepository;
import repository.iplm.EmployeeRepository;
import service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository=new EmployeeRepository();
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public boolean save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public boolean edit(Employee employee) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return employeeRepository.delete(id);
    }

    @Override
    public List<Employee> search(String name, String positionId) {
        return employeeRepository.search(name,positionId);
    }
}
