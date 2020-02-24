package myTicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeEngine implements ActionListener {
    private TicTacToe ticTacToe;
    private int countVictory;
    private int countLoss;
    TicTacToeEngine(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton square = (JButton) e.getSource();

        if (square == ticTacToe.getNewGameButton()) {
            for (int i = 0; i < 9; i++) {
                ticTacToe.getSquares()[i].setEnabled(true);
                ticTacToe.getSquares()[i].setText("");
                ticTacToe.getSquares()[i].setBackground(Color.ORANGE);
            }
            ticTacToe.emptySquaresLeft = 9;
            ticTacToe.getSouthLabel().setText("Your turn!");
            ticTacToe.getNewGameButton().setEnabled(false);
            return;
        }

        String winner = "";

        for (int i = 0; i < 9; i++) {
            if (square == ticTacToe.getSquares()[i]) {
                if (ticTacToe.getSquares()[i].getText().equals("X")) {
                    break;
                }
                ticTacToe.getSquares()[i].setText("X");
                winner = lookForWinner();
                if (!"".equals(winner)) {
                    endTheGame();
                } else {
                    computerMove();
                    winner = lookForWinner();
                    if (!"".equals(winner)) {
                        endTheGame();
                    }
                }
                break;
            }
        }

        if (winner.equals("X")) {
            ticTacToe.getSouthLabel().setText("You won!");
            ticTacToe.getCountVictory().setText("" + ++countVictory);
        } else if (winner.equals("O")) {
            ticTacToe.getSouthLabel().setText("Yuo lost!");
            ticTacToe.getCountLoss().setText("" + ++countLoss);
        } else if (winner.equals("T")) {
            ticTacToe.getSouthLabel().setText("It's a tie!");
        }
    }

    private String lookForWinner() {
        String theWinner = "";
        ticTacToe.emptySquaresLeft--;

        if (ticTacToe.emptySquaresLeft == 0) {
            return "T";
        }
        if (lookConditionVictory (0, 1, 2)) {
            theWinner = ticTacToe.getSquares()[0].getText();
            highlightWinner(0, 1, 2);
        } else if (lookConditionVictory (3, 4, 5)) {
            theWinner = ticTacToe.getSquares()[3].getText();
            highlightWinner(3, 4, 5);
        } else if (lookConditionVictory (6, 7, 8)) {
            theWinner = ticTacToe.getSquares()[6].getText();
            highlightWinner(6, 7, 8);
        } else if (lookConditionVictory (0, 3, 6)) {
            theWinner = ticTacToe.getSquares()[0].getText();
            highlightWinner(0, 3, 6);
        } else if (lookConditionVictory (1, 4, 7)) {
            theWinner = ticTacToe.getSquares()[1].getText();
            highlightWinner(1, 4, 7);
        } else if (lookConditionVictory (2, 5, 8)) {
            theWinner = ticTacToe.getSquares()[2].getText();
            highlightWinner(2, 5, 8);
        }else if (lookConditionVictory (0, 4, 8)) {
            theWinner = ticTacToe.getSquares()[0].getText();
            highlightWinner(0, 4, 8);
        } else if (lookConditionVictory (2, 4, 6)) {
            theWinner = ticTacToe.getSquares()[2].getText();
            highlightWinner(2, 4, 6);
        }
        return theWinner;
    }
    private boolean lookConditionVictory (int a, int b, int c) {
        return !ticTacToe.getSquares()[a].getText().equals("") &&
                ticTacToe.getSquares()[a].getText().equals(ticTacToe.getSquares()[b].getText()) &&
                ticTacToe.getSquares()[a].getText().equals(ticTacToe.getSquares()[c].getText());
    }

    private void computerMove() {
        int selectedSquare;
        selectedSquare = findEmptySquare("O");

        if (selectedSquare == -1) {
            selectedSquare = findEmptySquare("X");
        }
        if ((selectedSquare == -1) && ticTacToe.getSquares()[4].getText().equals("")) {
            selectedSquare = 4;
        }
        if (selectedSquare == -1) {
            selectedSquare = getRandomSquare();
        }
        ticTacToe.getSquares()[selectedSquare].setText("O");
    }

    private int findEmptySquare(String player) {
        int[] weight = new int[9];

        for (int i = 0; i < 9; i++) {
            if (ticTacToe.getSquares()[i].getText().equals("O")) {
                weight[i] = -1;
            } else if (ticTacToe.getSquares()[i].getText().equals("X")) {
                weight[i] = 1;
            } else {
                weight[i] = 0;
            }
        }

        int twoWeights = player.equals("O") ? -2 : 2;

        if (weight[0] + weight[1] + weight[2] == twoWeights) {
            if (weight[0] == 0) {
                return 0;
            } else if (weight[1] == 0) {
                return 1;
            } else {
                return 2;
            }
        }
        if (weight[3] + weight[4] + weight[5] == twoWeights) {
            if (weight[3] == 0) {
                return 3;
            } else if (weight[4] == 0) {
                return 4;
            } else {
                return 5;
            }
        }
        if (weight[6] + weight[7] + weight[8] == twoWeights) {
            if (weight[6] == 0) {
                return 6;
            } else if (weight[7] == 0) {
                return 7;
            } else {
                return 8;
            }
        }
        if (weight[0] + weight[3] + weight[6] == twoWeights) {
            if (weight[0] == 0) {
                return 0;
            } else if (weight[3] == 0) {
                return 3;
            } else {
                return 6;
            }
        }
        if (weight[1] + weight[4] + weight[7] == twoWeights) {
            if (weight[1] == 0) {
                return 1;
            } else if (weight[4] == 0) {
                return 4;
            } else {
                return 7;
            }
        }
        if (weight[2] + weight[5] + weight[8] == twoWeights) {
            if (weight[2] == 0) {
                return 2;
            } else if (weight[5] == 0) {
                return 5;
            } else {
                return 8;
            }
        }
        if (weight[0] + weight[4] + weight[8] == twoWeights) {
            if (weight[0] == 0) {
                return 0;
            } else if (weight[4] == 0) {
                return 4;
            } else {
                return 8;
            }
        }
        if (weight[2] + weight[4] + weight[6] == twoWeights) {
            if (weight[2] == 0) {
                return 2;
            } else if (weight[4] == 0) {
                return 4;
            } else {
                return 6;
            }
        }
        return -1;
    }

    private int getRandomSquare() {
        boolean gotEmptySquare = false;
        int selectedSquare = -1;
        do {
            selectedSquare = (int)(Math.random() * 9);
            if (ticTacToe.getSquares()[selectedSquare].getText().equals("")) {
                gotEmptySquare = true;
            }
        } while (!gotEmptySquare);
        return selectedSquare;
    }

    private void highlightWinner(int win1, int win2, int win3) {
        ticTacToe.getSquares()[win1].setBackground(Color.CYAN);
        ticTacToe.getSquares()[win2].setBackground(Color.CYAN);
        ticTacToe.getSquares()[win3].setBackground(Color.CYAN);
    }

    private void endTheGame() {
        ticTacToe.getNewGameButton().setEnabled(true);
        for (int i = 0; i < 9; i++) {
            ticTacToe.getSquares()[i].setEnabled(false);
        }
    }
}
