package my.tic.tac.toe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe {
    private JPanel windowContent;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JLabel southLabel;
    private JLabel scoreVictory;
    private JLabel scoreLoss;
    private JButton newGameButton;
    private JButton[] squares;
    public int emptySquaresLeft = 9;
    private JLabel countVictory;
    private JLabel countLoss;

    TicTacToe() {
        createPanel();
        createLayout();
        createButton();
        createFrame();
    }

    private void createPanel() {
        windowContent = new JPanel();
        windowContent.setBackground(Color.CYAN);
        northPanel = new JPanel();
        northPanel.setBackground(Color.CYAN);
        centerPanel = new JPanel();
        southLabel = new JLabel("Your turn!");
        scoreVictory = new JLabel("Victory:");
        scoreLoss = new JLabel("Loss:");
        countVictory = new JLabel("0");
        countLoss = new JLabel("0");
    }

    private void createLayout() {
        BorderLayout border = new BorderLayout();
        windowContent.setLayout(border);
        windowContent.add(northPanel, "North");
        windowContent.add(centerPanel, "Center");
        windowContent.add(southLabel, "South");
        GridLayout grid = new GridLayout(3,3);
        centerPanel.setLayout(grid);

    }

    private void createButton() {
        TicTacToeEngine engine = new TicTacToeEngine(this);
        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(engine);
        northPanel.add(newGameButton);
        northPanel.add(scoreVictory);
        northPanel.add(countVictory);
        northPanel.add(scoreLoss);
        northPanel.add(countLoss);
        squares = new JButton[emptySquaresLeft];
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new JButton();
            squares[i].addActionListener(engine);
            squares[i].setBackground(Color.ORANGE);
            centerPanel.add(squares[i]);
        }
    }

    private void createFrame() {
        JFrame frame = new JFrame("TicTacToe");
        frame.setContentPane(windowContent);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public JLabel getCountVictory() {
        return countVictory;
    }

    public JLabel getCountLoss() {
        return countLoss;
    }

    public JLabel getSouthLabel() {
        return southLabel;
    }

    public JButton getNewGameButton() {
        return newGameButton;
    }


    public JButton[] getSquares() {
        return squares;
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
