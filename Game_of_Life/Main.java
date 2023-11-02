package Game_of_Life;

import Game_of_Life.Exception.ModelException;
//Model
import Game_of_Life.Model.Spaceships;
import Game_of_Life.Model.OscillatorsModel;
import Game_of_Life.Model.StillLifeModel;


public class Main {
    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife(25, 25);

        LoadModel loader = new LoadModel();
        loader.setModelToLoad(OscillatorsModel.pulsar); // * Choose here the model to load
        
        boolean isGameRunning = true;
        try {
            loader.load(gameOfLife);
        } catch (ModelException e) {
            System.out.println("Model size error : " + e.getMessage());
            isGameRunning = false;
        }


        while (isGameRunning) {
            gameOfLife.display();

            try {
                Thread.sleep(500); //? Speed of generation 10000 => 10s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            gameOfLife.update();
        }
    }
}
