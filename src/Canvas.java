import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Canvas extends JComponent {

    public static java.util.Random rnd = new Random();
    public static BufferedImage queen;
    private static boolean moved = false;
    private static int x = 500;
    private static int y = 500;
    private static int rndCPUx = 500;
    private static int rndCPUy = 500;
    private static int smrtCPUx = 500;
    private static int smrtCPUy = 500;
    private static ArrayList<CirclePosition> playerExistingCircles = new ArrayList<CirclePosition>();
    private static ArrayList<CirclePosition> rndCPUExistingCircles = new ArrayList<>();
    private static ArrayList<CirclePosition> smrtCPUExistingCircles = new ArrayList<>();
    private static Color[] colours = {Color.BLUE, Color.RED, Color.PINK, Color.CYAN, Color.ORANGE, Color.GREEN, Color.MAGENTA};
    private static char direction = 'd';

    public Canvas(){
        setFocusable(true);
        requestFocusInWindow();
        this.addKeyListener(
                new KeyAdapter(){
                    @Override
                    public void keyPressed(KeyEvent e){

                        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                            direction='d';
                        }
                        if (e.getKeyCode() == KeyEvent.VK_UP) {
                            direction='u';
                        }
                        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                            direction='l';
                        }
                        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                            direction='r';
                        }
                    }


//                new MouseAdapter() {
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                System.out.println("hello");
//                moved =true;
//                x = getMousePosition().x-5;
//                y = getMousePosition().y-5;
//                repaint();
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
//            }
        });



    }

    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0,0,1000,1000);
        g2d.setColor(Color.BLACK);
        System.out.println(direction);
        switch(direction){
            case('d'): y+=10;
            break;
            case('u'): y-=10;
            break;
            case('l'): x-=10;
            break;
            case('r'): x+=10;
                break;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            int i = 0;

            playerExistingCircles.add(new CirclePosition(x, y));
            /*
            rndCPUx +=rnd.nextInt(11)-5;
            rndCPUy +=rnd.nextInt(11)-5;
            rndCPUExistingCircles.add(new CirclePosition(rndCPUx, rndCPUy));

            smrtCPUMovement(x, y);

            smrtCPUExistingCircles.add(new CirclePosition(smrtCPUx, smrtCPUy));

            more AI code
*/

            if(playerExistingCircles.size()>50){
                playerExistingCircles.remove(0);
//                if(smrtCPUExistingCircles.size()>25) {
//                    rndCPUExistingCircles.remove(0);
//                    smrtCPUExistingCircles.remove(0);
//                }
            }
            while(i<playerExistingCircles.size()) {
//                g2d.setColor(colours[i%7]);
                g2d.fillOval(playerExistingCircles.get(i).getX(), playerExistingCircles.get(i).getY(), 10, 10);
                /*
                g2d.setColor(Color.RED);
                g2d.fillOval(rndCPUExistingCircles.get(i).getX(), rndCPUExistingCircles.get(i).getY(),10,10);
                g2d.setColor(Color.BLACK);
                g2d.fillOval(smrtCPUExistingCircles.get(i).getX(),smrtCPUExistingCircles.get(i).getY(), 10, 10);

                above code will draw AI
                */

//                Image();
//                g2d.drawImage(queen,playerExistingCircles.get(i).getX(),playerExistingCircles.get(i).getY(), null );
                i++;
        }
//            if(playerExistingCircles.size()>5)
//            for(int j=0; j>=50; j++){
//                if(playerExistingCircles.size()>=j) {
//                    if (playerExistingCircles.get(j).equals(playerExistingCircles.get(j)))
//                        playerExistingCircles.clear();
//                    repaint();
//                }
//            }

            if(CirclePosition.checkDuplicate(playerExistingCircles.get(playerExistingCircles.size()-1), playerExistingCircles)){
                playerExistingCircles.clear();
                
            }
        repaint();
    }
    public static void Image(){
        try {
            queen = ImageIO.read(new File("C:\\Users\\Ben\\IdeaProjects\\Painter\\src\\WhiteQueen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void smrtCPUMovement(int playerX, int playerY){
        if(smrtCPUx>playerX){
            smrtCPUx-=rnd.nextInt(5);
        }else{
            smrtCPUx+=rnd.nextInt(5);
        }
        if(smrtCPUy>playerY){
            smrtCPUy-=rnd.nextInt(5);
        }else{
            smrtCPUy+=rnd.nextInt(5);
        }

    }

    }
