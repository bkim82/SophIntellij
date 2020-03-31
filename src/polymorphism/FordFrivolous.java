package polymorphism;

public class FordFrivolous extends GasPoweredCar implements SelfDriving, Flying {

    public FordFrivolous (double startingMileage) {
        super("Ford", "Frivolous", startingMileage, 23.6, 20);
    }

    public FordFrivolous () {
        this(0);
    }

    public void driveAutonomously(double miles) {

        if (!canDrive(miles*2)) {
            super.drive(getRemainingRange()/2.0);
        }
        else {
            super.drive(miles);
        }
        decreaseFuelLevel(miles); // 2x
    }

    public boolean canFly(double miles) {
        return canDrive(miles*3);
    }

    public void fly(double miles) {
        if (!canFly(miles)) {
            throw new IllegalArgumentException("Miles is negative.");
        }
        decreaseFuelLevel(miles*3);
    }
}
