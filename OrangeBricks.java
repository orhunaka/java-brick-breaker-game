import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class OrangeBricks extends JLabel {
    
    private final int brickWidth = 30;
    private final int brickHeight = 10;
    

    public OrangeBricks() {

        ImageIcon brickIcon = new ImageIcon("level2block.png");
        Image brickImg = brickIcon.getImage();
        Image scaledBrickImg = brickImg.getScaledInstance(brickWidth, brickHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledBrickIcon = new ImageIcon(scaledBrickImg);
        setIcon(scaledBrickIcon);
    }
}
