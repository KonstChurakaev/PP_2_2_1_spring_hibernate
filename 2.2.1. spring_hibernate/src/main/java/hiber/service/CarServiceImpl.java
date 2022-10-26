package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {


    private final CarDao carDao;

    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> getCarList() {
        return carDao.getCarList();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByNameSeries(String model, int series) {
        return carDao.getUserByNameSeries(model, series);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByCar(Car car) {
        return carDao.getUserByCarS(car);
    }
}
