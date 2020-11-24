package com.arturkorobov;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {
    private JButton button = new JButton("Посчитать");
    private JTextField input1 = new JTextField("", 1);
    private JTextField input2 = new JTextField("", 1);
    private JLabel label1 = new JLabel("Введите сумму счёта: ");
    private JLabel label2 = new JLabel("Введите количество гостей: ");

    public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int screenWidth = screenSize.width;
    public int screenHeight = screenSize.height;

    public GUI () {
        super("Программа");
        this.setBounds((screenWidth / 2) - 360/2, (screenHeight / 2) - 360/2, 360, 360);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(5,1,2,2));
        container.add(label1);
        container.add(input1);
        container.add(label2);
        container.add(input2);

        button.addActionListener(new ButtonEventListener ());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (input1.getText().trim().length() > 0 && input2.getText().trim().length() > 0) {
                showResult();
            } else {
                showError();
            }

        }

        public void showResult() {
            float amount = Float.parseFloat(input1.getText());
            int guestsAmount = Integer.parseInt(input2.getText());

            String text = "";

            text += "Общая сумма чека: " + input1.getText() + "\n";
            text += "Количество гостей: " + input2.getText() + "\n";

            float result = amount / guestsAmount;

            text += "Сумма чека для каждого гостя: " + result + "\n";

            JOptionPane.showMessageDialog(null, text, "Результат", JOptionPane.PLAIN_MESSAGE);
        }

        public void showError() {
            String text = "";

            text += "Ошибка! Введите корректные данные." + "\n";

            JOptionPane.showMessageDialog(null, text, "Результат", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
