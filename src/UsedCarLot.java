import java.util.ArrayList;

/**
 * This class represents a Used Car Lot
 *
 * @author Michael Miller
 */
public class UsedCarLot {

    /** The Cars in the used car lot */
    private ArrayList<Car> inventory;

    /**
     * Instantiates a UsedCarLot object and
     * initializes the inventory to an empty ArrayList
     */
    public UsedCarLot() {
        inventory = new ArrayList<Car>();
    }

    /**
     * Returns the inventory of the used car lot
     *
     * @return The inventory
     */
    public ArrayList<Car> getInventory() {
        return inventory;
    }

    /**
     * Adds a Car to the end of the inventory
     *
     * @param carToAdd the Car to add
     */
    public void addCar(Car carToAdd) {
        inventory.add(carToAdd);
    }

    /**
     * Swaps the Car at idx1 with the Car at idx2 in inventory and returns true;
     * however, if either idx1 or idx2 exceed the bounds of the inventory or is negative,
     * no changes are made to the inventory and false is returned.
     *
     * @param idx1 The index of the first Car to swap
     * @param idx2 The index of the second Car to swap
     * @return True if the swap was successful, false if the swap was not successful
     */
    public boolean swap(int idx1, int idx2) {
        if (idx1 < inventory.size() && idx2 < inventory.size() && idx1 >= 0 && idx2 >= 0) {
            Car car1 = inventory.get(idx1);
            Car car2 = inventory.get(idx2);
            inventory.set(idx2, car1);
            inventory.set(idx1, car2);
            return true;
        } else {
            //do not change inventory and return false
            return false;
        }
    }

    /**
     * Adds a Car to the inventory list at the index specified
     * by indexToAdd; this method increases the size of inventory by 1
     * <p>
     * PRECONDITION: 0 &lt;= indexToAdd &lt; inventory.size()
     *
     * @param indexToAdd The index in the inventory to add the new Car
     * @param carToAdd The Car to add
     */
    public void addCar(int indexToAdd, Car carToAdd)
    {
        // uses the other ArrayList "add" method that takes two parameters
        inventory.add(indexToAdd, carToAdd);
    }

    /**
     * "Sells" the Car located at indexOfCarToSell which
     * removes it from the inventory list and shifting the remaining
     * Cars in the inventory list to the left to fill in the gap;
     * the method returns the Car that is being "sold" (removed from lot)
     * and reduces the size of inventory by 1
     * <p>
     * PRECONDITION: indexOfCarToSell &lt; inventory.size()
     *
     * @param indexOfCarToSell The index of the Car to sell
     * @return the Car that is "sold"
     */
    public Car sellCarShift(int indexOfCarToSell)
    {
        // note that the ArrayList "remove" method causes all elements to shift to the left,
        // and conveniently returns the element that is being removed!
        return inventory.remove(indexOfCarToSell);
    }

    /**
     * "Sells" the Car located at indexOfCarToSell,
     * but instead of removing it and shifting the inventory
     * list to the left, REPLACE the Car at indexOfCarToSell
     * with NULL, thus creating an "empty parking spot" on the lot;
     * this method returns the Car that is being "sold" (replaced with null),
     * but does NOT reduce the size of the inventory
     * <p>
     * PRECONDITION: indexOfCarToSell &lt; inventory.size()
     *
     * @param indexOfCarToSell The index of the Car to sell
     * @return the Car that is "sold"
     */
    public Car sellCarNoShift(int indexOfCarToSell)
    {
        // get the car at the requested index -- but don't remove it
        Car soldCar = inventory.get(indexOfCarToSell);

        // update the value at the specified index to null
        // (note this does NOT reduce the size of inventory, there is
        // now just a null value as one of the elements!)
        inventory.set(indexOfCarToSell, null);

        // return the sold Car
        return soldCar;
    }

    /**
     * Moves Car located at index indexOfCarToMove to index destinationIndex;
     * if destinationIndex > indexOfCarToMove, moves the Car to the right in
     * inventory; if destinationIndex &lt; indexOfCarToMove, moves the
     * Car to the left in the inventory. All other cars in the inventory
     * are shifted accordingly.
     * <p>
     * PRECONDITIONS: indexOfCarToMove &lt; inventory.size()
     *                destinationIndex &lt; inventory.size()
     *
     * @param indexOfCarToMove The index of the Car to move
     * @param destinationIndex The index where the Car should be moved
     */
    public void moveCar(int indexOfCarToMove, int destinationIndex)
    {
        // one way to do this is to REMOVE the car from indexOfCarToMove
        // and storing in a variable, then immediately add to destinationIndex:
        Car carToMove = inventory.remove(indexOfCarToMove);
        inventory.add(destinationIndex, carToMove);
    }
}