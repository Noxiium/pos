
package se.kth.iv1350.pos.Util;

import java.time.LocalDateTime;

/**
 * Logs exceptions. Should print to a file. Will fix soon
 */
public class ExceptionLogHandler {
    
    /**
     * Called when an exception happens. Print out error message to a file.
     * @param exception Exception that should be logged
     */
    public static void logException(Exception exception){
        System.out.println("Temp Error Log, this will print to a txt file " + LocalDateTime.now() + " " + exception.getMessage());
    }
    
}
