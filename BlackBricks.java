import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BlackBricks extends JLabel {
    
    private final int brickWidth = 30;
    private final int brickHeight = 10;
    

    public BlackBricks() {

        ImageIcon brickIcon = new ImageIcon("level3block.png");
        Image brickImg = brickIcon.getImage();
        Image scaledBrickImg = brickImg.getScaledInstance(brickWidth, brickHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledBrickIcon = new ImageIcon(scaledBrickImg);
        setIcon(scaledBrickIcon);
    }
}
