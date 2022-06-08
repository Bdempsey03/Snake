import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButton extends JComponent {
    private Color color;
    private String textColor;
    private ActionListener AL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            GUI.setColor(color);
        }};
    public ColorButton(String textColor, Color color){
        this.textColor = textColor;
        this.color = color;
    }
}
