
package Project2;


public class Eggs extends Enemies implements Shootable {


    public Eggs(boolean isInfected) {
        super(isInfected, Enemies.baseHealthMultiplier, 2);
    }


}
