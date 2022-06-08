import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI {
private static Color color;
private static int circleSize;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        Canvas canvas = new Canvas();
        Info info = new Info();
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(1,1));
        frame.add(info);
        canvas.setColor(color);
//        canvas.setCircleSize(circleSize);
        frame.remove(info);
        frame.add(canvas);

        }

    public static void setColor(Color color) {
        GUI.color = color;
    }
    public static void setCircleSize(int x){
        GUI.circleSize=x;
    }
}
