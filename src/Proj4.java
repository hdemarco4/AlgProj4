import java.util.Scanner;

public class Proj4 {

    public static void main(String[] args){

        System.out.print("How many values: ");
        int v = new Scanner(System.in).nextInt();

        Scanner l = new Scanner(System.in);
        int[] list = new int[v];


        for(int k = 0; k < v; k++){
            System.out.println("Enter a number: ");
            list[k] = l.nextInt();
        }

        Object[][][] grid = new Object[v][v][2];
        gridBuilder(list, grid, v);


        for (Object[][] x : grid)
        {
            for (Object[] y : x)
            {
                for(Object z : y){
                    System.out.print(z + " ");
                }

            }
            System.out.println();
        }


        for(int a = 0; a < v; a++)
            System.out.print(list[a]);

        System.out.println("");
        System.out.print("Choose first or last (F or L): ");
        String c = new Scanner(System.in).next();

    }

    public static void gridBuilder(int[] list, Object[][][] grid, int v){

        for(int i = 0; i < v; i++){
            for(int j = 0; j < v; j++){

                if(i == j){
                    grid[i][j][0] = list[i];
                    grid[i][j][1] = 'F';
                }

                if(j < i){
                    grid[i][j][0] = '-';
                    grid[i][j][1] = '-';
                }
            }
        }

        for(int m = 0; m < v-1; m++) {
            for (int n = 0; n < v-1; n++) {
                if ((int) grid[m][n][0] > (int) grid[m + 1][n + 1][0]) {
                    grid[m][n + 1][0] = grid[m][n][0];
                    grid[m][n + 1][1] = 'F';
                } else if ((int) grid[m][n][0] < (int) grid[m + 1][n + 1][0]) {
                    grid[m][n + 1][0] = grid[m + 1][n + 1][0];
                    grid[m][n + 1][0] = 'L';
                }

            }
        }
    }






}
