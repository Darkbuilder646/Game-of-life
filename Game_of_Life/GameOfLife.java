package Game_of_Life;

public class GameOfLife {
    private int[][] gameGrid;
    private int rows;
    private int cols;
    private int nbrGeneration;

    public GameOfLife(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.gameGrid = new int[rows][cols];
        this.nbrGeneration = 0;
    }

    public void update() {
        int[][] newGrid = new int[gameGrid.length][gameGrid[0].length];

        for (int row = 0; row < gameGrid.length; row++) {
            for (int col = 0; col < gameGrid[0].length; col++) {
                int liveNeighbors = countLiveCellNeighbors(row, col);

                if (gameGrid[row][col] == 1) {
                    // ? The cell is alive
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        // ? The cell die (underpopulation or overpopulation)
                        newGrid[row][col] = 0;
                    } else {
                        // ? The cell stays alive
                        newGrid[row][col] = 1;
                    }
                } else {
                    // ? The Cell is dead
                    if (liveNeighbors == 3) {
                        //? A new cell is born
                        newGrid[row][col] = 1;
                    }
                }
            }
        }
        gameGrid = newGrid;
        nbrGeneration++;
    }

    public int countLiveCellNeighbors(int row, int col) {

        int liveNeighborsCell = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;
                int neighborRow = row + i;
                int neighborCol = col + j;

                if (neighborRow >= 0 && neighborRow < gameGrid.length &&
                        neighborCol >= 0 && neighborCol < gameGrid[0].length) {
                    if (gameGrid[neighborRow][neighborCol] == 1) {
                        liveNeighborsCell++;
                    }
                }
            }
        }

        return liveNeighborsCell;
    }

    public void display() {
        // Todo Show the grid with graphique interface
        // ? For now, I will show in the console
        DebugConsole.render(gameGrid, nbrGeneration);
    }

    // #region //* Getter & Setter
    public void setCellState(int row, int col, int state) {
        if (row >= 0 && row < gameGrid.length && col >= 0 && col < gameGrid[0].length) {
            gameGrid[row][col] = state;
        }
    }

    public int getCellState(int row, int col) {
        if (row >= 0 && row < gameGrid.length && col >= 0 && col < gameGrid[0].length) {
            return gameGrid[row][col];
        }
        return 0; // ? Default is a dead cell
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
    // #endregion
}
