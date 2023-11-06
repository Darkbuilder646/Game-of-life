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
        boolean customLoad = true; //* Set to false for load preset model

        LoadModel loader = new LoadModel();
        

        if (customLoad) {
            int[][] customModel = new int[10][10];

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
        } else {
            loader.setModelToLoad(OscillatorsModel.pulsar); // * Choose here the model to load

            try {
                loader.load(gameOfLife);
            } catch (ModelException e) {
                System.out.println("Model size error : " + e.getMessage());
                isGameRunning = false;
            }
        }

        while (isGameRunning) {
            gameOfLife.display();

            try {
                Thread.sleep(100); // ? Speed of generation 10000 => 10s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            gameOfLife.update();
        }
    }
}
