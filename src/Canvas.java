import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;


public class Canvas extends JComponent {
    private static Color color;
    private static int circleSize;
    private static final int windowSize = 800;

    private final Snake snake = new Snake();
    private final Pellet pellet = new Pellet();

    private static int x = windowSize/2;
    private static int y = windowSize/2;
    private static final Color[] colours = {Color.GREEN};
//            Color.BLUE, Color.GREEN, Color.MAGENTA};
    private static char direction = 'l';
    public static volatile boolean FLAG = false;
    private static int waitTime = 50;


    private static int HIGHSCORE = 0;

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
                        requestFocusInWindow();
                    }
                });
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, windowSize, windowSize);
        g2d.setFont(new Font("Times New Roman", Font.BOLD, windowSize/10));


        g2d.setColor(Color.GRAY);


        g2d.drawString("Length: "+ snake.getLength(), windowSize/5, windowSize/8);
        g2d.setFont(new Font("Times New Roman", Font.BOLD, windowSize/20));
        g2d.drawString("HIGHSCORE: "+ HIGHSCORE, (windowSize/10), windowSize-windowSize/5 );
        switch (direction) {
            case ('d') -> y += 10;
            case ('u') -> y -= 10;
            case ('l') -> x -= 10;
            case ('r') -> x += 10;
        }
        try {
            Thread.sleep(waitTime);
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
            g2d.setColor(colours[i%(colours.length)]);
            g2d.fillOval(snake.getExistingCircles().get(i).getX(), snake.getExistingCircles().get(i).getY(), 10, 10);
            i++;
        }
        g2d.setColor(Color.cyan);
        g2d.fillOval(pellet.getX(), pellet.getY(), 10, 10);

        if (CirclePosition.checkDuplicate(snake.getExistingCircles().get(snake.getExistingCircles().size() - 1), snake.getExistingCircles()))
         {
            setFLAG(true);
            snake.reset();

            g2d.setColor(Color.RED);
            g2d.fillRect(0, 0, windowSize, windowSize);
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Times New Roman", Font.BOLD,windowSize/10));
            g2d.drawString("Collision!", windowSize/3,windowSize/2);
            repaint();
        }
        if((snake.getHead().getY()<0||snake.getHead().getY()>windowSize)||(snake.getHead().getX()<0||snake.getHead().getX()>windowSize)){
            setFLAG(true);
            snake.reset();
            System.out.println("hi");

            g2d.setColor(Color.RED);
            g2d.fillRect(0, 0, windowSize, windowSize);
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Times New Roman", Font.BOLD,windowSize/10));
            g2d.drawString("Collision!", windowSize/3,windowSize/2);
            repaint();
        }
        if(pelletAte(snake.getExistingCircles().get(snake.getLength()-2), pellet.getPos())) {
            snake.incrementPelletsAte();
            pellet.setAte(true);
            pellet.ate();
        }
        repaint();

    }

    /**
     * Checks to see if the front of the snake hits a pellet
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
    public static int getWindowSize(){return windowSize;}
    public static void setX(int x){Canvas.x=x;}
    public static void setY(int y){Canvas.y=y;}

    public static void setHIGHSCORE(int HIGHSCORE) {
        Canvas.HIGHSCORE = HIGHSCORE;
    }
    public static int getHIGHSCORE() {
        return HIGHSCORE;
    }
}
