import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;


public class FirstLevel extends JFrame {
    
    private JLabel ball;
    private final int ballWidth = 25;
    private final int ballHeight = 25;

    private JLabel player;
    private final int playerWidth = 80;
    private final int playerHeight = 20;

    private JLabel[] blocks;
    private JLabel block;
    private final int blocksArraySize = 30;
    private final int blockWidth = 30;
    private final int blockHeight = 10;

    private int bottomLayerStartingPosY = 32;
    private int bottomLayerStartingPosX = 20;

    public FirstLevel() {

        super("Level 1");
        setLayout(null);

        ImageIcon ballIcon = new ImageIcon("ball.png");
        Image ballImg = ballIcon.getImage();
        Image scaledBallImg = ballImg.getScaledInstance(ballWidth, ballHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledBallIcon = new ImageIcon(scaledBallImg);
        ball = new JLabel();
        ball.setIcon(scaledBallIcon);

        ImageIcon playerIcon = new ImageIcon("player.png");
        Image playerImg = playerIcon.getImage();
        Image scaledPlayerImg = playerImg.getScaledInstance(playerWidth, playerHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledPlayerIcon = new ImageIcon(scaledPlayerImg);
        player = new JLabel();
        player.setIcon(scaledPlayerIcon);

        ImageIcon blockIcon = new ImageIcon("level1block.png");
        Image blockImg = blockIcon.getImage();
        Image scaledBlockImg = blockImg.getScaledInstance(blockWidth, blockHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledBlockIcon = new ImageIcon(scaledBlockImg);
        

        blocks = new JLabel[blocksArraySize];

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 10; i++) {

                System.out.println("Debug");

                block = new JLabel();
                block.setIcon(scaledBlockIcon);
                blocks[i] = block;

                add(blocks[i]);
                blocks[i].setBounds(bottomLayerStartingPosX, bottomLayerStartingPosY, blockWidth, blockHeight);
                
                bottomLayerStartingPosX += 36;
            }
            bottomLayerStartingPosY += 16;
            bottomLayerStartingPosX = 20;
        }

        add(ball);
        ball.setBounds(100, 100, ballWidth, ballHeight);

        add(player);
        player.setBounds(165, 240, playerWidth, playerHeight);
    }
}
