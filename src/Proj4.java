import java.util.Scanner;

public class Proj4 {

    public static void main(String[] args) {

        System.out.print("How many values: ");
        int v = new Scanner(System.in).nextInt();

        Scanner l = new Scanner(System.in);
        int[] list = new int[v];


        for (int k = 0; k < v; k++) {
            System.out.println("Enter a number: ");
            list[k] = l.nextInt();
        }

        Object[][][] grid = new Object[v][v][2];
        grid = gridBuilder1(list, grid, v);

        grid = gridBuilder2(list, grid, v);


        for (Object[][] x : grid) {
            for (Object[] y : x) {
                for (Object z : y) {
                    System.out.print(z + " ");
                }

            }
            System.out.println();
        }


        for (int a = 0; a < v; a++)
            System.out.print(list[a]);

        System.out.println("");
        System.out.print("Choose first or last (F or L): ");
        String c = new Scanner(System.in).next();

    }

    public static Object[][][] gridBuilder1(int[] list, Object[][][] grid, int v) {

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {

                if (i == j) {
                    grid[i][j][0] = list[i];
                    grid[i][j][1] = 'F';
                }
                else if (j < i) {
                    grid[i][j][0] = '-';
                    grid[i][j][1] = '-';
                }
                else if(j > i){
                    grid[i][j][0] = 0;
                    grid[i][j][1] = '-';
                }
            }
        }
        return grid;
    }

    public static Object[][][] gridBuilder2(int[] list, Object[][][] grid, int v) {

        for(int k = 1; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if(i + 1 == j){
                        if ((int) grid[i][j - 1][0] >= (int) grid[i + 1][j][0]) {
                            grid[i][j][0] = list[j-1];
                            grid[i][j][1] = 'F';
                        } else if ((int) grid[i][j - 1][0] < (int) grid[i + 1][j][0]) {
                            grid[i][j][0] = list[i+1];
                            grid[i][j][1] = 'L';
                        }
                    }

                    else if (i + k == j) {
                        if ((int) grid[i][j - 1][0] >= (int) grid[i + 1][j][0]) {
                            grid[i][j][0] = (int) grid[i][j - 1][0] + list[j-1];
                            grid[i][j][1] = 'F';
                        } else if ((int) grid[i][j - 1][0] < (int) grid[i + 1][j][0]) {
                            grid[i][j][0] = (int) grid[i + 1][j][0] + list[j-1];
                            grid[i][j][1] = 'L';
                        }
                    }

                }
            }
        }
        return grid;
    }

}
