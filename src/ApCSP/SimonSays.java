package ApCSP;



import javax.swing.*;
import java.awt.*;
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
    private JLabel label;
    private Timer timer;
    private Timer playerTimer;
    private Timer resetTimer;
    private int count;
    private int timerCount;


    private ArrayList<Integer> pattern;
    private ArrayList<Integer> userPattern;

    public SimonSays() {
        button1.setBackground(new Color(194, 0, 0));
        button2.setBackground(new Color(194, 97, 0));
        button3.setBackground(new Color(194, 162, 0));
        button4.setBackground(new Color(65, 194, 0));
        button5.setBackground(new Color(0, 129, 194));
        button6.setBackground(new Color(194, 0, 194));

        timer = new Timer(1000, (e) -> colorTick());
        playerTimer = new Timer(1000, (e) -> timerLabel());
        resetTimer = new Timer(800, (e) -> resetColors());
        count = 0;
        timerCount = 0;
        pattern = new ArrayList<>();
        userPattern = new ArrayList<>();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPattern.add(1);
            }
        });
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startRound();
                Start.setEnabled(false);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPattern.add(2);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPattern.add(3);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPattern.add(4);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPattern.add(5);
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPattern.add(6);
            }
        });
    }

    public void colorTick() {
        if (count == pattern.size()) {
            timer.stop();
            playerTurn();
        } else {
            if (pattern.get(count) == 1) {
                button1.setBackground(new Color(255, 128, 128));
            } else if (pattern.get(count) == 2) {
                button2.setBackground(new Color(255, 191, 128));
            } else if (pattern.get(count) == 3) {
                button3.setBackground(new Color(255, 234, 128));
            } else if (pattern.get(count) == 4) {
                button4.setBackground(new Color(129, 255, 128));
            } else if (pattern.get(count) == 5) {
                button5.setBackground(new Color(128, 126, 255));
            } else if (pattern.get(count) == 6) {
                button6.setBackground(new Color(255, 128, 255));
            }
            resetTimer.start();
            count++;
        }
    }

    public void resetColors() {
        resetTimer.stop();
        button1.setBackground(new Color(194, 0, 0));
        button2.setBackground(new Color(194, 97, 0));
        button3.setBackground(new Color(194, 162, 0));
        button4.setBackground(new Color(65, 194, 0));
        button5.setBackground(new Color(0, 129, 194));
        button6.setBackground(new Color(194, 0, 194));
    }
    public void startRound() {
        pattern.add((int) (Math.floor(Math.random() * 6.0) + 1));
        count = 0;
        timer.start();
    }

    public void playerTurn() {
        userPattern = new ArrayList<>();
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        timerCount = 5+pattern.size();
        label.setText("Time Left: " + timerCount);
        playerTimer.start();
    }

    public void timerLabel() {
        timerCount -= 1;
        label.setText("Time Left: " + timerCount);
        if (pattern.size() == userPattern.size() || timerCount == 0) {
            playerTimer.stop();
            roundOver(userPattern.size() != pattern.size());
        }
    }
    
    public void roundOver(boolean isSameLength) {
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        Boolean isSame = true;
        if (isSameLength) {
            gameOver();
        } else {
            for (int i = 0; i < pattern.size(); i++) {
                if (pattern.get(i) != userPattern.get(i)) {
                    isSame = false;
                }
            }
            if (isSame) {
                label.setText("Correct!");
                startRound();
            } else {
                gameOver();
            }
        }
    }

    public void gameOver() {
        label.setText("Game Over, Score: " + (pattern.size()-1));
        pattern = new ArrayList<>();
        userPattern = new ArrayList<>();
        Start.setEnabled(true);
    }

    public static void main(String[] args) {
        var frame = new JFrame("Calculator");
        frame.setContentPane(new SimonSays().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
