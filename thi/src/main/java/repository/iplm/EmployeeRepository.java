package repository.iplm;

import model.Employee;
import repository.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String FIND_ALL="select * from employee;";
    private static final String SEARCH=" select * from employee where name like ? and position_id like ?";
    private static final String DELETE_EMPLOYEE="  delete from employee where id=?";
    private  static final String UPDATE="update employee set name=?,date_of_birth=?,id_card=?,salary=?," +
            "phone_number=?,email=?,address=?,position_id=?,education_degree_id=?,division_id=? where id=?";
    private static final String INSERT="insert into employee (name,date_of_birth,id_card,salary,phone_number,\n" +
            "email,address,position_id,education_degree_id,division_id)\n" +
            "values (?,?,?,?,?,?,?,?,?,?);";
    @Override
    public List<Employee> findAll() {
        Connection connection=BaseRepository.getConnectDB();
        List<Employee> employeeList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_ALL);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                 int id=resultSet.getInt("id");
                 String name=resultSet.getString("name");
                String dateOfBirth=resultSet.getString("date_of_birth");
                 String idCard=resultSet.getString("id_card");
                 double salary= resultSet.getDouble("salary");
                 String phoneNumber= resultSet.getString("phone_number");
                 String email= resultSet.getString("email");
                 String address= resultSet.getString("address");
                 int positionId= resultSet.getInt("position_id");
                 int educationDegreeId=resultSet.getInt("education_degree_id");
                 int divisionId=resultSet.getInt("division_id");
                 Employee employee=new Employee(id,name,idCard,dateOfBirth,salary,phoneNumber,email,address,positionId,educationDegreeId,divisionId);
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
    public boolean save(Employee employee) {
        Connection connection=BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT);
 // name,date_of_birth,id_card,salary,phone_number,\n" +
            //            "email,address,position_id,education_degree_id,division_id
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getDateOfBirth());
            preparedStatement.setString(3,employee.getIdCard());
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setString(5,employee.getPhoneNumber());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8,employee.getPositionId());
            preparedStatement.setInt(9,employee.getEducationDegreeId());
            preparedStatement.setInt(10,employee.getDivisionId());
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

    @Override
    public boolean delete(int id) {
        Connection connection=BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Employee> search(String name,String positionId) {
        Connection connection=BaseRepository.getConnectDB();
        List<Employee> employeeList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(SEARCH);
            preparedStatement.setString(1,"%"+name+"%");
            preparedStatement.setString(2,"%"+positionId+"%");
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                name=resultSet.getString("name");
                String dateOfBirth=resultSet.getString("date_of_birth");
                String idCard=resultSet.getString("id_card");
                double salary= resultSet.getDouble("salary");
                String phoneNumber= resultSet.getString("phone_number");
                String email= resultSet.getString("email");
                String address= resultSet.getString("address");
                int Id= resultSet.getInt("position_id");
                int educationDegreeId=resultSet.getInt("education_degree_id");
                int divisionId=resultSet.getInt("division_id");
                Employee employee=new Employee(id,name,idCard,dateOfBirth,salary,phoneNumber,email,address,Id,educationDegreeId,divisionId);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}