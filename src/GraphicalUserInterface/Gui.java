package GraphicalUserInterface;

import BusinessLogic.*;
import DataModels.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame{

    private JTextField input1;
    private JTextField input2;
    private JTextField output;
    private JLabel labelInput1 = new JLabel("Input 1:");
    private JLabel labelInput2 = new JLabel("Input 2:");
    private JLabel labelResult = new JLabel("Result :");
    private JPanel panel = new JPanel();
    private JButton[] buttons = new JButton[8];
    private Font font = new Font("San Francisco", Font.BOLD, 20);

    Polynomial in1;
    Polynomial in2;
    String result;
    public Gui(){
        this.setName("Polynomial Calculator");
        this.setSize(420, 550);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.setResizable(false);
        this.setLayout(null);

        input1 = new JTextField();
        input1.setBounds(125, 25, 250, 50);
        input1.setFont(font);

        input2 = new JTextField();
        input2.setBounds(125, 85, 250, 50);
        input2.setFont(font);

        output = new JTextField();
        output.setBounds(125, 145, 250, 50);
        //output.setFont(font);
        output.setEditable(false);

        labelInput1.setBounds(10, 25, 100, 50);
        labelInput1.setFont(font);
        this.add(labelInput1);
        this.add(input1);

        labelInput2.setBounds(10, 85, 100, 50);
        labelInput2.setFont(font);
        this.add(labelInput2);
        this.add(input2);

        labelResult.setBounds(10, 145, 100, 50);
        labelResult.setFont(font);
        this.add(labelResult);
        this.add(output);

        panel.setBounds(50, 220, 300, 270);
        panel.setLayout(new GridLayout(4, 2));
        //panel.setBackground(Color.gray);
        buttons[0] = new JButton("+");
        buttons[1] = new JButton("-");
        buttons[2] = new JButton("*");
        buttons[3] = new JButton("/");
        buttons[4] = new JButton("INT");
        buttons[5] = new JButton("CLR");
        buttons[6] = new JButton("DER");
        buttons[7] = new JButton("USE");

        for(JButton b : buttons){
            b.setFont(font);
            b.setFocusable(false);
            panel.add(b);
        }

        buttons[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                in1 = new Polynomial(input1.getText());
                in2 = new Polynomial(input2.getText());
                result = new AdditionNSubtraction(in1, in2, '+').getResult();
                output.setText(result);
            }
        });

        buttons[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                in1 = new Polynomial(input1.getText());
                in2 = new Polynomial(input2.getText());
                result = new AdditionNSubtraction(in1, in2, '-').getResult();
                output.setText(result);
            }
        });

        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                in1 = new Polynomial(input1.getText());
                in2 = new Polynomial(input2.getText());
                result = new Multiply(in1, in2).getResult();
                output.setText(result);
            }
        });

        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                in1 = new Polynomial(input1.getText());
                in2 = new Polynomial(input2.getText());
                result = new Divide(in1, in2).getResult();
                output.setText(result);
            }
        });

        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                in1 = new Polynomial(input1.getText());
                result = new Integral(in1).getResult();
                output.setText(result);
            }
        });

        buttons[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input1.setText("");
                input2.setText("");
                output.setText("");
                input1.requestFocusInWindow();
            }
        });

        buttons[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                in1 = new Polynomial(input1.getText());
                result = new Derivative(in1).getResult();
                output.setText(result);
            }
        });

        buttons[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input2.setText("");
                output.setText("");
                input1.setText(result);
                input2.requestFocusInWindow();
            }
        });

        this.add(panel);
        this.setVisible(true);

    }
}
