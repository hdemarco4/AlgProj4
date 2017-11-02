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

        int m = v-1;
        grid = gridBuilder2(m, grid, v);


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

                if (j < i) {
                    grid[i][j][0] = '-';
                    grid[i][j][1] = '-';
                }
            }

        }
        return grid;
    }

    public static Object[][][] gridBuilder2(int m, Object[][][] grid, int v) {

        try {
                for (int n = v - 1; n >= 0; n--) {
                    if ((int) grid[m - 1][n - 1][0] > (int) grid[m][n][0]) {
                        grid[m - 1][n][0] = grid[m - 1][n - 1][0];
                        grid[m - 1][n][1] = 'F';
                    } else if ((int) grid[m - 1][n - 1][0] < (int) grid[m][n][0]) {
                        grid[m - 1][n][0] = grid[m][n][0];
                        grid[m - 1][n][0] = 'L';
                    }

                }


        } catch (ClassCastException cce) {

        } catch (ArrayIndexOutOfBoundsException aioobe) {

        }catch (NullPointerException npe) {

        }
        
        m--;
        if(m >= 0){
            grid = gridBuilder2(m, grid, v);
        }

        return grid;
    }

}
