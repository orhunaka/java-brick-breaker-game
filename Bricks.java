import javax.swing.*;
import java.awt.*;

public class Bricks extends JLabel {
    
    private final int brickWidth = 30;
    private final int brickHeight = 10;
    

    public Bricks() {

        ImageIcon brickIcon = new ImageIcon("level1block.png");
        Image brickImg = brickIcon.getImage();
        Image scaledBrickImg = brickImg.getScaledInstance(brickWidth, brickHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledBrickIcon = new ImageIcon(scaledBrickImg);
        setIcon(scaledBrickIcon);
    }
}
