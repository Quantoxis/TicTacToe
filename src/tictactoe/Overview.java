package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author arich
 */
public class Overview implements ActionListener {

    Random r = new Random();
    JFrame frame = new JFrame();
    JPanel titleP = new JPanel();
    JPanel btnP = new JPanel();
    JLabel textField = new JLabel();
    JButton[] btns = new JButton[9];
    boolean player1Turn;

    public Overview() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titleP.setLayout(new BorderLayout());
        titleP.setBounds(0, 0, 800, 100);

        btnP.setLayout(new GridLayout(3, 3, 10, 10));
        btnP.setBackground(new Color(50, 50, 150));

        for (int i = 0; i < 9; i++) {
            btns[i] = new JButton();
            btnP.add(btns[i]);
            btns[i].setBackground(new Color(190, 0, 90));
            btns[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            btns[i].setFocusable(false);
            btns[i].addActionListener(this);
        }

        titleP.add(textField);
        frame.add(titleP, BorderLayout.NORTH);
        frame.add(btnP);

        firstTurn();

    }

    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < 9; i++) {
            if (ae.getSource().equals(btns[i])) {
                if (player1Turn) {
                    if (btns[i].getText() == "") {
                        btns[i].setForeground(new Color(255, 0, 0));
                        btns[i].setText("X");
                        player1Turn = false;
                        textField.setText("O turn");
                        check();
                    }

                } else if (ae.getSource().equals(btns[i])){
                    if (btns[i].getText() == "") {
                        btns[i].setForeground(new Color(0, 0, 255));
                        btns[i].setText("O");
                        player1Turn = true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    void firstTurn() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (r.nextInt(2) == 0) {
            player1Turn = true;
            textField.setText("X turn");
        } else {
            player1Turn = false;
            textField.setText("O turn");
        }
    }

    void check() {
        if (btns[0].getText().equals("X")
                && btns[1].getText().equals("X")
                && btns[2].getText().equals("X")) {
            xWins(0, 1, 2);
        }

        if (btns[3].getText().equals("X")
                && btns[4].getText().equals("X")
                && btns[5].getText().equals("X")) {
            xWins(3, 4, 5);
        }
        if (btns[2].getText().equals("X")
                && btns[5].getText().equals("X")
                && btns[8].getText().equals("X")) {
            xWins(2, 5, 8);
        }
        if (btns[6].getText().equals("X")
                && btns[7].getText().equals("X")
                && btns[8].getText().equals("X")) {
            xWins(6, 7, 8);
        }

        if (btns[0].getText().equals("X")
                && btns[3].getText().equals("X")
                && btns[6].getText().equals("X")) {
            xWins(0, 3, 6);
        }
        if (btns[1].getText().equals("X")
                && btns[4].getText().equals("X")
                && btns[7].getText().equals("X")) {
            xWins(1, 4, 7);
        }
        if (btns[2].getText().equals("X")
                && btns[5].getText().equals("X")
                && btns[8].getText().equals("X")) {
            xWins(2, 5, 8);
        }

        if (btns[2].getText().equals("X")
                && btns[4].getText().equals("X")
                && btns[6].getText().equals("X")) {
            xWins(2, 4, 6);
        }

        if (btns[0].getText().equals("X")
                && btns[4].getText().equals("X")
                && btns[8].getText().equals("X")) {
            xWins(0, 4, 8);
        }

        if (btns[0].getText().equals("O")
                && btns[1].getText().equals("O")
                && btns[2].getText().equals("O")) {
            oWins(0, 1, 2);
        }

        if (btns[3].getText().equals("O")
                && btns[4].getText().equals("O")
                && btns[5].getText().equals("O")) {
            oWins(3, 4, 5);
        }
        if (btns[2].getText().equals("O")
                && btns[6].getText().equals("O")
                && btns[8].getText().equals("O")) {
            oWins(2, 6, 8);
        }
        if (btns[6].getText().equals("O")
                && btns[7].getText().equals("O")
                && btns[8].getText().equals("O")) {
            oWins(6, 7, 8);
        }

        if (btns[0].getText().equals("O")
                && btns[3].getText().equals("O")
                && btns[6].getText().equals("O")) {
            oWins(0, 3, 6);
        }
        if (btns[1].getText().equals("O")
                && btns[4].getText().equals("O")
                && btns[7].getText().equals("O")) {
            oWins(1, 4, 7);
        }
        if (btns[2].getText().equals("O")
                && btns[5].getText().equals("O")
                && btns[8].getText().equals("O")) {
            oWins(2, 5, 8);
        }

        if (btns[2].getText().equals("O")
                && btns[4].getText().equals("O")
                && btns[6].getText().equals("O")) {
            oWins(2, 4, 6);
        }

        if (btns[0].getText().equals("O")
                && btns[4].getText().equals("O")
                && btns[8].getText().equals("O")) {
            oWins(0, 4, 8);
        }

    }

    void xWins(int a, int b, int c) {
        btns[a].setBackground(Color.GREEN);
        btns[b].setBackground(Color.GREEN);
        btns[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            btns[i].setEnabled(false);

        }
        textField.setText("X Wins");
    }

    void oWins(int a, int b, int c) {
        btns[a].setBackground(Color.GREEN);
        btns[b].setBackground(Color.GREEN);
        btns[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            btns[i].setEnabled(false);

        }
        textField.setText("O Wins");

    }
}
