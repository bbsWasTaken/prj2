
package Project2;


public abstract class Item {
    
    Location2D position;
    boolean destroyed = false;


    public Item() {
        this.position = new Location2D();
    }
    
    public Location2D getPos() {
        return position;
    }
}

