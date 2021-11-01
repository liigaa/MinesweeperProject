import java.util.ArrayList;

public class Handler {

    private ArrayList<Cell> current = new ArrayList<Cell>();
    private ArrayList<Cell> flood = new ArrayList<Cell>();

    private static int flaggedCells = 0;

    public void click(Cell cell) {
        int uncoveredCells = 0;
        if (cell.isFlagged()) {
            cell.setEnabled(false);
            cell.setUncovered(true);

            int position = cell.getPosition();
            if (cell.getType() == 0) {
                if (position < Game.GRIDCOUNT) {
                    if (position % Game.GRIDCOUNT == 0) {
                        flood.add(Grid.cells.get(position + Game.GRIDCOUNT));
                        flood.add(Grid.cells.get(position + Game.GRIDCOUNT + 1));
                        flood.add(Grid.cells.get(position + 1));
                    } else if (position % Game.GRIDCOUNT == Game.GRIDCOUNT - 1) {
                        flood.add(Grid.cells.get(position + Game.GRIDCOUNT));
                        flood.add(Grid.cells.get(position + Game.GRIDCOUNT - 1));
                        flood.add(Grid.cells.get(position - 1));
                    } else {
                        flood.add(Grid.cells.get(position + Game.GRIDCOUNT));
                        flood.add(Grid.cells.get(position + Game.GRIDCOUNT + 1));
                        flood.add(Grid.cells.get(position + Game.GRIDCOUNT - 1));
                        flood.add(Grid.cells.get(position + 1));
                        flood.add(Grid.cells.get(position - 1));
                    }
                } else if (position >= Game.GRIDCOUNT * (Game.GRIDCOUNT - 1)) {
                    if (position % Game.GRIDCOUNT == 0) {
                        flood.add(Grid.cells.get(position - Game.GRIDCOUNT));
                        flood.add(Grid.cells.get(position - Game.GRIDCOUNT + 1));
                        flood.add(Grid.cells.get(position + 1));
                    } else if (position % Game.GRIDCOUNT == Game.GRIDCOUNT - 1) {
                        flood.add(Grid.cells.get(position - Game.GRIDCOUNT));
                        flood.add(Grid.cells.get(position - Game.GRIDCOUNT - 1));
                        flood.add(Grid.cells.get(position - 1));
                    } else {
                        flood.add(Grid.cells.get(position - Game.GRIDCOUNT));
                        flood.add(Grid.cells.get(position - Game.GRIDCOUNT + 1));
                        flood.add(Grid.cells.get(position - Game.GRIDCOUNT - 1));
                        flood.add(Grid.cells.get(position + 1));
                        flood.add(Grid.cells.get(position - 1));
                    }
                } else if (position % Game.GRIDCOUNT == 0) {
                    flood.add(Grid.cells.get(position - Game.GRIDCOUNT));
                    flood.add(Grid.cells.get(position + Game.GRIDCOUNT));
                    flood.add(Grid.cells.get(position - Game.GRIDCOUNT + 1));
                    flood.add(Grid.cells.get(position + Game.GRIDCOUNT + 1));
                    flood.add(Grid.cells.get(position + 1));

                } else if (position % Game.GRIDCOUNT == Game.GRIDCOUNT - 1) {
                    flood.add(Grid.cells.get(position - Game.GRIDCOUNT));
                    flood.add(Grid.cells.get(position + Game.GRIDCOUNT));
                    flood.add(Grid.cells.get(position - Game.GRIDCOUNT - 1));
                    flood.add(Grid.cells.get(position + Game.GRIDCOUNT - 1));
                    flood.add(Grid.cells.get(position - 1));
                } else {
                    flood.add(Grid.cells.get(position - Game.GRIDCOUNT));
                    flood.add(Grid.cells.get(position + Game.GRIDCOUNT));
                    flood.add(Grid.cells.get(position - Game.GRIDCOUNT + 1));
                    flood.add(Grid.cells.get(position + Game.GRIDCOUNT + 1));
                    flood.add(Grid.cells.get(position + 1));
                    flood.add(Grid.cells.get(position - Game.GRIDCOUNT - 1));
                    flood.add(Grid.cells.get(position + Game.GRIDCOUNT - 1));
                    flood.add(Grid.cells.get(position - 1));
                }

            } else if (cell.getType() == 2) {
                int minesNearby = 0;
                if (position < Game.GRIDCOUNT) {
                    if (position % Game.GRIDCOUNT == 0) {
                        if (Grid.cells.get(position + Game.GRIDCOUNT).getType() == 1) minesNearby++;
                        if (Grid.cells.get(position + Game.GRIDCOUNT + 1).getType() == 1) minesNearby++;
                        if (Grid.cells.get(position + 1).getType() == 1) minesNearby++;
                    } else if (position % Game.GRIDCOUNT == Game.GRIDCOUNT - 1) {
                        if (Grid.cells.get(position + Game.GRIDCOUNT).getType() == 1) minesNearby++;
                        if (Grid.cells.get(position + Game.GRIDCOUNT - 1).getType() == 1) minesNearby++;
                        if (Grid.cells.get(position - 1).getType() == 1) minesNearby++;
                    } else {
                        if (Grid.cells.get(position + Game.GRIDCOUNT).getType() == 1) minesNearby++;
                        if (Grid.cells.get(position + Game.GRIDCOUNT + 1).getType() == 1) minesNearby++;
                        if (Grid.cells.get(position + Game.GRIDCOUNT - 1).getType() == 1) minesNearby++;
                        if (Grid.cells.get(position + 1).getType() == 1) minesNearby++;
                        if (Grid.cells.get(position - 1).getType() == 1) minesNearby++;
                    }
                } else if (position >= Game.GRIDCOUNT * (Game.GRIDCOUNT - 1)) {
                    if (position % Game.GRIDCOUNT == 0) {
                        if (Grid.cells.get(position - Game.GRIDCOUNT).getType() == 1) minesNearby++;
                        if (Grid.cells.get(position - Game.GRIDCOUNT + 1).getType() == 1) minesNearby++;
                        if (Grid.cells.get(position + 1).getType() == 1) minesNearby++;
                    } else if (position % Game.GRIDCOUNT == Game.GRIDCOUNT - 1) {
                        if (Grid.cells.get(position - Game.GRIDCOUNT).getType() == 1) minesNearby++;
                        if (Grid.cells.get(position - Game.GRIDCOUNT - 1).getType() == 1) minesNearby++;
                        if (Grid.cells.get(position - 1).getType() == 1) minesNearby++;
                    } else {
                        if (Grid.cells.get(position - Game.GRIDCOUNT).getType() == 1) minesNearby++;
                        if (Grid.cells.get(position - Game.GRIDCOUNT + 1).getType() == 1) minesNearby++;
                        if (Grid.cells.get(position - Game.GRIDCOUNT - 1).getType() == 1) minesNearby++;
                        if (Grid.cells.get(position + 1).getType() == 1) minesNearby++;
                        if (Grid.cells.get(position - 1).getType() == 1) minesNearby++;
                    }
                } else if (position % Game.GRIDCOUNT == 0) {
                    if (Grid.cells.get(position - Game.GRIDCOUNT).getType() == 1) minesNearby++;
                    if (Grid.cells.get(position + Game.GRIDCOUNT).getType() == 1) minesNearby++;
                    if (Grid.cells.get(position + Game.GRIDCOUNT + 1).getType() == 1) minesNearby++;
                    if (Grid.cells.get(position - Game.GRIDCOUNT + 1).getType() == 1) minesNearby++;
                    if (Grid.cells.get(position + 1).getType() == 1) minesNearby++;
                } else if (position % Game.GRIDCOUNT == 1) {
                    if (Grid.cells.get(position - Game.GRIDCOUNT).getType() == 1) minesNearby++;
                    if (Grid.cells.get(position + Game.GRIDCOUNT).getType() == 1) minesNearby++;
                    if (Grid.cells.get(position + Game.GRIDCOUNT - 1).getType() == 1) minesNearby++;
                    if (Grid.cells.get(position - Game.GRIDCOUNT - 1).getType() == 1) minesNearby++;
                    if (Grid.cells.get(position - 1).getType() == 1) minesNearby++;
                } else {
                    if (Grid.cells.get(position - Game.GRIDCOUNT).getType() == 1) minesNearby++;
                    if (Grid.cells.get(position + Game.GRIDCOUNT).getType() == 1) minesNearby++;
                    if (Grid.cells.get(position + Game.GRIDCOUNT + 1).getType() == 1) minesNearby++;
                    if (Grid.cells.get(position - Game.GRIDCOUNT + 1).getType() == 1) minesNearby++;
                    if (Grid.cells.get(position + Game.GRIDCOUNT - 1).getType() == 1) minesNearby++;
                    if (Grid.cells.get(position - Game.GRIDCOUNT - 1).getType() == 1) minesNearby++;
                    if (Grid.cells.get(position + 1).getType() == 1) minesNearby++;
                    if (Grid.cells.get(position - 1).getType() == 1) minesNearby++;
                }
                cell.setText(String.valueOf(minesNearby));

            } else if (cell.getType() == 1) {
                for (int x = 0; x < Grid.cells.size(); x++) {
                    Grid.cells.get(x).setEnabled(false);
                    Grid.cells.get(x).setText("");
                    if (Grid.cells.get(x).getType() == 1) {
                        Grid.cells.get(x).setText("M");
                    }
                }
                cell.setText("*");
            }

            for (int x = 0; x < flood.size(); x++) {
                if (!flood.get(x).isUncovered()) {
                    current.add(flood.get(x));
                    flood.get(x).setUncovered(true);
                }
            }
            flood.clear();

            while (!current.isEmpty()) {
                Cell temp = current.get(0);
                current.remove(0);
                temp.clickButton();
            }

            for (int x = 0; x < Grid.cells.size(); x++) {
                if(Grid.cells.get(x).isUncovered()) {
                    uncoveredCells++;
                }
            }

            if(uncoveredCells == Grid.cells.size() - Game.MINECOUNT) {
                for (int x = 0; x < Grid.cells.size(); x++) {
                    if (Grid.cells.get(x).getType() == 1) {
                        Grid.cells.get(x).setEnabled(false);
                        Grid.cells.get(x).setText("M");
                    } else {
                        Grid.cells.get(x).setUncovered(false);
                        Grid.cells.get(x).setText(":D");
                    }
                }
            }
        }
    }
    public void rightClick(Cell cell) {
        if (!cell.isUncovered()) {
            if (!cell.isFlagged()) {
                cell.setFlagged(true);
                cell.setText("F");
                flaggedCells++;
                Board.update(flaggedCells);
            } else {
                cell.setFlagged(false);
                cell.setText("");
                flaggedCells--;
                Board.update(flaggedCells);
            }
        }
    }
}


