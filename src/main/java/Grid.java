import javax.swing.*;
import java.util.ArrayList;

public class Grid extends JPanel {
    private final ArrayList<Integer> mines=new ArrayList<>();
    public static ArrayList<Cell> cells=new ArrayList<>();
    private boolean picked=false;

    public Grid(){
        createCells();
        addCells();
    }
    public void createCells(){
        int bound = Game.GRIDCOUNT * Game.GRIDCOUNT;
        for (int i = 1; i <= Game.MINECOUNT; i++) {
            while (!picked) {
                int minePosition = (int) (Math.random() * bound);
                if (!mines.contains(minePosition)) {
                    mines.add(minePosition);
                    picked = true;
                }
            }
            picked = false;
        }
        for (int i = 0; i < bound; i++) {
            if (mines.contains(i)) {
                cells.add(new Cell(1, i, false, false));
            } else if (i % Game.GRIDCOUNT == 0) {
                if (mines.contains(i - Game.GRIDCOUNT) ||
                        mines.contains(i - Game.GRIDCOUNT + 1) ||
                        mines.contains(i + 1) ||
                        mines.contains(i + Game.GRIDCOUNT) ||
                        mines.contains(i + Game.GRIDCOUNT + 1)) {
                    cells.add(new Cell(2, i, false, false));
                }
                else {
                    cells.add(new Cell(0, i, false, false));
                }
            } else if (i % Game.GRIDCOUNT == Game.GRIDCOUNT - 1) {
                if (mines.contains(i - Game.GRIDCOUNT - 1) ||
                        mines.contains(i - Game.GRIDCOUNT) ||
                        mines.contains(i - 1) ||
                        mines.contains(i + Game.GRIDCOUNT - 1) ||
                        mines.contains(i + Game.GRIDCOUNT)) {
                    cells.add(new Cell(2, i, false, false));
                } else {
                    cells.add(new Cell(0, i, false, false));
                }
            } else {
                if (mines.contains(i - Game.GRIDCOUNT - 1) ||
                        mines.contains(i - Game.GRIDCOUNT) ||
                        mines.contains(i - Game.GRIDCOUNT + 1) ||
                        mines.contains(i - 1) ||
                        mines.contains(i + 1) ||
                        mines.contains(i + Game.GRIDCOUNT - 1) ||
                        mines.contains(i + Game.GRIDCOUNT) ||
                        mines.contains(i + Game.GRIDCOUNT + 1)) {
                    cells.add(new Cell(2, i, false, false));
                } else {
                    cells.add(new Cell(0, i, false, false));
                }
            }
        }
    }
    private void addCells(){
        for (Cell cell : cells) {
            add(cell);
        }
    }

}
