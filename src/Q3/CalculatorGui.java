package Q3;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CalculatorGui {
    private JPanel mainPanel;
    private JButton a7Button;
    private JButton a9Button;
    private JButton a8Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a0Button;
    private JButton buttonAdd;
    private JButton buttonSub;
    private JButton buttonMult;
    private JButton buttonDiv;
    private JButton buttonDot;
    private JButton buttonEquals;
    private JButton cButton;
    private JLabel output;

    private int operatorIndex;

    public CalculatorGui() {
        operatorIndex = -1;
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "1");
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "2");
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "3");
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "4");
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "5");
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "6");
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "7");
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "8");
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "9");
            }
        });
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + "0");
            }
        });

        buttonDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(output.getText() + ".");
            }
        });
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operatorIndex = output.getText().length();
                output.setText(output.getText() + "+");
            }
        });
        buttonSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operatorIndex = output.getText().length();
                output.setText(output.getText() + "-");
            }
        });
        buttonMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operatorIndex = output.getText().length();
                output.setText(output.getText() + "*");
            }
        });
        buttonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operatorIndex = output.getText().length();
                output.setText(output.getText() + "/");
            }
        });
        buttonEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(calc(output.getText()));
            }
        });
        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operatorIndex = -1;
                output.setText("");
            }
        });
    }

    public String calc(String input) {
        try {
            Double firstDigit = Double.parseDouble(input.substring(0, operatorIndex));
            Double secondDigit = Double.parseDouble(input.substring(operatorIndex+1));
            String operation = input.substring(operatorIndex, operatorIndex+1);
            if (operation.equals("+")) {
                return Double.toString(firstDigit + secondDigit);
            } else if (operation.equals("-")) {
                return Double.toString(firstDigit - secondDigit);
            } else if (operation.equals("*")) {
                return Double.toString(firstDigit * secondDigit);
            } else if (operation.equals("/")) {
                return Double.toString(firstDigit / secondDigit);
            } else {
                return "Error";
            }
        } catch (Exception e) {
            return "Error";
        }
    }

    public static void main(String[] args) {
        var frame = new JFrame("Calculator");
        frame.setContentPane(new CalculatorGui().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
