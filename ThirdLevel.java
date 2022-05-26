import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;


public class ThirdLevel extends JFrame {
    
    private JLabel ball;
    private final int ballWidth = 25;
    private final int ballHeight = 25;

    private JLabel player;
    private final int playerWidth = 80;
    private final int playerHeight = 20;

    private JLabel[] blocks;
    private JLabel redBlock;
    private JLabel orangeBlock;
    private JLabel blackBlock;
    private final int blocksArraySize = 30;
    private final int blockWidth = 30;
    private final int blockHeight = 10;

    private int bottomLayerStartingPosY = 32;
    private int bottomLayerStartingPosX = 20;

    public ThirdLevel() {

        super("Level 2");
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

        ImageIcon redBlockIcon = new ImageIcon("level1block.png");
        Image redBlockImg = redBlockIcon.getImage();
        Image redScaledBlockImg = redBlockImg.getScaledInstance(blockWidth, blockHeight, Image.SCALE_SMOOTH);
        ImageIcon redScaledBlockIcon = new ImageIcon(redScaledBlockImg);

        ImageIcon orangeBlockIcon = new ImageIcon("level2block.png");
        Image orangeBlockImg = orangeBlockIcon.getImage();
        Image orangeScaledBlockImg = orangeBlockImg.getScaledInstance(blockWidth, blockHeight, Image.SCALE_SMOOTH);
        ImageIcon orangeScaledBlockIcon = new ImageIcon(orangeScaledBlockImg);

        ImageIcon blackBlockIcon = new ImageIcon("level3block.png");
        Image blackBlockImg = blackBlockIcon.getImage();
        Image blackScaledBlockImg = blackBlockImg.getScaledInstance(blockWidth, blockHeight, Image.SCALE_SMOOTH);
        ImageIcon blackScaledBlockIcon = new ImageIcon(blackScaledBlockImg);
        

        blocks = new JLabel[blocksArraySize];

        //Bottom Layer Red Blocks
        for (int k = 0; k < 10; k++) {

            System.out.println("Debug");

            blackBlock = new JLabel();
            blackBlock.setIcon(blackScaledBlockIcon);
            blocks[k] = blackBlock;

            add(blocks[k]);
            blocks[k].setBounds(bottomLayerStartingPosX, bottomLayerStartingPosY, blockWidth, blockHeight);
            
            bottomLayerStartingPosX += 36;
        }
        
        bottomLayerStartingPosY += 16;
        bottomLayerStartingPosX = 20;

        //Mid Layer Orange Blocks
        for (int j = 10; j < 20; j++) {

            System.out.println("Debug");

            orangeBlock = new JLabel();
            orangeBlock.setIcon(orangeScaledBlockIcon);
            blocks[j] = orangeBlock;

            add(blocks[j]);
            blocks[j].setBounds(bottomLayerStartingPosX, bottomLayerStartingPosY, blockWidth, blockHeight);
            
            bottomLayerStartingPosX += 36;
        }
        bottomLayerStartingPosY += 16;
        bottomLayerStartingPosX = 20;

        //Top Layer Red Blocks
        for (int i = 20; i < 30; i++) {

            System.out.println("Debug");

            redBlock = new JLabel();
            redBlock.setIcon(redScaledBlockIcon);
            blocks[i] = redBlock;

            add(blocks[i]);
            blocks[i].setBounds(bottomLayerStartingPosX, bottomLayerStartingPosY, blockWidth, blockHeight);
            
            bottomLayerStartingPosX += 36;
        }

        add(ball);
        ball.setBounds(100, 100, ballWidth, ballHeight);

        add(player);
        player.setBounds(165, 240, playerWidth, playerHeight);
    }
}
