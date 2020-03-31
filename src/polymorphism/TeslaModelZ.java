package polymorphism;

class TeslaModelZ extends ElectricCar implements SelfDriving {
    private int modelNum;

    public TeslaModelZ(double startingMileage, int modelNum) {
        super("Tesla" , "Model Z", startingMileage, 340);
        this.modelNum = modelNum;
    }

    public TeslaModelZ(int modelNum) {
        this(0,modelNum);
    }

    public int getModelNum() {
        return this.modelNum;
    }

    public void driveAutonomously(double miles) {
        if (!canDrive(miles)) {
            super.drive(getRemainingRange());
        }
        else {
            super.drive(miles);
        }
    }
}
