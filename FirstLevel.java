import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.Timer;
import javax.swing.*;

public class FirstLevel extends JFrame {

    Player player;
    Ball ball;
    RedBricks bricks;

    private final int brickWidth = 30;
    private final int brickHeight = 10;

    static final int DELAY = 75;

    private int ballYVelocity = 5;
    private int ballXVelocity = 5;

    private JLabel scoreText = new JLabel("Score: ");
    private JLabel score = new JLabel("0");
    private int brickBrokenScore = 1;
    private int startingScore = 0;

    private static final int SCREEN_WIDTH = 400;
    private static final int SCREEN_HEIGHT = 300;

    ArrayList<JLabel> bricksArray = new ArrayList<JLabel>();
    private int bricksArraySize = 30;
    private int bottomLayerStartingPosY = 32;
    private int bottomLayerStartingPosX = 20;

    public FirstLevel() {
        
        //Creating the frame.
        super("Level 1");
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setBackground(Color.black);  

        //Creating the bricks.
        for (int i = 0; i < 10; i++) {

            bricks = new RedBricks();
            bricksArray.add(bricks);

            add(bricksArray.get(i));
            bricksArray.get(i).setBounds(bottomLayerStartingPosX, bottomLayerStartingPosY, brickWidth, brickHeight);
            
            bottomLayerStartingPosX += 36;
        }
        bottomLayerStartingPosY += 16;
        bottomLayerStartingPosX = 20;

        for (int i = 10; i < 20; i++) {
            
            bricks = new RedBricks();
            bricksArray.add(bricks);

            add(bricksArray.get(i));
            bricksArray.get(i).setBounds(bottomLayerStartingPosX, bottomLayerStartingPosY, brickWidth, brickHeight);
            
            bottomLayerStartingPosX += 36;
        }

        bottomLayerStartingPosY += 16;
        bottomLayerStartingPosX = 20;

        for (int i = 20; i < 30; i++) {
            
            bricks = new RedBricks();
            bricksArray.add(bricks);

            add(bricksArray.get(i));
            bricksArray.get(i).setBounds(bottomLayerStartingPosX, bottomLayerStartingPosY, brickWidth, brickHeight);
            
            bottomLayerStartingPosX += 36;
        }

        //Creating the ball and adding it to the frame.
        ball = new Ball();
        add(ball);
        
        //Creating the player and adding it to the frame.
        player = new Player();
        player.addKeyListener(new MovePlayer());
        add(player);

        //Adding the score text.
        add(scoreText);
        add(score);
        //scoreText.setSize(20, 10);
        //scoreText.setPreferredSize(new Dimension(200, 100));
        scoreText.setBounds(10, 5, 50, 20);
        scoreText.setForeground(Color.BLACK);
        score.setBounds(55, 5, 50, 20);
        score.setForeground(Color.BLACK);
        scoreText.setVisible(true);
        score.setVisible(true);

        //Setting the frame's visibility option.
        setVisible(true);

        //Every 50 milliseconds, checks the functions
        //below.
        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MoveBallAndCheckCollision();
                checkIntersection(ball, bricksArray);
                //checkIntersectionWithPlayer(ball, player);

                /*if (bricksArraySize == 0) {

                    JOptionPane.showMessageDialog(null, "Congratulations! Let's go to round 2!");
                    SecondLevel secondLevel = new SecondLevel();
                }*/
            }

            //Method to automatically move the ball.
            private void MoveBallAndCheckCollision() {
                
                Point ballPoint = ball.getLocation();
                int ballX = ballPoint.x;
                int ballY = ballPoint.y;                
                
                ball.setLocation(ballX + ballXVelocity, ballY + ballYVelocity);
                
                if (ballPoint.x < 0 || ballPoint.x > 370) {
                    ballXVelocity = -ballXVelocity;
                    ball.setLocation(ballPoint.x + ballXVelocity, ballPoint.y + ballYVelocity);
                }
                if (ballPoint.y < 0) {
                    ballYVelocity = -ballYVelocity;
                    ball.setLocation(ballPoint.x + ballXVelocity, ballPoint.y + ballYVelocity);
                }
                if (ballPoint.y > 240) {
                    JOptionPane.showMessageDialog(null, "Failed. Try again.");
                    System.exit(0);
                }

                Rectangle playerObject = player.getBounds();
                //Rectangle brickObject = bricks.getBounds();
                Rectangle resultWithPlayer = SwingUtilities.computeIntersection(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight(), playerObject);
                //Rectangle resultWithBrick = SwingUtilities.computeIntersection(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight(), brickObject);

                if (resultWithPlayer.getWidth() > 0 && resultWithPlayer.getHeight() > 0) {
                    ballYVelocity = -ballYVelocity;
                    ball.setLocation(ballPoint.x + ballXVelocity, ballPoint.y + ballYVelocity);
                }
                /*if (resultWithBrick.getWidth() > 0 && resultWithBrick.getHeight() > 0) {

                    if (ballXVelocity > 0 && ballYVelocity > 0) {

                    }
                }*/
            }

            //Method to check intersection.
            private void checkIntersection(JLabel ballObject, ArrayList<JLabel> bricksArray) {
                
                String textToSetAsScore;

                for (int i = 0; i < bricksArraySize; i++) {

                    Rectangle brickObject =  bricksArray.get(i).getBounds();
                    Rectangle result = SwingUtilities.computeIntersection(ballObject.getX(), ballObject.getY(), ballObject.getWidth(), ballObject.getHeight(), brickObject);
                    if ( result.getWidth() > 0 && result.getHeight() > 0) {
                        
                        remove(bricksArray.get(i));
                        revalidate();
                        repaint();

                        startingScore += brickBrokenScore;
                        textToSetAsScore = String.valueOf(startingScore);
                        score.setText(textToSetAsScore);
                    }
                }
            }
        });
        timer.start();
    }

    //KeyListener to move the player.
    public class MovePlayer extends KeyAdapter {
        
        int playerXVelocity = 10;

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
}