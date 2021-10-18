import java.util.*;
import java.util.ArrayList;


public class Store {

	List<Item> inventory;
	double totalSalesValue = 0;
	int totalNumberOfSales = 0;
	public Store()
	{
		this(new ArrayList<Item>());
	}
	public void addItem(Item item) {
		inventory.add(item);
	}
	public boolean makeSale(Item item, int itemID, int quantity, java.time.LocalDate sellDate) {
		item = getItemByID(itemID);
		if(item.equals(null)) {
			return false;
		}
		else {
			double value = item.sell(quantity, sellDate); //If item is in store the method sell will give the quanitity of said item and it's sell date.
			if(value > 0) { //Value has to be greater than 0 for store to update and add how ever many number of sales and the sales value accumulated from said item.
				totalNumberOfSales++;
				totalSalesValue += value;
				return true;
			}
			else {
				return false;
			}
		}
	}
	//Method getInventoryString that takes nothing it will go through the stores inventory and add items to our data.
	public String getInventoryString() {
		String data = ""; //We set data basically to a null value and add item within the inventory to this string.
		for(Item item: inventory) {
			data += "\n" + item.toString() + "\n";
		}
		return data;
	}
	//Method listInventory which takes nothing we are simply printing a statement and the inventory in the store
	public void listInventory() {
		System.out.println("Here are all the inventory items:\n");
		System.out.println(getInventoryString());
	}
	//Method checkForItem takes itemID and returns the itemID if it's in the inventory
	public Item checkForItem(int itemID) {
		Item item = null; //we set the placeholder item to null
		for(Item items: inventory) { //Going through the inventory looking for the items id
			if(items.getItemID().equals(itemID)) { //if the item has the same id as itemid
				item = item.makeCopy(); //we make a copy of this item id incase we need it for a sale
			}
		}
		return item;
	}
	//Method getItemByID takes an itemID and returns the itemID
	public Item getItemByID(int itemID) {
		Item item = null;
		for(Item items: inventory) { //Goes through the inventory looking for the given itemID
			if(items.getItemID() == itemID) { //if the item id is a match with the itemid in the inventory
				item = items;
			}
		}
		return item; // we return the item
	}
	//Getter method for totalSalesValue
	public double totalSalesValue() {
		return totalSalesValue;
	}
	//Getter method for totalNumberOfSales
	public int totalNumberOfSales() {
		return totalNumberOfSales;
	}
	//Ovveride annotation to output the total sales value, total number of sales, and stores current inventory.
	@Override
	public String toString() {
		return "Total sales value: " + totalSalesValue + "\nTotal number of sales: " + totalNumberOfSales + "\nCurrent Inventory: " + getInventoryString();
	}
}
}