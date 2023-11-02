package Game_of_Life;

public class GameOfLife {
    private int [][] gameGrid;
    private int rows;
    private int cols;

    public GameOfLife(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.gameGrid = new int[rows][cols];
    }

    public void update() {
        //Todo update the grid by folowing the cell rules
    }

    public void display() {
        //Todo Show the grid with graphique interface
        //? For now, I will show in the console
        DebugConsole.render(gameGrid);
    }

    //#region //* Getter & Setter
    public void setCellState(int row, int col, int state) {
        if (row >= 0 && row < gameGrid.length && col >= 0 && col < gameGrid[0].length) {
            gameGrid[row][col] = state;
        }
    }

    public int getCellState(int row, int col) {
        if (row >= 0 && row < gameGrid.length && col >= 0 && col < gameGrid[0].length) {
            return gameGrid[row][col];
        }
        return 0; //? Default is a dead cell
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
    //#endregion
}
