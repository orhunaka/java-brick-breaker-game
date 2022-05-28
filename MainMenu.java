import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame {
    
private JButton newGameButton;
private JButton optionsButton;
private JButton scoresButton;
private JButton helpButton;
private JButton aboutButton;
private JButton exitButton;

private static final int SCREEN_WIDTH = 400;
private static final int SCREEN_HEIGHT = 300;

    public MainMenu() {

        super("Arkanoid");
        //setLayout(new GridLayout(6, 1));
        setLayout(new FlowLayout());

        newGameButton = new JButton("New Game");
        add(newGameButton);

        optionsButton = new JButton("Options");
        add(optionsButton);

        scoresButton = new JButton("Scores");
        add(scoresButton);

        helpButton = new JButton("Help");
        add(helpButton);

        aboutButton = new JButton("About");
        add(aboutButton);

        exitButton = new JButton("Exit");
        add(exitButton);

        ButtonHandler handler = new ButtonHandler();
        newGameButton.addActionListener(handler);
        helpButton.addActionListener(handler);
        aboutButton.addActionListener(handler);
        exitButton.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == exitButton) {
               
                System.exit(0);

            } else if (event.getSource() == aboutButton) {

                JOptionPane.showMessageDialog(null, "This is an Arkanoid game.", "About", JOptionPane.PLAIN_MESSAGE);
            } else if (event.getSource() == helpButton) {

                JOptionPane.showMessageDialog(null, "Press the right and the left arrows keys to move the bar.\nBreak as many points as you can to get the most points.", "About", JOptionPane.PLAIN_MESSAGE);
            } else if (event.getSource() == newGameButton) {

                JOptionPane.showMessageDialog(null, "The game is about to begin. Break all the bricks to get to the next level. Good luck.");

                JFrame firstLevel = new JFrame();
                firstLevel.setLocationRelativeTo(null);
                firstLevel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                firstLevel.setTitle("Level 1");
                firstLevel.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
                firstLevel.setBackground(Color.black);

                FirstLevel firstLevelPanel = new FirstLevel();
                firstLevel.add(firstLevelPanel);

                firstLevel.setVisible(true);
            }
        }
    }
}
