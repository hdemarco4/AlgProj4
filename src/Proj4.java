import java.util.Scanner;

import static java.lang.Math.abs;

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

    public static Object listSplitter(int[] list, int v){
        int n = 0;
        int o = 0;
        int p = 0;
        for(int m = 0; m < v; m++){
            if(abs(list[m] - list[m+1]) > 0) {
                n = abs(list[m] - list[m + 1]);
                o = m;
                p = m+1;
            }
        }




        return ;
    }

}
