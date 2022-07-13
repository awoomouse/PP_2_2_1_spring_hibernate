package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void addUserWithCar(User user);
   User getCarOwner(int series, String model);
   List<User> getAllUsers();
}
