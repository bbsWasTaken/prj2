
package Project2;

public class AmmoAlreadyCollectedException extends Exception {
    public AmmoAlreadyCollectedException() {
        super("Ammo already collected");
    }
}