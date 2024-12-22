package memorygame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;

public class MemoryGameS extends JFrame {

    static String files[] = {"Batman.jpg", "Superman.jpg",
            "Flash.jpg", "Robin.jpg",
            "Watchman.jpg", "GLantern.jpg"};
    static JButton buttons[];
    ImageIcon closedIcon;
    int numButtons;
    ImageIcon icons[];
    Timer myTimer;

    public MemoryGameS() {
        // Set the title.

        setTitle("Memory Game S");

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a BorderLayout manager.
        setLayout(new GridLayout(2, files.length));

        closedIcon = new ImageIcon("Back.jpg");
        numButtons = files.length * 2;
        buttons = new JButton[numButtons];
        icons = new ImageIcon[numButtons];
        for (int i = 0, j = 0; i < files.length; i++) {
            icons[j] = new ImageIcon(files[i]);
            buttons[j] = new JButton("");
            buttons[j].addActionListener(new ImageButtonListener());
            buttons[j].setIcon(closedIcon);
            add(buttons[j++]);

            icons[j] = icons[j - 1];
            buttons[j] = new JButton("");
            buttons[j].addActionListener(new ImageButtonListener());
            buttons[j].setIcon(closedIcon);
            add(buttons[j++]);
        }

        // Pack and display the window.
        pack();
        setVisible(true);

        myTimer = new Timer(1000, new TimerListener());
        // myTimer.start();
    }

    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        }
    }

    private class ImageButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < numButtons; i++) {
                if (e.getSource() == buttons[i]) {
                    buttons[i].setIcon(icons[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        new MemoryGame();
    }
}