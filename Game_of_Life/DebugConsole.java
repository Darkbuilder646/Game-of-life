package Game_of_Life;

public class DebugConsole {
    public static void render(int[][] grid) {
        //Todo Display grid in console with 0 and 1

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    System.out.print("O "); //? Alive Cell
                } else {
                    System.out.print(". "); //? Dead Cell
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
