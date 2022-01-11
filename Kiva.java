import edu.duke.Point;
import edu.duke.FileResource;
/**
 * Uses a floormap to Control the kiva robot to pick up a Pod and drop it off in the Drop_Zone.
 * 
 * @author Jeffrey Mitchell 
 * @version 1.0
 */
public class Kiva {
    private Point currentLocation;
    private FacingDirection directionFacing;
    private FloorMap map;
    private boolean carryingPod;
    private boolean successfullyDropped;
    private long motorLifetime = 0L;
    /**
     * Constructor with just a FloorMap.
     * @param map This is the map that the Kiva will be moving on.
     */
    public Kiva(FloorMap map)
    {
        this(map, map.getInitialKivaLocation());
    }
    
    /**
     * Constructor with FloorMap and Point.
     * @param map This is the map that the Kiva will be moving on.
     * @param currentLocation The current location of the Kiva.
     */
    public Kiva(FloorMap map, Point currentLocation)
    {
        this.map = map;
        this.currentLocation = currentLocation;
        this.directionFacing = FacingDirection.UP;
        this.carryingPod = false;
        this.successfullyDropped = false;
    }
    
    /**
     * Used to control the Kiva.
     * @param command The enum used to issue commands.
     */
    public void move(KivaCommand command)
    {
        if(command.getDirectionKey() == 'F')
        {
            moveForward();
        }
        else if(command.getDirectionKey() == 'L')
        {
            turnLeft();
        }
        else if(command.getDirectionKey() == 'R')
        {
            turnRight();
        }
        else if(command.getDirectionKey() == 'T')
        {
            take();
        }
        else if(command.getDirectionKey() == 'D')
        {
            drop();
        }
    }
    
    /**
     * Method used in move method to move the Kiva Forward.
     */
    public void moveForward()
    {
        int x = currentLocation.getX();
        int y = currentLocation.getY();
        
        if(directionFacing == FacingDirection.UP)
        {
            Point np = new Point(x,y-1);
            if(np.getY() < 0 || np.getY() > map.getMaxRowNum() || map.getObjectAtLocation(np) == FloorMapObject.OBSTACLE)
            {   
                throw new IllegalMoveException(String.format(
                "Can't FORWARD: location %s is %s, not EMPTY!", np, map.getObjectAtLocation(np)));
            }
            else if(carryingPod == true && map.getObjectAtLocation(np) == FloorMapObject.POD)
            {
                throw new IllegalMoveException(String.format(
                "Can't FORWARD: location %s is %s, not EMPTY!", np, map.getObjectAtLocation(np)));
            
            }
            else
            {
                this.currentLocation = np;
            }
        }        
        else if(directionFacing == FacingDirection.LEFT)
        {
            Point np = new Point(x-1,y);
            if(np.getX() < 0 || map.getObjectAtLocation(np) == FloorMapObject.OBSTACLE)
            {   
                throw new IllegalMoveException(String.format(
                "Can't FORWARD: location %s is %s, not EMPTY!", np, map.getObjectAtLocation(np)));
            }
            else if(carryingPod == true && map.getObjectAtLocation(np) == FloorMapObject.POD)
            {
                throw new IllegalMoveException(String.format(
                "Can't FORWARD: location %s is %s, not EMPTY!", np, map.getObjectAtLocation(np)));
            }
            else
            {
                this.currentLocation = np;
            }
            
        }   
        else if(directionFacing == FacingDirection.RIGHT)
        {
            Point np = new Point(x+1,y);
            if(np.getX() > map.getMaxColNum() || map.getObjectAtLocation(np) == FloorMapObject.OBSTACLE)
            {   
                throw new IllegalMoveException(String.format(
                "Can't FORWARD: location %s is %s, not EMPTY!", np, map.getObjectAtLocation(np)));
            }
            else if(carryingPod == true && map.getObjectAtLocation(np) == FloorMapObject.POD)
            {
                throw new IllegalMoveException(String.format(
                "Can't FORWARD: location %s is %s, not EMPTY!", np, map.getObjectAtLocation(np)));
            }
            else
            {
                this.currentLocation = np;
            }
        }
        else if(directionFacing == FacingDirection.DOWN)
        {
            Point np = new Point(x,y+1);
            if(np.getY() < 0 || np.getY() > map.getMaxRowNum() || map.getObjectAtLocation(np) == FloorMapObject.OBSTACLE)
            {
                throw new IllegalMoveException(String.format(
                "Can't FORWARD: location %s is %s, not EMPTY!", np, map.getObjectAtLocation(np)));
            }
            else if(carryingPod == true && map.getObjectAtLocation(np) == FloorMapObject.POD)
            {
                throw new IllegalMoveException(String.format(
                "Can't FORWARD: location %s is %s, not EMPTY!", np, map.getObjectAtLocation(np)));
            }
            else
            {
                this.currentLocation = np;
            }
        }
        
        incrementMotorLifetime();
    }
    
