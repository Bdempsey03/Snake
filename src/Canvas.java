import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Canvas extends JComponent {
    private Color color;
    private int circleSize;

    private final Snake snake = new Snake();
    private final Pellet pellet = new Pellet();
    private static int x = 500;
    private static int y = 500;
    private static final Color[] colours = {Color.BLUE, Color.GREEN};
    private static char direction = 'd';
    public static volatile boolean FLAG = false;

    /**
     * Constructs the canvas graphical object. Contains the keyboard listener for arrow key
     * inputs to set snake direction.
     */
    public Canvas() {
        setFocusable(true);
        requestFocusInWindow();
        this.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {

                        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                            direction = 'd';
                        }
                        if (e.getKeyCode() == KeyEvent.VK_UP) {
                            direction = 'u';
                        }
                        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                            direction = 'l';
                        }
                        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                            direction = 'r';
                        }

                    }
                });
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 1000, 1000);
        g2d.setColor(Color.BLACK);
        System.out.println(direction);
        switch (direction) {
            case ('d') -> y += 10;
            case ('u') -> y -= 10;
            case ('l') -> x -= 10;
            case ('r') -> x += 10;
        }
        try {
            Thread.sleep(100);
            if(FLAG)
                Thread.sleep(900);
            setFLAG(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int i = 0;

        snake.getExistingCircles().add(new CirclePosition(x, y));

        if (snake.getExistingCircles().size() > snake.getLength()) {
            snake.getExistingCircles().remove(0);

        }
        while (i < snake.getExistingCircles().size()) {
            g2d.setColor(colours[i%2]);
            g2d.fillOval(snake.getExistingCircles().get(i).getX(), snake.getExistingCircles().get(i).getY(), 10, 10);
            i++;
        }
        g2d.setColor(Color.cyan);
        g2d.fillOval(pellet.getX(), pellet.getY(), 10, 10);

        if (CirclePosition.checkDuplicate(snake.getExistingCircles().get(snake.getExistingCircles().size() - 1), snake.getExistingCircles())) {
            setFLAG(true);
            System.out.println("HIT!");
            snake.getExistingCircles().clear();
            snake.reset();
            System.out.println("Here tooo");
            g2d.drawString("Collision!", 400,400);
            g2d.setColor(Color.RED);
            g2d.fillRect(0, 0, 1000, 1000);
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Times New Roman", Font.BOLD,100));
            g2d.drawString("Collision!", 300,400);
            repaint();
        }
        if(pelletAte(snake.getExistingCircles().get(snake.getExistingCircles().size()-1), pellet.getPos())) {
            snake.incrementPelletsAte();
            pellet.setAte(true);
            pellet.ate();
        }
        repaint();

    }

    /**
     * Checks to see if the front of the snake hits a pellet
     *
     */
    public boolean pelletAte(CirclePosition head, CirclePosition pellet){
        return head.toString().equals(pellet.toString());
    }

    /**
     * Setter for the "collision" flag
     * @param x boolean value
     */
    public void setFLAG(boolean x) {
        FLAG=x;
    }
    public void setColor(Color color){
        this.color=color;
    }
    public void setCircleSize(int circleSize){
        this.circleSize = circleSize;
    }
}
