package Game_of_Life;

import Game_of_Life.Exception.ModelException;

public class LoadModel {
    public int modelToLoad[][];
    private int modelSizeRows;
    private int modelSizeCols;


    public void setModelToLoad(int[][] modelToLoad) {
        this.modelToLoad = modelToLoad;
        this.modelSizeRows = modelToLoad.length;
        this.modelSizeCols = modelToLoad[0].length;
    }

    public void load(GameOfLife game) throws ModelException {
        int gridCenterRow = game.getRows() / 2 - modelSizeRows / 2;
        int gridCenterCol = game.getCols() / 2 - modelSizeCols / 2;

        if(gridCenterRow < 0 || gridCenterCol < 0 || gridCenterRow + modelSizeRows > game.getRows() || gridCenterCol + modelSizeCols > game.getCols()) {
            this.modelToLoad = null;
            throw new ModelException("This model is to big for the grid");
        }

        for (int row = 0; row < modelSizeRows; row++) {
            for (int col = 0; col < modelSizeCols; col++) {
                game.setCellState(gridCenterRow + row, gridCenterCol + col, modelToLoad[row][col]);
            }
        }
    }
}