    /**
     * Method used in move method to turn the Kiva Left.
     */
    public void turnLeft()
    {
        if(directionFacing == FacingDirection.UP)
            directionFacing = FacingDirection.LEFT;
        else if(directionFacing == FacingDirection.LEFT)
            directionFacing = FacingDirection.DOWN;
        else if(directionFacing == FacingDirection.DOWN)
            directionFacing = FacingDirection.RIGHT;
        else if(directionFacing == FacingDirection.RIGHT)
            directionFacing = FacingDirection.UP;
            
        incrementMotorLifetime();
    }
    
    /**
     * Method used in move method to turn the Kiva Right.
     */
    public void turnRight()
    {
        if(directionFacing == FacingDirection.UP)
            directionFacing = FacingDirection.RIGHT;
        else if(directionFacing == FacingDirection.RIGHT)
            directionFacing = FacingDirection.DOWN;
        else if(directionFacing == FacingDirection.DOWN)
            directionFacing = FacingDirection.LEFT;
        else if(directionFacing == FacingDirection.LEFT)
            directionFacing = FacingDirection.UP;
            
        incrementMotorLifetime();
    }
    
    /**
     * Method used in move method to Take the Pod.
     */
    public void take()
    {
        if(map.getObjectAtLocation(currentLocation) == FloorMapObject.POD )
        {
            carryingPod = true;
            successfullyDropped = false;
        }
        else
        {
            throw new NoPodException(String.format(
                "Can't TAKE: location %s is %s, not POD!", currentLocation, map.getObjectAtLocation(currentLocation)));
        }
    }
    
    /**
     * Method used in move method to Drop the Pod in a Drop_Zone.
     */
    public void drop()
    {
        if(carryingPod == true && map.getObjectAtLocation(currentLocation) == FloorMapObject.DROP_ZONE)
        {
            successfullyDropped = true;
            carryingPod = false;
        }
        else if(carryingPod == false)
        {
            throw new IllegalMoveException(String.format(
                "Can't DROP: no pod to drop"));
        }
        else
        {
            throw new IllegalDropZoneException(String.format(
                "Can't DROP: location %s is %s, not DROP_ZONE!", currentLocation, map.getObjectAtLocation(currentLocation)));
        }
    }
    
    /**
     * Used to Increment the motor lifetime of the Kiva.
     */
    public void incrementMotorLifetime()
    {
        motorLifetime += 1000L;
        //System.out.println("lifetime- " + motorLifetime);
    }
    
    /**
     * Getter for long motorLifetime.
     * @return The lifetime of the motor.
     */
    public long getMotorLifetime()
    { return motorLifetime; }
    
    /**
     * Getter for Point currentLocation.
     * @return the current location of the Kiva.
     */
    public Point getCurrentLocation()
    { return currentLocation; }
    
    /**
     * Getter for boolean carryingPod.
     * @return whether th eKiva is carrying a pod or not.
     */
    public boolean isCarryingPod()
    { return carryingPod; }
    
    /**
     * Getter for FacingDirection directionFacing.
     * @return the direction that the Kiva is facing.
     */
    public FacingDirection getDirectionFacing()
    { return directionFacing; }
    
    /**
     * Getter for boolean successfullyDropped.
     * @return if the pod has been successfully dropped.
     */
    public boolean isSuccessfullyDropped()
    { return successfullyDropped; }
    
}
