package Q3;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CalculatorGui extends JFrame implements ActionListener {
    JPanel mainPanel;
    JButton a7Button;
    JButton a9Button;
    JButton a8Button;
    JButton a4Button;
    JButton a5Button;
    JButton a6Button;
    JButton a1Button;
    JButton a2Button;
    JButton a3Button;
    JButton a0Button;
    JButton buttonAdd;
    JButton buttonSub;
    JButton buttonMult;
    JButton buttonDiv;
    JButton buttonDot;
    JButton buttonEquals;
    JButton cButton;
    JLabel output;

    private int operatorIndex;

    public CalculatorGui() {
        a1Button = new JButton("1");
        a1Button.addActionListener(this);
        add(a1Button);
        a2Button = new JButton();
        a2Button.addActionListener(this);
        add(a2Button);
        a3Button = new JButton();
        a3Button.addActionListener(this);
        add(a3Button);
        a4Button = new JButton();
        a4Button.addActionListener(this);
        add(a4Button);
        a5Button = new JButton();
        a5Button.addActionListener(this);
        add(a5Button);
        a6Button = new JButton();
        a6Button.addActionListener(this);
        add(a6Button);
        a7Button = new JButton();
        a7Button.addActionListener(this);
        add(a7Button);
        a8Button = new JButton();
        a8Button.addActionListener(this);
        add(a8Button);
        a9Button = new JButton();
        a9Button.addActionListener(this);
        add(a9Button);
        a0Button = new JButton();
        a0Button.addActionListener(this);
        add(a0Button);
        buttonAdd = new JButton();
        buttonAdd.addActionListener(this);
        add(buttonAdd);
        buttonSub = new JButton();
        buttonSub.addActionListener(this);
        add(buttonSub);
        buttonDiv = new JButton();
        buttonDiv.addActionListener(this);
        add(buttonDiv);
        buttonMult = new JButton();
        buttonMult.addActionListener(this);
        add(buttonMult);
        buttonDot = new JButton();
        buttonDot.addActionListener(this);
        add(buttonDot);
        buttonEquals = new JButton();
        buttonEquals.addActionListener(this);
        add(buttonEquals);
        cButton = new JButton();
        cButton.addActionListener(this);
        add(cButton);
        output = new JLabel();
        add(output);
    }

    public void actionPerformed(ActionEvent e) {
        String digit = "-1";
        System.out.println(e.getSource());
        if (e.getSource() == a1Button) {digit = "1";}
        if (e.getSource() == a2Button) {digit = "2";}
        if (e.getSource() == a3Button) {digit = "3";}
        if (e.getSource() == a4Button) {digit = "4";}
        if (e.getSource() == a5Button) {digit = "5";}
        if (e.getSource() == a6Button) {digit = "6";}
        if (e.getSource() == a7Button) {digit = "7";}
        if (e.getSource() == a8Button) {digit = "8";}
        if (e.getSource() == a9Button) {digit = "9";}
        if (e.getSource() == a0Button) {digit = "0";}
        if (e.getSource() == buttonDot) {digit = ".";}
        if (!digit.equals("-1")) {
            addDigit(digit);
        }
        if (e.getSource() == buttonAdd) {digit = "+";}
        if (e.getSource() == buttonSub) {digit = "-";}
        if (e.getSource() == buttonMult) {digit = "*";}
        if (e.getSource() == buttonDiv) {digit = "/";}
        if (!digit.equals("-1")) {
            operatorIndex = addDigit(digit);
        }
        if (e.getSource() == buttonEquals) {
            output.setText(calc());
        }
        if (e.getSource() == cButton) {
            output.setText("");
        }
    }
    public int addDigit(String thing) {
        output.setText(output.getText() + "0");
        return output.getText().length()-1;
    }

    public String calc() {
        try {
            String input = output.getText();
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
