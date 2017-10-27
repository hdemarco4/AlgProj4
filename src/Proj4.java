import java.util.ArrayList;
import java.util.Scanner;

public class Proj4 {

    public static void main(String[] args){
        ArrayList x = new ArrayList();
        ArrayList y = new ArrayList();


        System.out.print("How many values: ");
        int v = new Scanner(System.in).nextInt();

        System.out.print("Enter the values in order and hit enter. Then hit q and enter again. : ");
        Scanner l = new Scanner(System.in);

        while(l.hasNextInt()){
            x.add(l.nextInt());
        }

        gridBuilder(x, y);





        System.out.println(x);
        System.out.print("Choose first or last (F or L): ");
        String c = new Scanner(System.in).next();


    }

    public static void gridBuilder(ArrayList x, ArrayList y){

        for(int i = 0; i < x.size(); i++){
            for(int j = 0; j <= x.size() ; j++){


            }
        }



    }






}
