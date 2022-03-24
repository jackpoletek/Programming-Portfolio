package NumbersView;

import javax.swing.*;
import java.awt.event.ActionListener;

public class NumbersView extends JFrame{

    // VIEW is responsible for the interface

    private JTextField firstUserNum = new JTextField(10);
    private JTextField secondUserNum = new JTextField(10);
    private JButton showCompNumsButton = new JButton("Show computer numbers");
    private JTextField firstCompNumber = new JTextField(10);
    private JTextField secondCompNumber = new JTextField(10);

    public NumbersView() {

        JPanel numPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 300);

        numPanel.add(firstUserNum);
        numPanel.add(secondUserNum);
        numPanel.add(showCompNumsButton);
        numPanel.add(firstCompNumber);
        numPanel.add(secondCompNumber);

        this.add(numPanel);
    }

    public int getFirstNumber() {
        return Integer.parseInt(firstUserNum.getText());
    }
    public int getSecondNumber() {
        return Integer.parseInt(secondUserNum.getText());
    }

    public void setFirstCompNumber(int compNum1) {
        firstCompNumber.setText(Integer.toString(compNum1));
    }
    public void setSecondCompNumber(int compNum2) {
        secondCompNumber.setText(Integer.toString(compNum2));
    }

    public void addNumberListener(ActionListener listenForNumbers) {
        showCompNumsButton.addActionListener(listenForNumbers);
    }

    // WILL USE LATER
    /*void displayErrorMessage(String error) {
        JOptionPane.showMessageDialog(this, error);
    }*/
}
