package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarDao {

    public List<Car> getCarList();

    User getUserByNameSeries(String model, int series);

    public User getUserByCarS(Car car);
}
