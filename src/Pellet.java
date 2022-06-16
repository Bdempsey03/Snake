import java.util.Random;
public class Pellet {

    private CirclePosition pos;
    private final Random rnd = new Random();
    private boolean ate = false;

    public Pellet() {
        pos = new CirclePosition(Canvas.getWindowSize()/5+(rnd.nextInt(Canvas.getWindowSize()/5*3) / 10 * 10), Canvas.getWindowSize()/5+(rnd.nextInt(Canvas.getWindowSize()/5*3) / 10 * 10));
    }

    public int getX() {
        return pos.getX();
    }

    public int getY() {
        return pos.getY();
    }

    public CirclePosition getPos() {
        return pos;
    }

    public void ate() {
        if (ate) {
            pos = new CirclePosition(Canvas.getWindowSize()/5+(rnd.nextInt(Canvas.getWindowSize()/5*3) / 10 * 10), Canvas.getWindowSize()/5+(rnd.nextInt(Canvas.getWindowSize()/5*3) / 10 * 10));
            ate = false;
        }

    }
    public void setAte(boolean x){
        ate=x;
    }
}
