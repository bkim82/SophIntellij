package polymorphism;

public class HondaAccordian extends GasPoweredCar{

    private int modelYear;

    public HondaAccordian (double startingMileage, int modelYear) {
        super ("Honda", "Accordian", startingMileage, 33.2, 14.5);
        this.modelYear = modelYear;
    }

    public HondaAccordian(int year) {
        this(0, year);
    }

    public String toString() {
        return this.modelYear + super.toString();
    }

}
