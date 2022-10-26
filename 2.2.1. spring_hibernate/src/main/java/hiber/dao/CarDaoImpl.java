package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private final String hql = "from User user where user.car.model = :model and user.car.series = :series";


    private final SessionFactory sessionFactory;

    @Autowired
    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getCarList() {
        List<Car> carList = sessionFactory.getCurrentSession().createQuery("from Car ").getResultList();
        return carList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUserByNameSeries(String model, int series) {
        try {
            TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
            query.setParameter("model", model).setParameter("series", series);
            return query.setMaxResults(1).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("User with model car " + model + "and series car" + series + " not found");
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUserByCarS(Car car) {
        try {
            TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
            query.setParameter("model", car.getModel()).setParameter("series", car.getSeries());
            return query.setMaxResults(1).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("User with car " + car + " not found");
        }
        return null;
    }
}
