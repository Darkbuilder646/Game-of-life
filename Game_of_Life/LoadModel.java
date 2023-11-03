package Game_of_Life;

import java.util.Random;

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

    public void setRandomCellToLoad(int[][] randomToLoad, float probability) throws ModelException {
        Random random = new Random();

        if(randomToLoad.length == 0 || randomToLoad[0].length == 0) {
            this.modelToLoad = null;
            throw new ModelException("You haven't set a correct model size");
        }
        
        int rows = randomToLoad.length;
        int cols = randomToLoad[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                float randomValue = random.nextFloat();
                if (randomValue < probability) {
                    randomToLoad[i][j] = 1;
                } else {
                    randomToLoad[i][j] = 0;
                }
            }
        }

        this.modelToLoad = randomToLoad;
        this.modelSizeRows = modelToLoad.length;
        this.modelSizeCols = modelToLoad[0].length;
    }

    public void load(GameOfLife game) throws ModelException {
        int gridCenterRow = game.getRows() / 2 - modelSizeRows / 2;
        int gridCenterCol = game.getCols() / 2 - modelSizeCols / 2;

        if(gridCenterRow < 0 || gridCenterCol < 0 || gridCenterRow + modelSizeRows > game.getRows() || gridCenterCol + modelSizeCols > game.getCols()) {
            this.modelToLoad = null;
            throw new ModelException("This model is to big for the grid, you need a grid of " + (modelSizeRows+2) + " rows and " + (modelSizeCols+2) + " cols minimal.");
        }

        for (int row = 0; row < modelSizeRows; row++) {
            for (int col = 0; col < modelSizeCols; col++) {
                game.setCellState(gridCenterRow + row, gridCenterCol + col, modelToLoad[row][col]);
            }
        }
    }
}
