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

      userService.add(new User("Masha", "Popova", "user1@mail.ru", new Car(123456, "Audi")));
      userService.add(new User("Pasha", "Petrov", "user2@mail.ru", new Car(654321, "BMW")));

//      userService.add(new User("Semen", "Nemoshniy", "user5@mail.ru"));
//      userService.add(new User("Vasiliy", "Kulikov", "user6@mail.ru"));
//      userService.add(new User("Maxim", "Tereshenko", "user7@mail.ru"));
//      userService.add(new User("Sergey", "Sherman", "user8@mail.ru"));

      userService.add(new User("Ivan", "Sidorov", "user3@mail.ru", new Car(321456, "Nissan")));
      userService.add(new User("Petr", "Reshalkin", "user4@mail.ru", new Car(432567, "Toyota")));




      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car: ");
         System.out.println("model = "+user.getCar().getModel());
         System.out.println("model = "+user.getCar().getSeries());
      }

      System.out.println("--------TEST--getUserWithCar---------");

      System.out.println(userService.getUserWithCar(123456, "Audi"));
      System.out.println(userService.getUserWithCar(654321, "BMW"));
      System.out.println(userService.getUserWithCar(321456, "Nissan"));
      System.out.println(userService.getUserWithCar(432567, "Toyota"));


      context.close();
   }
}
