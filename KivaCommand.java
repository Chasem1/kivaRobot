
/**
 * Enum holding the commands to give to the Kiva
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public enum KivaCommand {
    FORWARD('F'),
    TURN_LEFT('L'),
    TURN_RIGHT('R'),
    TAKE('T'),
    DROP('D');
    
    private char key;
    
    /**
     * Constructor for the Kiva
     * @param key The key used to find the correct movement.
     */
    private KivaCommand(char key)
    {
        this.key = key;
    }
    
    /**
     * Getter for the key.
     * @return. The key used to signal which movement to take.
     */
    public char getDirectionKey()
    { return this.key; }
    
    
}
