import edu.duke.Point;

public class KivaMoveTest {
    // Define the FloorMap we'll use for all the tests
    String defaultLayout = ""
                           + "-------------\n"
                           + "        P   *\n"
                           + "   **       *\n"
                           + "   **       *\n"
                           + "  K       D *\n"
                           + " * * * * * **\n"
                           + "-------------\n";
    
    String motorLifetimeTest = ""
                               +"-----\n"
                               +"|K D|\n"
                               +"| P |\n"
                               +"|* *|\n"
                               +"-----\n";
    FloorMap defaultMap = new FloorMap(defaultLayout);
    FloorMap motorMap = new FloorMap(motorLifetimeTest);
    public void testForwardFromUp() {
        // GIVEN
        // A Kiva built with the default map we defined earlier
        Kiva kiva = new Kiva(defaultMap);
        //System.out.println(kiva.getCurrentLocation());
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.FORWARD);
        //System.out.println(kiva.getCurrentLocation());
        // THEN
        // The Kiva has moved one space up
        verifyKivaState("testForwardFromUp", 
            kiva, new Point(2, 3), FacingDirection.UP, false, false);
        System.out.println();
    }
    public void testForwardFromRight() {
        // GIVEN
        // A Kiva built with the default map we defined earlier
        Kiva kiva = new Kiva(defaultMap);

        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        
        // THEN
        // The Kiva has moved one space up
        verifyKivaState("testForwardFromRight", 
            kiva, new Point(3, 4), FacingDirection.RIGHT, false, false);
        System.out.println();
    }
    public void testForwardFromLeft() {
        // GIVEN
        // A Kiva built with the default map we defined earlier
        Kiva kiva = new Kiva(defaultMap);

        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        
        // THEN
        // The Kiva has moved one space up
        verifyKivaState("testForwardFromLeft", 
            kiva, new Point(1, 4), FacingDirection.LEFT, false, false);
        System.out.println();
    }
    public void testForwardFromDown() {
        // GIVEN
        // A Kiva built with the default map we defined earlier
        Kiva kiva = new Kiva(defaultMap);

        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        
        // THEN
        // The Kiva has moved one space up
        verifyKivaState("testForwardFromDown", 
            kiva, new Point(2, 5), FacingDirection.DOWN, false, false);
        System.out.println();
    }
    
    //test left
    public void testTurnLeftFromUp()
    {
        Kiva kiva = new Kiva(defaultMap);

        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_LEFT);
        //System.out.println(kiva.getDirectionFacing());
        // THEN
        // The Kiva has moved one space up
        verifyKivaState("testLeftFromUp", 
            kiva, new Point(2, 4), FacingDirection.LEFT, false, false);
        System.out.println();
    }
    public void testTurnLeftFromLeft()
    {
        Kiva kiva = new Kiva(defaultMap);

        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        // THEN
        // The Kiva has moved one space up
        verifyKivaState("testLeftFromLeft", 
            kiva, new Point(2, 4), FacingDirection.DOWN, false, false);
        System.out.println();
    }
    public void testTurnLeftFromDown()
    {
        Kiva kiva = new Kiva(defaultMap);

        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        // THEN
        // The Kiva has moved one space up
        verifyKivaState("testLeftFromDown", 
            kiva, new Point(2, 4), FacingDirection.RIGHT, false, false);
        System.out.println();
    }
    public void testTurnLeftFromRight()
    {
        Kiva kiva = new Kiva(defaultMap);

        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        // THEN
        // The Kiva has moved one space up
        verifyKivaState("testLeftFromRight", 
            kiva, new Point(2, 4), FacingDirection.UP, false, false);
        System.out.println();
    }
    
    //test right turn
    public void testTurnRightFromUp()
    {
        Kiva kiva = new Kiva(defaultMap);

        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_RIGHT);
        //System.out.println(kiva.getDirectionFacing());
        // THEN
        // The Kiva has moved one space up
        verifyKivaState("testRightFromUp", 
            kiva, new Point(2, 4), FacingDirection.RIGHT, false, false);
        System.out.println();
    }
    public void testTurnRightFromRight()
    {
        Kiva kiva = new Kiva(defaultMap);

        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.TURN_RIGHT);
        //System.out.println(kiva.getDirectionFacing());
        // THEN
        // The Kiva has moved one space up
        verifyKivaState("testRightFromRight", 
            kiva, new Point(2, 4), FacingDirection.DOWN, false, false);
        System.out.println();
    }
    public void testTurnRightFromDown()
    {
        Kiva kiva = new Kiva(defaultMap);

        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.TURN_RIGHT);
        //System.out.println(kiva.getDirectionFacing());
        // THEN
        // The Kiva has moved one space up
        verifyKivaState("testRightFromDown", 
            kiva, new Point(2, 4), FacingDirection.LEFT, false, false);
        System.out.println();
    }
    public void testTurnRightFromLeft()
    {
        Kiva kiva = new Kiva(defaultMap);

        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.TURN_RIGHT);
        //System.out.println(kiva.getDirectionFacing());
        // THEN
        // The Kiva has moved one space up
        verifyKivaState("testRightFromLeft", 
            kiva, new Point(2, 4), FacingDirection.UP, false, false);
        System.out.println();
    }
    
    //test take
    public void testTakeOnPod()
    {
        Kiva kiva = new Kiva(defaultMap);
        
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TAKE);
        //System.out.println(kiva.getCurrentLocation() + " should be " + defaultMap.getPodLocation());
        verifyKivaState("testTakeOnPod", 
            kiva, defaultMap.getPodLocation(), FacingDirection.RIGHT, true, false);
        System.out.println();
    }
    
    //test drop
    public void testDropOnDropZone()
    {
        Kiva kiva = new Kiva(defaultMap);
        
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TAKE);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.DROP);
        //System.out.println(kiva.getCurrentLocation);
        verifyKivaState("testDropOnDropZone", 
            kiva, defaultMap.getDropZoneLocation(), FacingDirection.DOWN, false, true);
        System.out.println();
    }
    
    public void getTakeAndDropZone()
    {
        System.out.println("pod-" + defaultMap.getPodLocation());
        System.out.println("DZ-" + defaultMap.getDropZoneLocation());
    }
    
    //test invalid moves
    public void testMoveOutOfBounds() {
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        System.out.println("testMoveOutOfBounds: (expect an IllegalMoveException)");
        kiva.move(KivaCommand.FORWARD);
        
        // This only runs if no exception was thrown
        System.out.println("testMoveOutOfBounds FAIL!");
        System.out.println("Moved outside the FloorMap!");
    }
    public void testObstacle()
    {
        Kiva kiva = new Kiva(defaultMap); 
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
         System.out.println("testObstacle: (expect an IllegalMoveException)");
        kiva.move(KivaCommand.FORWARD);
        
        // This only runs if no exception was thrown
        System.out.println("testObstacle FAIL!");
        System.out.println("Moved into obstacle!");
    }
    public void testTakeNoPod()
    {
        Kiva kiva = new Kiva(defaultMap); 
        System.out.println("testTakeNoPod: (expect an noPodException)");
        kiva.move(KivaCommand.TAKE);
        
        // This only runs if no exception was thrown
        System.out.println("testTakeNoPod FAIL!");
        System.out.println("Took a pod from empty space!");
    }
    public void testDropOnNoZone()
    {
        Kiva kiva = new Kiva(defaultMap);
        
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TAKE);
        System.out.println("testDropOnNoZone: (expect an IllegalDropZone)");
        kiva.move(KivaCommand.DROP);
        
        // This only runs if no exception was thrown
        System.out.println("testDropOnNoZone FAIL!");
        System.out.println("Dropped a pod on empty space!");
    }
    public void testDropMissingPod()
    {
        Kiva kiva = new Kiva(defaultMap);
        
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        //kiva.move(KivaCommand.TAKE);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        System.out.println("testDropMissingPod: (expect an IllegalMoveException)");
        kiva.move(KivaCommand.DROP);
        
        // This only runs if no exception was thrown
        System.out.println("testDropMissingPod FAIL!");
        System.out.println("Dropped no pod at dropzone");
    }
    
    //testing motorlifetime
    public void KivaMotorLifetimeTester()
    {
        Kiva kiva = new Kiva(motorMap);
        //long motorlife = kiva.getMotorLifetime();
        
        kiva.move(KivaCommand.TURN_RIGHT);
        System.out.println(kiva.getMotorLifetime());
        
        kiva.move(KivaCommand.FORWARD);
        System.out.println(kiva.getMotorLifetime());
        
        kiva.move(KivaCommand.TURN_RIGHT);
        System.out.println(kiva.getMotorLifetime());
        
        kiva.move(KivaCommand.FORWARD);
        System.out.println(kiva.getMotorLifetime());
        
        kiva.move(KivaCommand.TAKE);
        System.out.println(kiva.getMotorLifetime());
    }
    
    // For you: create all the other tests and call verifyKivaState() for each

    private boolean sameLocation(Point a, Point b) {
        return a.getX() == b.getX() && a.getY() == b.getY();
    }

    private void verifyKivaState(
            String testName,
            Kiva actual,
            Point expectLocation,
            FacingDirection expectDirection,
            boolean expectCarry,
            boolean expectDropped) {

        Point actualLocation = actual.getCurrentLocation();
        if (sameLocation(actualLocation, expectLocation)) {
            System.out.println(
                    String.format("%s: current location SUCCESS", testName));
        }
        else {
            System.out.println(
                    String.format("%s: current location FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s",
                            expectLocation, actualLocation));
        }

        FacingDirection actualDirection = actual.getDirectionFacing();
        if (actualDirection == expectDirection) {
            System.out.println(
                    String.format("%s: facing direction SUCCESS", testName));
        }
        else {
            System.out.println(
                    String.format("%s: facing direction FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s",
                            expectDirection, actualDirection));
        }

        boolean actualCarry = actual.isCarryingPod();
        if (actualCarry == expectCarry) {
            System.out.println(
                    String.format("%s: carrying pod SUCCESS", testName));
        }
        else {
            System.out.println(
                    String.format("%s: carrying pod FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s",
                            expectCarry, actualCarry));
        }

        boolean actualDropped = actual.isSuccessfullyDropped();
        if (actualDropped == expectDropped) {
            System.out.println(
                    String.format("%s: successfully dropped SUCCESS", testName));
        }
        else {
            System.out.println(
                    String.format("%s: successfully dropped FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s",
                            expectDropped, actualDropped));
        }
    }
}
