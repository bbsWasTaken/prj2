
package Project2;

public class Pharmacy extends GroundObjects {


    private int cureKitCount;
    
    public Pharmacy(int cureKitCount) {
        this.cureKitCount = cureKitCount;
    }

    public int getCureKitCount() {
        return cureKitCount;
    }

    private void setCureKitCount(int cureKitCount) {
        this.cureKitCount = cureKitCount;
    }

    void getCureKit() {
        setCureKitCount(getCureKitCount() - 1);
        if (getCureKitCount() == 0) {
            this.destroyed = true;
        }

    }

    
}
