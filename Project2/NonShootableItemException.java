
package Project2;

public class NonShootableItemException extends Exception {
    public NonShootableItemException() {
        super("Item is not shootable.");
    }
}

