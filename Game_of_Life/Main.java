package Game_of_Life;

import Game_of_Life.Exception.ModelException;
//Model
import Game_of_Life.Model.Spaceships;
import Game_of_Life.Model.OscillatorsModel;
import Game_of_Life.Model.SmallModel;
import Game_of_Life.Model.StillLifeModel;


public class Main {
    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife(35, 50);
        boolean isGameRunning = true;

        LoadModel loader = new LoadModel();
        int[][] customModel = new int[10][10];
        // loader.setModelToLoad(SmallModel.Small2); // * Choose here the model to load
         
        try {
            loader.setRandomCellToLoad(customModel, (float) 0.35);
        } catch (ModelException e) {
            System.out.println("Model size error : " + e.getMessage());
            isGameRunning = false;
        }

        try {
            loader.load(gameOfLife);
        } catch (ModelException e) {
            System.out.println("Model size error : " + e.getMessage());
            isGameRunning = false;
        }

        while (isGameRunning) {
            gameOfLife.display();

            try {
                Thread.sleep(1000); //? Speed of generation 10000 => 10s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            gameOfLife.update();
        }
    }
}
