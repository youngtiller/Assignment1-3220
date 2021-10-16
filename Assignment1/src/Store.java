import java.util.*;

public class Store {
	private ArrayList<Item> inventory = null;
	private double totalSalesValue;
	private int totalNumberOfSales;

	public Store() {
		this.inventory = new ArrayList<>();
		this.totalSalesValue = 0;
		this.totalNumberOfSales = 0;
	}

	// addItem which is void, it takes an Item and adds it to inventory
	public void addItem(Item item) {
		inventory.add(item);
	}

	/*
	 * makeSale which returns boolean, and takes as input an int itemID, an int
	 * called quantity, and a java.time.LocalDate called sellDate. The method
	 * returns false if the item cannot be found in the store (when calling
	 * getItemByID, the item is null). Otherwise, it calls a method on item called
	 * “sell”, giving the quantity and sellDate to that method, capturing its return
	 * value called “value”. If value > 0, then it increments the stores
	 * totalNumberOfSales and totalSalesValue accordingly, and returns true.
	 * Otherwise, it returns false.
	 */
	public boolean makeSale(int itemID, int quantity, java.time.LocalDate sellDate) {
		Item item = getItemByID(itemID);
		if (item == null) {
			return false;
		} else {
			double value=item.sell(quantity, sellDate);
			if(value>0) {
				totalNumberOfSales++;
				totalSalesValue++;
				return true;
				
			}
			else {
				return false;
			}

		}
	}

	/*
	 * getInventoryString which returns String, which iterates over the Store’s
	 * inventory and for each item adds to a String “\n” + item.toString() + “\n”.
	 * It then returns this string,
	 */
	public String getInventoryString() {

	}

	/*
	 * listInventory which is void, which simply prints into the console “Here are
	 * all the inventory items:” followed by the output from getInventoryString.
	 */
	public void listInventory() {

	}

	/*
	 * checkForItem which returns Item and takes an int called itemID. It iterates
	 * over the inventory and if it finds an Item with the given ID, it returns a
	 * copy of the item. Otherwise, it returns null. This method is public, to check
	 * if an item exists in the inventory before making a sale.
	 */
	public Item checkForItem(int itemID) {
		
	}
	/*
	 * getItemByID which returns Item and takes an int called itemID. It iterates
	 * over the inventory and if it finds an Item with the given ID, it returns the
	 * item. Otherwise, it returns null. Ensure that the Item’s properties can only
	 * be modified by the Store class (how?).
	 */

	public int getItemByID(int itemID) {

	}

}