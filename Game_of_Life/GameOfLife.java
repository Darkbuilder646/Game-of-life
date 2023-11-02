package Game_of_Life;

public class GameOfLife {
    private int [][] gameGrid;
    private int row;
    private int col;

    public GameOfLife(int row, int col) {
        this.row = row;
        this.col = col;
        this.gameGrid = new int[row][col];
    }

    public void update() {
        //Todo update the grid by folowing the cell rules
    }

    public void display() {
        //Todo Show the grid with graphique interface
        DebugConsole.render(gameGrid);
    }
}
