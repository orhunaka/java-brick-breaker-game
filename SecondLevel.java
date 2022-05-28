import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class SecondLevel extends JFrame {
    
    Player player;
    Ball ball;
    RedBricks redBricks;
    OrangeBricks orangeBricks;

    private final int brickWidth = 30;
    private final int brickHeight = 10;

    static final int DELAY = 75;

    private int ballYVelocity = 5;
    private int ballXVelocity = 5;

    private static final int SCREEN_WIDTH = 400;
    private static final int SCREEN_HEIGHT = 300;

    ArrayList<JLabel> bricksArray = new ArrayList<JLabel>();
    private final int bricksArraySize = 30;
    private int bottomLayerStartingPosY = 32;
    private int bottomLayerStartingPosX = 20;

    public SecondLevel() {

        super("Level 2");
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setBackground(Color.black);  

        //Bottom Layer Red Blocks
        for (int i = 0; i < 10; i++) {

            redBricks = new RedBricks();
            bricksArray.add(redBricks);

            add(bricksArray.get(i));
            bricksArray.get(i).setBounds(bottomLayerStartingPosX, bottomLayerStartingPosY, brickWidth, brickHeight);
            
            bottomLayerStartingPosX += 36;
        }
        bottomLayerStartingPosY += 16;
        bottomLayerStartingPosX = 20;

        //Mid Layer Orange Blocks
        for (int i = 10; i < 20; i++) {

            orangeBricks = new OrangeBricks();
            bricksArray.add(orangeBricks);

            add(bricksArray.get(i));
            bricksArray.get(i).setBounds(bottomLayerStartingPosX, bottomLayerStartingPosY, brickWidth, brickHeight);
            
            bottomLayerStartingPosX += 36;
        }
        bottomLayerStartingPosY += 16;
        bottomLayerStartingPosX = 20;

        //Top Layer Red Blocks
        for (int i = 20; i < 30; i++) {

            redBricks = new RedBricks();
            bricksArray.add(redBricks);

            add(bricksArray.get(i));
            bricksArray.get(i).setBounds(bottomLayerStartingPosX, bottomLayerStartingPosY, brickWidth, brickHeight);
            
            bottomLayerStartingPosX += 36;
        }

        ball = new Ball();
        add(ball);

        player = new Player();
        player.addKeyListener(new MovePlayer());
        add(player);

        setVisible(true);

        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MoveBall();
                checkIntersection(ball, bricksArray);
            }

            //Method to automatically move the ball.
            private void MoveBall() {
                
                Point ballPoint = ball.getLocation();
                int ballX = ballPoint.x;
                int ballY = ballPoint.y;                
                
                ball.setLocation(ballX + ballXVelocity, ballY + ballYVelocity);
                
                if (ballPoint.x < 0 || ballPoint.x > 370) {
                    ballXVelocity = -ballXVelocity;
                    ball.setLocation(ballPoint.x + ballXVelocity, ballPoint.y + ballYVelocity);
                }
                if (ballPoint.y < 0 || ballPoint.y > 240) {
                    ballYVelocity = -ballYVelocity;
                    ball.setLocation(ballPoint.x + ballXVelocity, ballPoint.y + ballYVelocity);
                }
            }

            //Method to check intersection.
            private void checkIntersection(JLabel ballObject, ArrayList<JLabel> bricksArray) {

                
                for (int i = 0; i < bricksArraySize; i++) {

                    Rectangle brickObject =  bricksArray.get(i).getBounds();
                    Rectangle result = SwingUtilities.computeIntersection(ballObject.getX(), ballObject.getY(), ballObject.getWidth(), ballObject.getHeight(), brickObject);
                    if ( result.getWidth() > 0 && result.getHeight() > 0) {
                        
                        remove(bricksArray.get(i));
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
