package service.iplm;

import model.User;
import repository.IUserRepository;
import repository.iplm.UserRepository;
import service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private final IUserRepository userRepository=new UserRepository();

    @Override
    public List<User> selectAllUser() {
        return userRepository.selectAllUser();
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);

    }

    @Override
    public User selectUser(int id) {
        return userRepository.selectUser(id);
    }

    @Override
    public boolean deleteUser(int id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public User searchByCountry(String country) {
        return null;
    }

    @Override
    public List<User> sortByName() {
        return null;
    }
}
