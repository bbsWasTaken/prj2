package Project2;
import java.util.ArrayList;

public class GameDisplay {

    private static char[][] cTrans = new char[Location2D.getDimY()][Location2D.getDimX()];

    public static void display(ArrayList<Item> items, Aircraft ac) {
        create();
        int x, y;
        char pl;
        //Aircrafts position
        cTrans[ac.getPos().getY()][ac.getPos().getX()] = 'A';
        for (Item i : items) {
            x = i.getPos().getX();
            y = i.getPos().getY();
            String iClass = i.getClass().getName();
            //System.out.println("iClass: " + iClass);
            if (!i.destroyed) {
                switch (iClass) {
                    //case "project2.Aircraft": cTrans[y][x] = 'A'; break;
                    case "Project2.Egg":
                        cTrans[y][x] = 'E';
                        break;
                    case "Project2.Duck":
                        cTrans[y][x] = 'D';
                        break;
                    case "Project2.Birdnest":
                        cTrans[y][x] = 'B';
                        break;
                    case "Project2.Pharmacy":
                        cTrans[y][x] = 'P';
                        break;
                    case "Project2.Armory":
                        cTrans[y][x] = 'M'; //Not A since A is aircraft
                        break;
                    case "Project2.Chicken":
                        cTrans[y][x] = 'C';
                        break;
                }
            }else{
                cTrans[y][x] = 'X'; //marked as destroyed
            }
        }
        for (int i = 0; i < Location2D.getDimY(); i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = cTrans.length - 1; i >= 0; i--) {
            for (int j = 0; j < cTrans[i].length; j++) {
                System.out.print(cTrans[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < Location2D.getDimY(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static void create() {
        for (int i = 0; i < cTrans.length; i++) {
            for (int j = 0; j < cTrans[i].length; j++) {
                cTrans[i][j] = '*';
            }
        }
        System.out.println();
        System.out.println("The game board is printed in such a way that,\n"
                + " the objects with max y appear on top row,\n"
                + " the objects having x=0 are on the leftmost column.\n"
                + "i.e., just as the Cartesian Space with x>=0 and y>=0.\n"
                + "Note that, the view becomes transposed 2D array.\n");
    }

}