import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class CirclePosition {
private int x;
private int y;

public CirclePosition(int x, int y){
    this.x=x;
    this.y=y;
}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * If any circles are overlapping then this will return true
     *
     * @param circleArray
     * @return
     */
    public static boolean checkDuplicate(CirclePosition head, ArrayList<CirclePosition> circleArray){
        for(int i = 2; i<circleArray.size(); i++) {
            if (circleArray.get(circleArray.size() - i - 1).toString().equals(head.toString()))
                return true;
        }
        return false;
    }



    public String toString(){
        return (""+x+"-"+y);
    }

}
