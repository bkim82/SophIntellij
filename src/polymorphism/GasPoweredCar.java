package polymorphism;

abstract class GasPoweredCar extends Car {

    private double mpg;
    private double fuelCapacityGallons;
    private double tank;

    public GasPoweredCar(String make, String model,
                         double startingMileage, double mpg, double fuelCapacityGallons) {

        super(make, model, startingMileage);
        if (mpg < 0 || fuelCapacityGallons < 0) {
            throw new IllegalArgumentException();
        }
        this.mpg = mpg;
        this.fuelCapacityGallons = fuelCapacityGallons;
        this.tank = fuelCapacityGallons;

    }

    public GasPoweredCar (String make, String model, double mpg, double fuelCapacityGallons) {
        this(make, model, 0, mpg, fuelCapacityGallons);
    }

    public void drive(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException("Negative miles");
        }
        if (!canDrive(miles)) {
            throw new IllegalArgumentException("Can not drive");
        }
        decreaseFuelLevel(miles);
        addMileage(miles);
    }

    public double getMPG() {
        return this.mpg;
    }

    public double getFuelLevel() {
        return this.tank;
    }

    public double getFuelCapacity() {
        return this.fuelCapacityGallons;
    }

    public void refillTank() {
        this.tank = this.fuelCapacityGallons;
    }

    public double getRemainingRange() {
        return this.tank * mpg;
    }

    public void refillTank(double gallons) {
        if (gallons < 0) {
            throw new IllegalArgumentException("Negative feul");
        }

        if (this.tank + gallons > fuelCapacityGallons) {
            throw new IllegalArgumentException("Too much fuel for tank");
        }
        this.tank += gallons;
    }

    protected void decreaseFuelLevel(double miles) {
        double used = miles /mpg;
        this.tank -= used;
    }

}