package MyGame;

import javax.swing.*;
import java.awt.TextArea;

/**
 * this class for the creating Frame with specifications adding the game in
 */
public class Frame {
    /**
     * main method
     * @param args for command line args
     */
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Ucan Tekme Oyunu");

        frame.add(new GameBoard());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}


