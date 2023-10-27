package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);


      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User user1 = new User("Vasiliy", "Popov", "VasPop@mail.tu");
      User user2 = new User("Makar", "Tarasov", "Makar777@mail.ru");
      User user3 = new User("Ignat", "Ivanov", "Ignat1990@mail.ru");

      Car car1 = new Car(user1,"KIA RIO", 700);
      Car car2 = new Car(user2, "Skoda Karoq", 500);
      Car car3 = new Car(user3, "Toyota Camry", 900);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);

      carService.add(car1);
      carService.add(car2);
      carService.add(car3);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      System.out.println(userService.getUserByCar("KIA RIO", 700));
      context.close();
   }
}
