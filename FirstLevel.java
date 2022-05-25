import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class FirstLevel extends JFrame {
    
    private JLabel ball;
    private JLabel player;
    private JComponent[] blocks;

    public FirstLevel() {

        super("Level 1");
    
        ImageIcon ballIcon = new ImageIcon("ball.png");
        ball = new JLabel(ballIcon);

        add(ball);
        
    }
}
