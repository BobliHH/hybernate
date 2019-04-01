package com.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CarDaoImpl implements CarDao {

    private Session currentSession;
    private Transaction currentTransaction;

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());

        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public CarDaoImpl() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void saveCar(Car car) {
        getCurrentSession().save(car);

    }

    public List<Car> findAllCars() {
        List<Car> cars = (List<Car>) getCurrentSession().createQuery("from Car").list();
        return cars;
    }

    public Car findCarByID(Long carID) {
        Car car = (Car) getCurrentSession().get(Car.class, carID);
        return car;
    }

    public void updateCar(Car car) {
        getCurrentSession().update(car);

    }

    public void deleteCar(Car car) {
        getCurrentSession().delete(car);

    }

    public void deleteAllCars() {
        List<Car> cars = findAllCars();
        for (Car car : cars){
            deleteCar(car);
        }

    }
}
