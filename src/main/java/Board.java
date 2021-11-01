import javax.swing.*;
import java.awt.*;

public class Board {
    private static JFrame frame;
    private static String title;

    public Board(int width, int height, int gridCount, String title, Handler handler){
        Board.title = title;
        frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new Grid(new GridLayout(gridCount, gridCount), handler);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public static void update(int flagged){
        frame.setTitle(title + " Mines: "+ Game.MINECOUNT + " - Flags: " + flagged);
    }
}
