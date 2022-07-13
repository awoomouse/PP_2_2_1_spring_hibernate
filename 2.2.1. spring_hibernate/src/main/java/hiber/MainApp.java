package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.addUserWithCar(new User("Masha", "Popova", "user1@mail.ru", new Car(123456, "Audi")));
      userService.addUserWithCar(new User("Pasha", "Petrov", "user2@mail.ru", new Car(654321, "BMW")));
      userService.addUserWithCar(new User("Ivan", "Sidorov", "user3@mail.ru", new Car(321456, "Nissan")));
      userService.addUserWithCar(new User("Petr", "Reshalkin", "user4@mail.ru", new Car(432567, "Toyota")));

      User user1 = null;       //поля для теста equals and hashCode
      User user2 = null;
      User user3 = null;
      User user4 = null;
      List<User> users = userService.getAllUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car: ");
         System.out.println("model = "+user.getCar().getModel());
         System.out.println("series = "+user.getCar().getSeries());
         //для теста equals and hashCode
         if (user.getId() == 1) {
            user1 = user;
         }
         if (user.getId() == 2) {
            user2 = user;
         }
         if (user.getId() == 3) {
            user3 = user;
         }
         if (user.getId() == 4) {
            user4 = user;
         }
      }

      System.out.println("--------TEST--getCarOwner---------");

      System.out.println(userService.getCarOwner(123456, "Audi"));
      System.out.println(userService.getCarOwner(654321, "BMW"));
      System.out.println(userService.getCarOwner(321456, "Nissan"));
      System.out.println(userService.getCarOwner(432567, "Toyota"));

      System.out.println("-----------TEST--equals--hashCode---------------");

      System.out.println(user1.equals(user1));                    //result = true
      System.out.println(user1.equals(user2));                    //result = false
      System.out.println(user3.hashCode());                       //hashCode
      System.out.println(user4.hashCode());                       //hashCode
      System.out.println(user3.hashCode() == user3.hashCode());   //result = true
      System.out.println(user3.hashCode() == user4.hashCode());   //result false

      context.close();
   }
}
