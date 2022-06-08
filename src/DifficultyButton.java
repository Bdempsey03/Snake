import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyButton {
    private int circleSize;
    private String diff;
    private ActionListener AL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            GUI.setCircleSize(circleSize);
        }
    };

    public DifficultyButton(int circleSize, String difficulty){
        this.circleSize=circleSize;
        diff=difficulty;
    }
}
