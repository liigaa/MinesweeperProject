import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends JButton {
    private int position;
    private int type; // TYPES -- 0: Empty, 1: Mine, 2: Number
    private boolean uncovered;
    private boolean flagged;

    public Cell (int type, int position, boolean uncovered, boolean flagged) {
        this.type = type;
        this.position = position;
        this.uncovered = uncovered;
        this.flagged = flagged;

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)) {
                    rightClickButton();
                } else {
                    clickButton();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public int getType() {
        return type;
    }

    public int getPosition() {
        return position;
    }

    public boolean isUncovered() {
        return uncovered;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setUncovered(boolean uncovered) {
        this.uncovered = uncovered;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }
    public  void clickButton() {

    }
    public void  rightClickButton() {

    }
}
