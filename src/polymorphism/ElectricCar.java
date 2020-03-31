package polymorphism;

abstract class ElectricCar extends Car {

    private double milesOnMaxCharge;
    private double charge = 100;

    public ElectricCar(String make, String model, double startingMileage, double milesOnMaxCharge) {
        super(make, model, startingMileage);

        if (milesOnMaxCharge < 0) {
            throw new IllegalArgumentException("Miles on maximum charge can not be negative");
        }
        this.milesOnMaxCharge = milesOnMaxCharge;
    }

    public ElectricCar (String make, String model, double milesOnMaxCharge) {
        this(make, model, 0,milesOnMaxCharge);
    }

    public void drive(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException("Negative Miles");
        }
        if (!canDrive(miles)) {
            throw new IllegalArgumentException("miles is too high given the current charge");
        }
        decreaseCharge(miles);
        addMileage(miles);
    }

    public double getRemainingRange () {
        return this.charge * this.milesOnMaxCharge/100;
    }
    public double getMaxRange() {
        return this.milesOnMaxCharge;
    }

    public void recharge() {
        this.charge = 100;
    }

    protected void decreaseCharge(double miles) {

        double charge = miles/(this.milesOnMaxCharge/100);
        this.charge -= charge;
    }


}
