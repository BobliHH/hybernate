package com.sda.hibernate;

import java.util.List;

public class CarService {
    CarDaoImpl carDao;

    public CarService() {
        this.carDao = new CarDaoImpl();
    }

    public void saveCar(Car car) {
        carDao.openCurrentSessionWithTransaction();
        carDao.saveCar(car);
        carDao.closeCurrentSessionWithTransaction();
    }

    public List<Car> findAllCars() {
        carDao.openCurrentSession();
        List<Car> cars = carDao.findAllCars();
        carDao.closeCurrentSession();
        return cars;

    }

    public Car findCarByID(Long carID) {
        carDao.openCurrentSession();
        Car car = carDao.findCarByID(carID);
        carDao.closeCurrentSession();
        return car;

    }

    public void updateCar(Car car) {
        carDao.openCurrentSessionWithTransaction();
        carDao.updateCar(car);
        carDao.closeCurrentSessionWithTransaction();
    }

    public void deleteCar(Car car) {
        carDao.openCurrentSessionWithTransaction();
        carDao.deleteCar(car);
        carDao.closeCurrentSessionWithTransaction();
    }

    public void deleteAllCars() {
        carDao.openCurrentSessionWithTransaction();
        carDao.deleteAllCars();
        carDao.closeCurrentSessionWithTransaction();

    }
}
