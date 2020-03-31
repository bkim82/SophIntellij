package polymorphism;

import java.util.List;

abstract class Car {
    private String make;
    private String model;
    private double odometer;

    public Car(String make, String model, double startingMileage) {

        if (startingMileage <0) {
            throw new IllegalArgumentException("Mileage can not be negative");
        }
        this.make = make;
        this.model = model;
        this.odometer = startingMileage;
    }

    public Car (String make, String model) {
        this.odometer = 0;
        this.make = make;
        this.model = model;
    }

    public boolean canDrive(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException("Can not drive negative miles");
        }

        return getRemainingRange() > miles;
    }

    public abstract void drive (double miles);

    public String toString() {
        return make + " " + model + " (" + odometer + " + mi)";
    }

    public double getMileage() {
        return this.odometer;

    }

    public abstract double getRemainingRange();

    protected void addMileage (double miles) {
        if(miles<0){
            throw new IllegalArgumentException("Miles is less than 0");
        }
        this.odometer += miles;
    }

    public int roadTrip (List<Double> milesEachDay) {
        int days = 0;
        for (int i = 0; i < milesEachDay.size(); i++) {
            if (milesEachDay.get(i) < 0) {
                throw new IllegalArgumentException("Miles is less than 0");
            }
            if (canDrive(milesEachDay.get(i))) {
                days++;
                drive(milesEachDay.get(i));
            } else {
                break;
            }
        }
        return days;

    }


}
