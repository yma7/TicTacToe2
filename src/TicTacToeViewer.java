import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {

    public final int height = 600,  width = 600, XOFFSET = 100, YOFFSET = 100,
            titleheight = 50, boxsize = 100;

    private Square[][] board;

    // TODO: Complete this class

    public TicTacToeViewer(Square[][] board)

    {
        this.board = board;
        this.setSize(height, width);
        this.setTitle("kavan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public void paint (Graphics g)
    {
        boolean isWinningSquare;
        int boxdiff = boxsize / 3;
        g.setFont(new Font("Serif", Font.PLAIN, 30));
        g.setColor(Color.RED);
        for (int i = 0; i < 3; i++)
        {
            g.setColor(Color.RED);
            String num = i + "";
            g.drawString(num, (boxsize * (i + 1) + XOFFSET/2), YOFFSET - 20);
            for (int j = 0; j < 3; j++)
            {
                int x = XOFFSET + j * boxsize;
                int y = YOFFSET + i * boxsize;
                g.drawString(num, XOFFSET - x + 55, y + 55);
                board[i][j].draw(g, boxsize, x,y, this);
            }
        }

    }
}

