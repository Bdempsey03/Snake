import java.util.Random;
public class Pellet {

    private CirclePosition pos;
    private Random rnd = new Random();
    private boolean ate = false;

    public Pellet() {
        pos = new CirclePosition(rnd.nextInt(1000) / 10 * 10, rnd.nextInt(1000) / 10 * 10);
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
            pos = new CirclePosition(200+(rnd.nextInt(600) / 10 * 10), 200+(rnd.nextInt(600) / 10 * 10));
            ate = false;
        }

    }
    public void setAte(boolean x){
        ate=x;
    }
}
