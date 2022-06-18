import javax.swing.*;
import java.awt.*;

/**
 * This is the class which initiates the GUI for the Snake program.
 *
 * @author Benjamin Dempsey
 * @version 1.0.0
 */
public class GUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        Canvas canvas = new Canvas();
        frame.setSize(Canvas.getWindowSize(), Canvas.getWindowSize());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(1,1));

        frame.add(canvas);

        }
}
