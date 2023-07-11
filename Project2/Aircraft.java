
package Project2;


import java.io.Console;
import java.util.ArrayList;

public class Aircraft extends FlyingObjects implements Moveable {

    int healthLevel = 1000;
    int bullets = 100;
    int cureKits = 0;
    boolean pharmacyCard = true;

    public int getHealthLevel() {
        return healthLevel;
    }

    public Aircraft() {
        super(false);
    }

    private void heal(int healAmount) {
        this.healthLevel += healAmount;
    }

    void useCureKit() {
        if (cureKits > 0) {
            cureKits--;
            this.isInfected = false;
        }
    }

    void throwBullet(int direction, ArrayList<Item> items) throws IHaveNoBulletsException {
        if (bullets == 0) {
            throw new IHaveNoBulletsException();
        }
        for (int i = 0; i < items.size(); i++) {
            Item objectToShoot = items.get(i);
            if (objectToShoot.position.getX() == this.position.getX() && ((objectToShoot.position.getY() > this.position.getY() && direction == 1) || (objectToShoot.position.getY() < this.position.getY() && direction == 0)) && objectToShoot instanceof Shootable && !objectToShoot.destroyed) {
                
                ((Shootable) objectToShoot).shootMe();
                if (objectToShoot instanceof Enemies) {
                    int healthToGain = ((Enemies) objectToShoot).healthToGain;
                    heal(healthToGain);
                } else if (objectToShoot instanceof Armory) {
                    Armory armory = ((Armory) objectToShoot);
                    if (armory.destroyed) {
                        try {
                            int ammo = armory.collectAmmo();
                            this.bullets += ammo;
                        } catch (AmmoAlreadyCollectedException err) {
                            System.out.print(err.getMessage());
                        }
                    }

                }
            }
        }

    }

    void checkCollusion(Enemies enemy) {
        if (enemy.position.getX() == this.position.getX() && enemy.position.getY() == this.position.getY() && !enemy.destroyed) {
            enemy.destroyed = true;
            this.isInfected = true;
            if (enemy.isInfected) {
                this.healthLevel -= 10;
            } else {
                this.healthLevel -= 20;
            }
            System.out.println("collusion");
            System.out.println(enemy.destroyed);
            System.out.println(this.isInfected);
        }
    }

    void inflictDamageIfInfected() {
        if (this.isInfected) {
            this.healthLevel -= 10;
        }
    }

    void checkIfAlignedWithPharmacy(Pharmacy pharmacy) {
        if (pharmacy.position.getX() == this.position.getX() && pharmacyCard) {
            pharmacy.getCureKit();
        }
    }

    @Override
    public void move(int direction, int amount) {
        if (direction == 1) {
            int realAmount = this.position.getX() - amount;
            if (realAmount < 0) {
                this.position.setX(0);
            } else {
                this.position.setX(realAmount);
            }

        } else if (direction == 0) {
            int realAmount = this.position.getX() + amount;
            if (realAmount > Location2D.getDimX()) {
                this.position.setX(Location2D.getDimX());
            } else {
                this.position.setX(realAmount);
            }
        }

    }
}
