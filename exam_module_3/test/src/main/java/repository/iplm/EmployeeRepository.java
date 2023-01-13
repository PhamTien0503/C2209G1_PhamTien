package repository.iplm;

import model.Employee;
import repository.IEmployeeRepository;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String FIND_ALL="select * from employee;";
    private static final String DELETE="delete from employee where id =?;";
    private static final String SEARCH=" select * from employee where name like ? and position_id like ?";
    private static final String CREATE=" insert into employee (name,date_of_birth,gender,position_id)\n" +
            "values(?,?,?,?)";
    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList=new ArrayList<>();
        Connection connection=BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_ALL);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                 String dateOfBirth=resultSet.getString("date_of_birth");
                 boolean gender=resultSet.getBoolean("gender");
                 int positionId=resultSet.getInt("position_id");
                 Employee employee=new Employee(id,name,dateOfBirth,gender,positionId);
                 employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }


    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        Connection connection=BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Employee> search(String name, String positionId) {
        Connection connection = BaseRepository.getConnectDB();
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, "%" + positionId + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                boolean gender = resultSet.getBoolean("gender");
                int Id = resultSet.getInt("position_id");
                Employee employee = new Employee(id, name, dateOfBirth,gender, Id );
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }


    @Override
    public boolean save(Employee employee) {
        Connection connection=BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(CREATE);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2, employee.getDateOfBirth());
            preparedStatement.setBoolean(3,employee.isGender());
            preparedStatement.setInt(4,employee.getPositionId());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean edit(Employee employee) {
        return false;
    }
}
