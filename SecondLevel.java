import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;


public class SecondLevel extends JFrame implements ActionListener {
    
    private static final int SCREEN_WIDTH = 400;
    private static final int SCREEN_HEIGHT = 300;

    private JLabel ball;
    private final int ballWidth = 25;
    private final int ballHeight = 25;

    private JLabel player;
    private final int playerWidth = 80;
    private final int playerHeight = 20;
    private int playerStartingPosX = 165;
    private int playerStartingPosY = 240;
    private int playerXVelocity = 5;

    private JLabel[] blocks;
    private JLabel redBlock;
    private JLabel orangeBlock;
    private int blockCount = 30;
    private final int blocksArraySize = 30;
    private final int blockWidth = 30;
    private final int blockHeight = 10;

    private int bottomLayerStartingPosY = 32;
    private int bottomLayerStartingPosX = 20;

    public SecondLevel() {

        super("Level 2");
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setBackground(Color.black);  

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
        

        blocks = new JLabel[blocksArraySize];

        //Bottom Layer Red Blocks
        for (int i = 0; i < 10; i++) {

            System.out.println("Debug");

            redBlock = new JLabel();
            redBlock.setIcon(redScaledBlockIcon);
            blocks[i] = redBlock;

            add(blocks[i]);
            blocks[i].setBounds(bottomLayerStartingPosX, bottomLayerStartingPosY, blockWidth, blockHeight);
            
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
        for (int k = 20; k < 30; k++) {

            System.out.println("Debug");

            redBlock = new JLabel();
            redBlock.setIcon(redScaledBlockIcon);
            blocks[k] = redBlock;

            add(blocks[k]);
            blocks[k].setBounds(bottomLayerStartingPosX, bottomLayerStartingPosY, blockWidth, blockHeight);
            
            bottomLayerStartingPosX += 36;
        }

        add(ball);
        ball.setBounds(playerStartingPosX, playerStartingPosY, ballWidth, ballHeight);

        add(player);
        player.setBounds(playerStartingPosX, playerStartingPosY, playerWidth, playerHeight);
        player.setFocusable(true);
        player.addKeyListener(new MovePlayer());

        setVisible(true);
    }

    public class MovePlayer extends KeyAdapter {
        
        public void keyPressed(KeyEvent event) {
            
            Point playerPoint = player.getLocation();
            int x = playerPoint.x;
            int y = playerPoint.y;

            switch(event.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    player.setLocation(x - playerXVelocity, y);
                    break;
                case KeyEvent.VK_RIGHT:
                    player.setLocation(x + playerXVelocity, y);
                    break;    
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
