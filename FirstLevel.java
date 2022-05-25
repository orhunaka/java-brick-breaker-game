import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class FirstLevel extends JFrame {
    
    private JLabel ball;
    private JLabel player;
    private JComponent[] blocks;

    public FirstLevel() {

        super("Level 1");
        setLayout(null);

        ImageIcon icon = new ImageIcon("ball.png");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        ball = new JLabel();
        ball.setIcon(scaledIcon);

        add(ball);
        ball.setBounds(100, 100, 30, 30);
        
    }
}
