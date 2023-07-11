
package Project2;

public class Armory extends GroundObjects implements Shootable {

    boolean isAmmoCollected = false;
    private int shotNTimes = 0;
    private int numberOfBullets;

    
    public Armory(int numberOfBullets) {
        this.numberOfBullets = numberOfBullets;
    }
    
    private int getNumberOfBullets() {
        return numberOfBullets;
    }

    @Override
    public void shootMe() {
        shotNTimes++;
        if (numberOfBullets / 10 <= shotNTimes) {
            this.destroyed = true;
        }
    }

    public int collectAmmo() throws AmmoAlreadyCollectedException {
        if (!this.isAmmoCollected && this.destroyed) {
            this.isAmmoCollected = true;
            return this.numberOfBullets;
        } else {
            throw new AmmoAlreadyCollectedException();
        }
    }
}