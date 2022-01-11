import edu.duke.FileResource;
import java.util.Arrays; 
/**
 * This is the class that controls Kiva's actions. Implement the <code>run()</code>
 * method to deliver the pod and avoid the obstacles.
 *
 * This is starter code that may or may not work. You will need to update the code to
 * complete the project.
 */
public class RemoteControl {
    KeyboardResource keyboardResource;

    /**
     * Build a new RemoteControl.
     */
    public RemoteControl() {
        keyboardResource = new KeyboardResource();
    }

    /**
     * The controller that directs Kiva's activity. Prompts the user for the floor map
     * to load, displays the map, and asks the user for the commands for Kiva to execute.
     *
     * [Here's the method you'll execute from within BlueJ. It may or may not run successfully
     * as-is, but you'll definitely need to add more to complete the project.]
     */
    public void run() {
        System.out.println("Please select a map file.");
        FileResource fileResource = new FileResource();
        String inputMap = fileResource.asString();
        FloorMap floorMap = new FloorMap(inputMap);
        System.out.println(floorMap);
        
        Kiva kiva = new Kiva(floorMap);
        System.out.println("Kiva is starting at " + kiva.getCurrentLocation());
        System.out.println("Kiva is facing " + kiva.getDirectionFacing());
        
        System.out.println("Please enter the directions for the Kiva Robot to take.");
        String directions = keyboardResource.getLine();
        System.out.println("Directions that you typed in: " + directions);
        KivaCommand[] commandList = convertToKivaCommands(directions);
        boolean dropped = false;
        //moved after dropped
        boolean mad = false;
        for(KivaCommand kc : commandList)
        {
            kiva.move(kc);
            if(kc == KivaCommand.TAKE)
            {
                System.out.println("Kiva picked up the pod!");
                if(dropped == true)
                     mad = true;
                
            }
            else if(kc == KivaCommand.DROP)
            {
                System.out.println("Kiva dropped the pod at the drop zone!");
                dropped = true;
            }
            else if(kc == KivaCommand.FORWARD)
            {
                System.out.println("Kiva moved forward!");
                if(dropped == true)
                     mad = true;
            }
            else if(kc == KivaCommand.TURN_LEFT)
            {
                System.out.println("Kiva turned left!");
                if(dropped == true)
                     mad = true;
            }
            else if(kc == KivaCommand.TURN_RIGHT)
            {
                System.out.println("Kiva turned right!");
                if(dropped == true)
                     mad = true;
            }
                
        }
        
        if(kiva.isSuccessfullyDropped() && mad == false)
            System.out.println("Successfully picked up the pod and dropped it off. Thank you!");
        else
             System.out.println("I'm sorry. The Kiva Robot did not pick up the pod and then drop it off in the right place.");
             
    }
    
    /**
     * Converts input into commands readable by the Kiva.
     * @param commands The commands that are issued to the Kiva.
     */
    public KivaCommand[] convertToKivaCommands(String commands)
    {
        KivaCommand[] commandList = new KivaCommand[commands.length()];
        KivaCommand[] allCommands = KivaCommand.values();
        boolean valid = false;
        
        
        for(int i = 0; i < commands.length();i++)
        {
            char input = commands.charAt(i);
            int key = 0;
            for(key = 0; key <5; key++)
            {
                if(allCommands[key].getDirectionKey() == input)
                {
                    commandList[i] = allCommands[key];
                    break;
                }
                else if(key == 4)
                {
                    throw new IllegalArgumentException("invalid command");
                }
            }
            
        }
        return commandList;
    }
}
