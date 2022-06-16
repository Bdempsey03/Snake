import java.util.ArrayList;

public class Snake {
    private final ArrayList<CirclePosition> existingCircles;
    private int pelletsAte;
    private int length=2;
    private int lives;
//    private static int windowSize = Canvas.getWindowSize();

    public Snake(){
        lives=3;
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
        if(length>Canvas.getHIGHSCORE())
        Canvas.setHIGHSCORE(length);

        if(lives<=0) {
            System.out.println("---");
            lives=3;
            pelletsAte = 0;
            setLength();
            existingCircles.clear();
            existingCircles.add(new CirclePosition(Canvas.getWindowSize() / 2, Canvas.getWindowSize() / 2));
            existingCircles.add(new CirclePosition(Canvas.getWindowSize() / 2, Canvas.getWindowSize() / 2 + 10));
        }else{
            lives--;
        }
            Canvas.setX(Canvas.getWindowSize() / 2);
            Canvas.setY(Canvas.getWindowSize() / 2);
    }
    public CirclePosition getHead(){
        return existingCircles.get(existingCircles.size()-1);
    }
    public int getLives(){
        return lives;
    }
    public void setLives(int l){
        lives=l;
    }
}
