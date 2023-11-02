package Game_of_Life.Model;

public class StillLifeModel {

    public static int[][] block = {
            { 1, 1 },
            { 1, 1 }
    };

    public static int[][] beehive = {
            { 0, 1, 1, 0 },
            { 1, 0, 0, 1 },
            { 0, 1, 1, 0 }
    };

    public static int[][] loaf = {
            { 0, 1, 1, 0 },
            { 1, 0, 0, 1 },
            { 0, 1, 0, 1 },
            { 0, 0, 1, 0 }
    };

    public static int[][] boat = {
            { 1, 1, 0 },
            { 1, 0, 1 },
            { 0, 1, 0 }
    };
    
    public static int[][] tub = {
            { 0, 1, 0 },
            { 1, 0, 1 },
            { 0, 1, 0 }
    };
}
