
package Project2;

public class IHaveNoBulletsException extends Exception {
    public IHaveNoBulletsException() {
        super("Not enough bullets.");
    }
}
