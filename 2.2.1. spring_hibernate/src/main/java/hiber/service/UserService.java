package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void addUserWithCar(User user);
    User getCarOwner(int series, String model);
    List<User> getAllUsers();
}
