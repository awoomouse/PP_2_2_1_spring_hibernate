package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private UserDao userDao;

   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void addUserWithCar(User user) {
      userDao.addUserWithCar(user);
   }

   @Override
   public User getCarOwner(int series, String model) {
      return userDao.getCarOwner(series, model);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> getAllUsers() {
      return userDao.getAllUsers();
   }

}
