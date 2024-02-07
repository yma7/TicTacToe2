import javax.swing.*;
import java.awt.*;

import static javax.print.attribute.standard.Chromaticity.COLOR;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    private TicTacToe t1;
    private Square[][] board;
    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToe tic) {
        this.row = row;
        this.col = col;
        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
        t1 = tic;

    }

    public void draw(Graphics g, int boxsize, int x, int y, TicTacToeViewer t)
    {
        g.setColor(Color.black);
        g.drawRect(x,y, boxsize, boxsize);
        Image o = new ImageIcon("Resources/O.png").getImage();
        Image X = new ImageIcon("Resources/X.png").getImage();

        if (isWinningSquare)
        {
            g.setColor(Color.green);
            g.fillRect(x,y,boxsize,boxsize);
        }

        if (marker.equals(TicTacToe.X_MARKER))
        {
            g.drawImage(X, x, y, boxsize, boxsize, t);
        }
        else if (marker.equals(TicTacToe.O_MARKER))
        {
            g.drawImage(o, x, y, boxsize, boxsize, t);
        }

        if (t1.getWinner().equals(TicTacToe.O_MARKER) && t1.checkWin() && t1.getGameOver())
        {
            g.setColor(Color.black);
            g.drawString("O WINS!", 300,500);
        }
        else if (t1.getWinner().equals(TicTacToe.X_MARKER) && t1.checkWin() && t1.getGameOver())
        {
            g.setColor(Color.black);
            g.drawString("X WINS!", 300,500);
        }
        else if (t1.checkTie() && t1.getGameOver())
        {
            g.setColor(Color.black);
            g.drawString("IT'S A TIE!", 300,500);
        }

    }
    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }



    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    public boolean checkSquare(int row, int col)
    {
        return board[row][col] == null;
    }
    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    public Square getMarker(int row, int col)
    {
        return board[row][col];
    }
    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }
}
