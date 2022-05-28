import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RedBricks extends JLabel {
    
    private final int brickWidth = 30;
    private final int brickHeight = 10;
    

    public RedBricks() {

        ImageIcon brickIcon = new ImageIcon("level1block.png");
        Image brickImg = brickIcon.getImage();
        Image scaledBrickImg = brickImg.getScaledInstance(brickWidth, brickHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledBrickIcon = new ImageIcon(scaledBrickImg);
        setIcon(scaledBrickIcon);
    }
}
