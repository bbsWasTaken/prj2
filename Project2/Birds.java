
package Project2;


public class Birds extends Enemies {

    public Birds(boolean isInfected, int healthToGain,int ammoToKill) {
        super(isInfected, healthToGain,ammoToKill);
        this.position.setY(Location2D.getDimY());
    }



}
