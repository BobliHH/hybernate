package com.sda.hibernate.runner;

import com.sda.hibernate.Car;
import com.sda.hibernate.CarService;
import com.sda.hibernate.item.Item;
import com.sda.hibernate.item.ItemService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApplicationRunner {
    public static void main(String[] args) {
        CarService carService = new CarService();
        ItemService itemService = new ItemService();

        Item firstItem = new Item(1L,"Type_1");
//        Item secondItem = new Item(1L,"Type_2");
//        Item thirdItem = new Item(1L,"Type_3");
//        Item lastItem = new Item(1L,"Type_4");
//
        Set<Item> items = new HashSet<Item>();
        items.add(firstItem);
//        items.add(secondItem);
//        items.add(thirdItem);
//        items.add(lastItem);
//
//        Car firstCar = new Car(2l,"galben","berlina",items);
//        Car secondCar = new Car(2l,"verde","hatchback",items);
//        Car thirdCar = new Car(2l,"rosie","van",items);
//        Car lastCar = new Car(2l,"neagra","cabrio",items);
//
//        carService.saveCar(firstCar);
//        carService.saveCar(secondCar);
//        carService.saveCar(thirdCar);
//        carService.saveCar(lastCar);

//        List<Car> cars = carService.findAllCars();
//        for (Car car: cars){
//            System.out.println(car.getColor());
//        }

        Car car = carService.findCarByID(8L);
        car.setItems(null);
        carService.deleteCar(car);

//        Item item = itemService.findItemByID(8L);
//        itemService.deleteItem(item);


//        Car car = new Car(1L,"verde","hatchback");
//        Car car1 = new Car(1L,"negru","berlina");
//        Car car2 = new Car(1L,"gri","cabrio");
//        carService.saveCar(car);
//        carService.saveCar(car1);
//        carService.saveCar(car2);
//        List<Car> allCars = carService.findAllCars();
//        for (Car car :allCars){
//            System.out.println("Car id: "+ car.getId()+ ", color: "+car.getColor()+" "+car.getModel());
//        carService.deleteAllCars();
        }

    }

