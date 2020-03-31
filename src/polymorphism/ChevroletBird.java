package polymorphism;

class ChevroletBird extends ElectricCar implements Flying {

    private boolean retracted;


    public ChevroletBird (double startingMileage) {
        super("Chevrolet", "Bird", startingMileage, 250);
    }

    public ChevroletBird () {
        this(0);
    }

    public boolean checkWingsExtended() {
        return this.retracted;
    }

    public void drive(double miles) {
        this.retracted = false;
        super.drive(miles);
    }

    public boolean canFly(double miles) {
        return canDrive(miles);
    }

    public void fly(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException("Miles is negative");
        }

        if (!canFly(miles)) {
            throw new IllegalArgumentException("Can not drive.");
        }
        this.retracted = true;
        decreaseCharge(miles);
    }

}
