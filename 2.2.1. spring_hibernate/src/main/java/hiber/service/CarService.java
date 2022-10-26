package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarService {

    List<Car> listCars();

    User getUserByNameSeries(String model, int series);

    User getUserByCar(Car car);
}
