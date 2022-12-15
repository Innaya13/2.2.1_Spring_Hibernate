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

      userService.add(new User("Valera", "Bogatyr", "valera@mail.ru",new Car("BTR", 1)));
      userService.add(new User("Oleg", "Sokol", "oleg@mail.ru",new Car("TANK", 2)));
      userService.add(new User("Bat", "Man", "batman@mail.ru",new Car("BATMOBILE", 3)));
      userService.add(new User("Valentina", "Koroleva", "valya@mail.ru",new Car("TRACTOR", 4)));

      //      Car car1=new Car("BTR",1);
      //      Car car2=new Car("TANK",2);
      //      Car car3=new Car("BATMOBILE",3);
      //      Car car4=new Car("TRACTOR",4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println(user.getCar());
      }
      System.out.println(userService.userCar("TANK", 2));
      context.close();
   }
}
