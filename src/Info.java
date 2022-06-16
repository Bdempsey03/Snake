import javax.swing.*;
import java.awt.*;

public class Info extends JPanel {

    private ColorButton red = new ColorButton("red", Color.RED);
    private ColorButton blue = new ColorButton("blue", Color.BLUE);
    private ColorButton purple = new ColorButton("purple", new Color(120, 20, 200));

    private DifficultyButton easy = new DifficultyButton(10, "Easy");
    private DifficultyButton medium = new DifficultyButton(30, "Medium");
    private DifficultyButton hard = new DifficultyButton(50, "Hard");

    public Info(){
        this.setLayout(new GridLayout(2,3));
        this.setSize(Canvas.getWindowSize(),Canvas.getWindowSize());
        this.add(red);
        this.add(blue);
        this.add(purple);
        this.add(easy);
        this.add(medium);
        this.add(hard);
    }
}
