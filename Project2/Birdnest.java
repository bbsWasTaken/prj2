
package Project2;

public class Birdnest extends GroundObjects implements Shootable {


    public Birdnest() {
        this.position.setY(Location2D.getDimY());

    }

    public void shootMe() {
        this.destroyed = true;
    }
}
