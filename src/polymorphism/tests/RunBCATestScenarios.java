package polymorphism.tests;


public class RunBCATestScenarios {
    public static void main(String[] args) {
        System.out.println("Running car tests.");

        //
        // Add all of your test scenario classes to this array.
        // No other changes are needed in this file.
        //
        BCATestScenario[] testList = {
                new TestHondaAccordian1_Constructors(),
                new TestHondaAccordian2_Driving(),
        };

        for (int i=0; i < testList.length; i++) {
            try {
                System.out.println();
                int failCount = testList[i].runTest();

                if (failCount == 0) {
                    System.out.println(testList[i].getClass().getSimpleName() + " passed.");
                }
                else {
                    System.out.println(testList[i].getClass().getSimpleName() + " failed " + failCount + " cases.");
                }
            }
            catch (Throwable t) {
                System.out.println(testList[i].getClass().getSimpleName() + " failed with an unexpected exception.");
                t.printStackTrace(System.out);
            }

        }

        System.out.println("\nTests completed.");
    }
}
