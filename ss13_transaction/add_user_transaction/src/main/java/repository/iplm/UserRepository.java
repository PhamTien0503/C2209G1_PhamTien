package repository.iplm;

import model.User;
import repository.BaseRepository;
import repository.IUserRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String INSERT_USERS_SQL = "insert into users (name, email, country) values (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";

    private static final String SELECT_USER_BY_COUNTRY = "select id,name,email,country from users where country =?";
    private static final String SELECT_ALL_USERS = "call select_all_user();";
    private static final String DELETE_USERS_SQL = "call delete_user(?);";
    private static final String UPDATE_USERS_SQL = "call update_user_by_id(?,?,?,?);";
    private static final String SELECT_USERS_SORTED_BY_NAME = " select * from users order by name;";

    @Override
    public List<User> selectAllUser() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_USERS);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public String addUserTransaction(User user) {
        String mess="";
        Connection connection = BaseRepository.getConnectDB();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            int rowAdd=preparedStatement.executeUpdate();
            if (rowAdd>0){
                connection.commit();
                mess="Add transaction success!!!!";
            }else {
                connection.rollback();
                mess="Add transaction failed";
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mess;
    }

    @Override
    public User selectUser(int id) {
        Connection connection = BaseRepository.getConnectDB();
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public boolean deleteUser(int id) {
        Connection connection = BaseRepository.getConnectDB();
        int rowDelete = 0;
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_USERS_SQL);
            callableStatement.setInt(1, id);
            rowDelete = callableStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDelete > 0;
    }

    @Override
    public boolean updateUser(User user) {
        int rowUpdate = 0;
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(UPDATE_USERS_SQL);
            callableStatement.setInt(1, user.getId());
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getCountry());
            rowUpdate = callableStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdate > 0;
    }

    @Override
    public List<User> searchByCountry(String country) {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_COUNTRY);
            preparedStatement.setString(1, country);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                user = new User(id, name, email, country);
                userList.add(user);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public List<User> sortByName() {
        List<User> userList = new ArrayList<>();
        User user = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_SORTED_BY_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
}
