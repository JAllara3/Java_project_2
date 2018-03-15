/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jelu
 */
package piano;
import javax.swing.*;



/*
To simplify testing our code, we will write a method to handle running all the examples
that we create.
*/

public class displayFramework {
    // Takes a frame as input and passes responsibility for updating it to the event 
    // queue
    public static void runFrame(JFrame f, int width, int height) {
        // We pass a runnable as a lambda expression to invokeLater
       SwingUtilities.invokeLater(() -> {
           // We set the title of the frame to the name of the class that we pass
           // (since we will most likely be passing subclasses of JFrame).
           f.setTitle(f.getClass().getSimpleName());
           f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           f.setSize(width, height);
           f.setVisible(true);
       });
    }
}