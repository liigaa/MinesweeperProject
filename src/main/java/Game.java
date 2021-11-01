public class Game {

    public static final int WIDTH=720, HEIGHT=720;
    public static final int GRIDCOUNT = 16;
    public static final int MINECOUNT = 40;



    public static void main(String[] args) {
        new Game();
    }
    public Game(){
        Handler handler = new Handler();
        new Board(WIDTH, HEIGHT, GRIDCOUNT, "Minesweeper", handler);
        Board.update(0);
    }
}
