package polymorphism.tests;

import polymorphism.FordFrivolous;

public class FordFrivolous_Flying extends BCATestScenario {

    public int runTest() {

        FordFrivolous a1 = new FordFrivolous(472);

        assertThrows(IllegalArgumentException.class,() -> {a1.drive(-1);},
                "Driving mileage cannot be negative");

        a1.fly(25);
        assertEquals(a1.getMileage(), 0, .1, "Mileage should be 0.");
        assertEquals(a1.getRemainingRange(), 397,.1, "Should be 397");

        assertTrue(a1.canFly(397), "Driving 397 should succeed");
        assertFalse(a1.canFly(397), "Driving 398 should fail");

        return getFailedCount();
    }
}