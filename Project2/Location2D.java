
package Project2;

import java.util.ArrayList;

import java.util.Random;

public class Location2D {

    private static int dimX, dimY;
    private int x;
    private int y;
    private Random rnd = new Random();
    
    public static int getDimX() {
        return dimX;
    }

    public static void setDimXY(int dX, int dY) {
        dimX = dX;
        dimY = dY;
    }

    public static int getDimY() {
        return dimY;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        if (x >= 0 && x < dimX) {
            this.x = x;
        }
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        if (y >= 0 && y < dimY) {
            this.y = y;
        }
    }

    public Location2D() {
        x = rnd.nextInt(dimX);
        y = rnd.nextInt(dimY);
        //System.out.println("x: " + x + " y: " + y);
    }

    public Location2D(int x, int y) {
       if (x >= 0 && x < dimX) 
            this.x = x;        
       else 
           this.x = rnd.nextInt(dimX);
       if (y >= 0 && y < dimY) 
            this.y = y;
        else 
           this.y = rnd.nextInt(dimY);      
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Location2D){
            return this.x==((Location2D) obj).x && this.y == ((Location2D) obj).y;
        }
        return false;
    }
    

}
