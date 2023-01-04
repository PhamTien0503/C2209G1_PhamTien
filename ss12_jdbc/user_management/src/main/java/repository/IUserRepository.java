package repository;

import model.User;

import java.util.List;

public interface IUserRepository {
    void addUser(User user);

    User selectUser(int id);

    List<User> selectAllUser();

    boolean deleteUser(int id);

    boolean updateUser(User user);

    List<User> searchByCountry(String country);

    List<User> sortByName();
}
