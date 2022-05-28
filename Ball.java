import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ball extends JLabel {
    
    private final int ballWidth = 25;
    private final int ballHeight = 25;

    public Ball() {

        ImageIcon ballIcon = new ImageIcon("ball.png");
        Image ballImg = ballIcon.getImage();
        Image scaledBallImg = ballImg.getScaledInstance(ballWidth, ballHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledBallIcon = new ImageIcon(scaledBallImg);
        setIcon(scaledBallIcon);

        setBounds(200, 150, ballWidth, ballHeight);
    }
}
