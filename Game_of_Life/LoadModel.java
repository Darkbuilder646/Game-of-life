package Game_of_Life;

public class LoadModel {
    public int modelToLoad[][];
    private int modelSize;


    public void setModelToLoad(int[][] modelToLoad) {
        this.modelToLoad = modelToLoad;
        this.modelSize = modelToLoad.length;
    }

    public void load(GameOfLife game) {
        int gridCenterRow = game.getRows() / 2 - modelSize / 2;
        int gridCenterCol = game.getCols() / 2 - modelSize / 2;

        for (int row = 0; row < modelSize; row++) {
            for (int col = 0; col < modelSize; col++) {
                game.setCellState(gridCenterRow + row, gridCenterCol + col, modelToLoad[row][col]);
            }
        }
    }
}
