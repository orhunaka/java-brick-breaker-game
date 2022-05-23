import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        
        MainMenu mainMenu = new MainMenu();
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setSize(150, 250);
        mainMenu.setLocationRelativeTo(null);
        mainMenu.setVisible(true);
    }
}