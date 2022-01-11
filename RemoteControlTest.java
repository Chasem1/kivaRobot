import edu.duke.FileResource;
import java.util.Arrays; 
/**
 * Tester for RemoteControl
 */
public class RemoteControlTest {
    public void testRemoteControl()
    {
        RemoteControl rc = new RemoteControl();
        System.out.println(Arrays.toString(rc.convertToKivaCommands("FFFTRF")));
        System.out.println(Arrays.toString(rc.convertToKivaCommands("B")));
    }
}
