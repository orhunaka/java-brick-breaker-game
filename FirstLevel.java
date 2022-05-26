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

        ImageIcon ballIcon = new ImageIcon("ball.png");
        Image ballImg = ballIcon.getImage();
        Image scaledBallImg = ballImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledBallIcon = new ImageIcon(scaledBallImg);
        ball = new JLabel();
        ball.setIcon(scaledBallIcon);

        ImageIcon playerIcon = new ImageIcon("player.png");
        Image playerImg = playerIcon.getImage();
        Image scaledPlayerImg = playerImg.getScaledInstance(80, 20, Image.SCALE_SMOOTH);
        ImageIcon scaledPlayerIcon = new ImageIcon(scaledPlayerImg);
        player = new JLabel();
        player.setIcon(scaledPlayerIcon);

        add(ball);
        ball.setBounds(100, 100, 30, 30);

        add(player);
        player.setBounds(180, 240, 80, 20);
        
    }
}
