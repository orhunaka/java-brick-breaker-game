import javax.swing.*;
import java.awt.*;

public class Player extends JLabel {
    
    ImageIcon scaledPlayerIcon;
    private final int playerWidth = 80;
    private final int playerHeight = 20;
    private int playerStartingPosX = 165;
    private int playerStartingPosY = 240;

    public Player() {

        ImageIcon playerIcon = new ImageIcon("player.png");
        Image playerImg = playerIcon.getImage();
        Image scaledPlayerImg = playerImg.getScaledInstance(playerWidth, playerHeight, Image.SCALE_SMOOTH);
        scaledPlayerIcon = new ImageIcon(scaledPlayerImg);
        setIcon(scaledPlayerIcon);

        setBounds(playerStartingPosX, playerStartingPosY, playerWidth, playerHeight);
        setFocusable(true);
    }
}
