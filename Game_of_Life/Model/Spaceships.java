package Game_of_Life.Model;

public class Spaceships {
    
    public static int[][] glider = {
            { 0, 1, 0 },
            { 0, 0, 1 },
            { 1, 1, 1 }
    };

    public static int[][] gliderGun = {
        //Todo Model for Glider Gun
    };

    public static int[][] lightSpaceship = {
            { 0, 0, 1, 1, 0 },
            { 1, 1, 0, 1, 1 },
            { 1, 1, 1, 1, 0 },
            { 0, 1, 1, 0, 0 }

    };
}