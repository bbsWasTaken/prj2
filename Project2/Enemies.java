
package Project2;


public abstract class Enemies extends FlyingObjects implements Shootable, Moveable {
    int ammoToKill;
    int hitCount = 0;
    int healthToGain;
    static int baseHealthMultiplier = 10;

    public Enemies(boolean isInfected, int healthToGain, int ammoToKill) {
        super(isInfected);
        this.healthToGain = healthToGain;
        this.ammoToKill = ammoToKill;
    }

    public void move(int direction, int amount) {
        if (direction == 0) {
            int realAmount = this.position.getX() - amount;
            if (realAmount < 1) {
                this.destroyed = true;
            }
            this.position.setX(realAmount);
        } else if (direction == 1) {
            int realAmount = this.position.getX() + amount;
            if (realAmount > Location2D.getDimX()) {
                this.destroyed = true;
            }
            this.position.setX(realAmount);
        }
    }

    @Override
    public void shootMe() {
        hitCount++;
        if (ammoToKill >= hitCount) {
            this.destroyed = true;
        }
    }
}