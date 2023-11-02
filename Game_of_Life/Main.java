package Game_of_Life;

import Game_of_Life.Model.GliderModel;

public class Main {
    // private boolean isGameRunning = false;
    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife(10, 10);
        
        LoadModel loader = new LoadModel();
        loader.setModelToLoad(GliderModel.glider); //* Choose here the model to load
        loader.load(gameOfLife);

        gameOfLife.display();
    }
}
