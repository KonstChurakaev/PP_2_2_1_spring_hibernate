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

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");

        Car car1 = new Car("car1", 11);
        Car car2 = new Car("car2", 12);
        Car car3 = new Car("car3", 13);
        Car car4 = new Car("car4", 14);

        userService.addUser(user1.setCar(car1).setUser(user1));
        userService.addUser(user2.setCar(car2).setUser(user2));
        userService.addUser(user3.setCar(car3).setUser(user3));
        userService.addUser(user4.setCar(car4).setUser(user4));

        List<User> users = userService.getListUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("car = " + user.getCar());
            System.out.println();
        }

        // user by car
        System.out.println(carService.getUserByCar(car1));

        //user by model and series car
        System.out.println(carService.getUserByNameSeries("car1", 11));

        context.close();
    }
}
