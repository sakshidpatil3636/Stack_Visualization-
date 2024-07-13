import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class StackGUI {
    private Stack<String> stack = new Stack<>();
    private JTextField inputField;
    private JPanel stackPanel;

    public StackGUI() {
        JFrame frame = new JFrame("Stack Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        inputField = new JTextField(20);
        JButton pushButton = new JButton("Push");
        JButton popButton = new JButton("Pop");

        pushButton.addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e) {
                String item = inputField.getText();
                if (!item.isEmpty()) {
                    stack.push(item);
                    drawStack();
                }
            }
        });

        popButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                if (!stack.isEmpty()) {
                    stack.pop();
                    drawStack();
                }
            }
        });

        stackPanel = new JPanel();
        stackPanel.setLayout(new BoxLayout(stackPanel, BoxLayout.Y_AXIS));

        frame.add(inputField);
        frame.add(pushButton);
        frame.add(popButton);
        frame.add(stackPanel);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }

    private void drawStack() {
        stackPanel.removeAll();

        for (String item : stack) {
            JLabel label = new JLabel(item);
            stackPanel.add(label);
        }

        stackPanel.revalidate();
        stackPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
           
            public void run() {
                new StackGUI();
            }
        });
    }
}

