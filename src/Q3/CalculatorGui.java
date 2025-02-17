package Q3;
import javax.swing.*;
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

    public CalculatorGui() {

    }

    public static void main(String[] args) {
        var frame = new JFrame("Calculator");
        frame.setContentPane(new CalculatorGui().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
