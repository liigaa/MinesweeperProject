import javax.swing.*;
import java.awt.*;

public class Board {
    private static JFrame frame;
    private static String title;

    public Board(int width, int height, int gridcount, String title, Game game){
        Board.title = title;
        frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



}
