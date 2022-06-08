import java.util.ArrayList;

public class Snake {
    private ArrayList<CirclePosition> existingCircles;
    private int pelletsAte = 0;
    private int length=2;

    public Snake(){
        existingCircles = new ArrayList<>();
        pelletsAte=0;
        setLength();
    }

    public ArrayList<CirclePosition> getExistingCircles(){
        return existingCircles;
    }

    public void setLength(){
        length = pelletsAte+2;
    }
    public int getLength(){
        return length;
    }
    public void incrementPelletsAte(){
        pelletsAte+=1;
        setLength();
    }
    public void reset(){
        pelletsAte=0;
        setLength();
    }
}
