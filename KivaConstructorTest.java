
    import edu.duke.Point; 

public class KivaConstructorTest { 
    String defaultLayout = "" 
                            + "-------------\n" 
                            + "        P   *\n"
                            + "   **       *\n"
                            + "   **       *\n"
                            + "  K       D *\n"
                            + " * * * * * **\n"
                            + "-------------\n";

    FloorMap defaultMap = new FloorMap(defaultLayout);

    public void testSingleArgumentConstructor() { 
        // GIVEN 
        // The default map we defined earlier 

        // WHEN 
        // We create a Kiva with the single-argument constructor         
        Kiva kiva = new Kiva(defaultMap); 

        // THEN 
        // The initial Kiva location is (2, 4) 
        Point initialLocation = kiva.getCurrentLocation();
        
        Point expectedLocation = new Point(2, 4);
        if( initialLocation == null)
            System.out.println("iL = null");
        if (sameLocation(initialLocation, expectedLocation)) { 
            System.out.println("testSingleArgumentConstructor SUCCESS"); 
        } else { 
            System.out.println(String.format( "testSingleArgumentConstructor FAIL: %s != (2,4)!", initialLocation)); 
        } 
        
        Point expectedLocation2 = new Point(5, 6);
        Kiva kiva2 = new Kiva(defaultMap, expectedLocation2);
        
        Point initialLocation2 = kiva2.getCurrentLocation();
        
        if( initialLocation2 == null)
            System.out.println("iL2 = null");
        if (sameLocation(initialLocation2, expectedLocation2)) { 
            System.out.println("testSingleArgumentConstructor2 SUCCESS"); 
        } else { 
            System.out.println(String.format( "testSingleArgumentConstructor2 FAIL: %s != (2,4)!", initialLocation)); 
        } 
    } 

    private boolean sameLocation(Point a, Point b) { 
        return a.getX() == b.getX() && a.getY() == b.getY(); 
    } 

    // For you: create a test for the constructor taking two arguments. 
}

