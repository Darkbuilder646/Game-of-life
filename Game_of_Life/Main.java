package Game_of_Life;

import Game_of_Life.Exception.ModelException;
//Model
import Game_of_Life.Model.GliderModel;
import Game_of_Life.Model.StillLifeModel;

public class Main {
    // private boolean isGameRunning = false;
    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife(10, 10);
        
        LoadModel loader = new LoadModel();
        loader.setModelToLoad(StillLifeModel.beehive); //* Choose here the model to load
        
        try {
            loader.load(gameOfLife);
        } catch (ModelException e) {
            System.out.println("Model size error : " + e.getMessage());
        }

        gameOfLife.display();
    }
}
