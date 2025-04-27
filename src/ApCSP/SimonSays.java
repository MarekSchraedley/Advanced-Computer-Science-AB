package ApCSP;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SimonSays {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton Start;
    private JPanel MainPanel;
    private Timer timer;

    private ArrayList<Integer> pattern;

    public SimonSays() {
        timer = new Timer(1000, (e) -> timer.stop());
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
                Start.setEnabled(false);
            }
        });
    }

    public void colorTick() {
        for (int i = 0; i < pattern.size(); i++) {
            if (pattern.get(i) == 1) {
            }
        }
    }
    public void startGame() {
        pattern.add((int) (Math.floor(Math.random()*6.0)+1));
        colorTick();
    }

    public static void main(String[] args) {
        var frame = new JFrame("Calculator");
        frame.setContentPane(new SimonSays().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
