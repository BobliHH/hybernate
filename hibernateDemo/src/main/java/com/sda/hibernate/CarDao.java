package com.sda.hibernate;

import java.util.List;

public interface CarDao {
    public void saveCar(Car car);
    public List<Car> findAllCars();
    public Car findCarByID(Long carID);
    public void updateCar(Car car);
    public void deleteCar(Car car);
    public void deleteAllCars();
}
