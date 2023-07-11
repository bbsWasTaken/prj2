
package Project2;

import java.util.*;

public class Game {

    private Random random = new Random();
    private Aircraft ac; //The user will control aircraft. You will be moving aircraft
    private ArrayList<Item> items; //All the other items in the game will be stored in this list
    private Scanner scn = new Scanner(System.in);

    public Game(int dX, int dY, int infCh, int norCh, int ducks) {
        Location2D.setDimXY(dX, dY);
        ac = new Aircraft();
        items = new ArrayList<>();
        createAllItems(infCh, norCh, ducks);
    }

    private void moveAllItems() {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item instanceof Moveable) {
                int direction = this.random.nextInt(1);
                int amount = this.random.nextInt(3);
                ((Moveable) item).move(direction, amount);
            }
        }
    }

    private void createAllItems(int infCh, int norCh, int ducks) {
        for (int i = 0; i < infCh; i++) {
            items.add(new Chicken(true)); //infected chickens
        }
        for (int i = 0; i < norCh; i++) {
            items.add(new Chicken(false)); //not infected chickens
        }
        for (int i = 0; i < ducks; i++) {
            items.add(new Duck());
        }

        //Here you can create different items. This is just an example
        items.add(new Pharmacy(5)); //5 is number of cureKits
        items.add(new Armory(50)); //50 is number of bullets stored in Armory
        items.add(new Birdnest());
        items.add(new Birdnest());

    }

    public void run() {
        GameDisplay.display(items, ac);

        //while aircraft is not destroyed
        while (ac.getHealthLevel() != 0 || checkIfAllDestroyed()) {
            //ask for aircraft move
            System.out.println("Health Left:" + ac.getHealthLevel());
            System.out.println("Which direction you move the Aircraft (L:Left,R:Right,S:Skip)?");

            char dim = scn.next().charAt(0);

            if (dim == 'R' || dim == 'r') {
                ac.move(0, 3); //0: move to Right, 3: distance to move
            } else if (dim == 'L' || dim == 'l') {
                ac.move(1, 3);
            } else {

            }

            GameDisplay.display(items, ac);

            //implement action to move all the other items in the game
            this.moveAllItems();
            //ask aircraft to shoot or not
            System.out.print("Do you want to throw bullets from the Aircraft to shoot enemies (U: Up, D: Down, S:Skip)?");
            char shootDim = scn.next().charAt(0);
            try {

                if (shootDim == 'U' || shootDim == 'u') {
                    ac.throwBullet(1, items);
                    //implement actions to shoot enemies at the upper side of the aircraft
                } else if (shootDim == 'D' || shootDim == 'd') {
                    ac.throwBullet(0, items);
                    //implement actions to shoot enemies at the down side of the aircraft
                } else {
                    System.out.println("No action for aircraft!");
                }
            } catch (Exception err) {
                System.out.println(err.getMessage());
            }
            //implement action to check collusion of aircraft with all items that are enemy
            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                if (item instanceof Enemies) {
                    ac.checkCollusion((Enemies) item);
                } else if (item instanceof Pharmacy) {
                    ac.checkIfAlignedWithPharmacy((Pharmacy) item);
                }
            }
            //call ac.checkCollusion((Enemy) item); for all items
            //to see details of checkCollusion read project document for Aircraft

            //use cure kits of Aircraft if necessary. Check document for details
            if (ac.isInfected) {
                ac.useCureKit();
            }
            ac.inflictDamageIfInfected();
            //If aircraft is destroyed break loop.
            if(this.random.nextInt(10) == 1){
                items.add(new Birdnest());
            }
            if(this.random.nextInt(5) == 1){
                items.add(new Birdnest());
            }
            items.add(new Armory(10));

            //implement actions for random birdnest appear
            //implement actions for random armory appear


            GameDisplay.display(items, ac);
            // printPositions();

        }//end of while
    }

    private boolean checkIfAllDestroyed() {
        boolean allDestroyed = true;
        for (Item item : items) {
            if (item instanceof Enemies) {
                if (!((Enemies) item).destroyed) {
                    allDestroyed = false;
                }
            }
        }

        return allDestroyed;
    }

    private void printPositions() { //this method is written for debugging purpose
        System.out.println("AC position: " + ac.getPos().getX());
        System.out.println("AC position: " + ac.getPos().getY());

        for (Item item : items) {
            System.out.println(item.getClass().getName());
            System.out.println("position: " + item.getPos().getX());
            System.out.println("position: " + item.getPos().getY());
        }
    }

}