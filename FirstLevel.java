import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

import javax.swing.*;


public class FirstLevel extends JFrame implements ActionListener {

    static final int DELAY = 75;
    Timer timer = new Timer(DELAY, this);

    private JLabel ball;
    private final int ballWidth = 25;
    private final int ballHeight = 25;

    private JComponent player;
    ImageIcon scaledPlayerIcon;
    private final int playerWidth = 80;
    private final int playerHeight = 20;
    private int playerStartingPosX = 165;
    private int playerStartingPosY = 240;
    private int playerXVelocity = 5;

    private JLabel[] blocks;
    private JLabel block;
    private int blockCount = 30;
    private final int blocksArraySize = 30;
    private final int blockWidth = 30;
    private final int blockHeight = 10;

    private int bottomLayerStartingPosY = 32;
    private int bottomLayerStartingPosX = 20;

    public FirstLevel() {

        setLayout(null);
        addKeyListener(new MyKeyAdapter());

        startGame();
    }

    public void startGame() {

        timer.start();
        drawComponents();
    }

    public void drawComponents() {

        ImageIcon ballIcon = new ImageIcon("ball.png");
        Image ballImg = ballIcon.getImage();
        Image scaledBallImg = ballImg.getScaledInstance(ballWidth, ballHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledBallIcon = new ImageIcon(scaledBallImg);
        ball = new JLabel();
        ball.setIcon(scaledBallIcon);

        ImageIcon playerIcon = new ImageIcon("player.png");
        Image playerImg = playerIcon.getImage();
        Image scaledPlayerImg = playerImg.getScaledInstance(playerWidth, playerHeight, Image.SCALE_SMOOTH);
        scaledPlayerIcon = new ImageIcon(scaledPlayerImg);
        player = new JComponent();
        player.setIcon(scaledPlayerIcon);

        ImageIcon blockIcon = new ImageIcon("level1block.png");
        Image blockImg = blockIcon.getImage();
        Image scaledBlockImg = blockImg.getScaledInstance(blockWidth, blockHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledBlockIcon = new ImageIcon(scaledBlockImg);
        

        blocks = new JLabel[blocksArraySize];

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 10; i++) {

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
        player.setFocusable(true);
        player.setBounds(playerStartingPosX, playerStartingPosY, playerWidth, playerHeight);
    }

    public void move() {


    }

    public void checkCollision() {


    }

    public void checkBricks() {


    }

    public void gameOver() {


    }

    public class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            switch(event.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    playerStartingPosX -= playerXVelocity;
                    player.setLocation(playerStartingPosX, playerStartingPosY);
                    break;
                case KeyEvent.VK_RIGHT:
                    playerStartingPosX += playerXVelocity;
                    player.setLocation(playerStartingPosX, playerStartingPosY);
                    break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}