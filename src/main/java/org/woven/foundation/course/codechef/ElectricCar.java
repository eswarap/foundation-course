package org.woven.foundation.course.codechef;

public class ElectricCar extends Car {
    ElectricCar() {
        System.out.println("ElectricCar constructor");
    }

    void start() {
        System.out.println("ElectricCar started");
    }

    public static void main(String[] args) {
        ElectricCar car = new ElectricCar();
        car.start();
    }
}
