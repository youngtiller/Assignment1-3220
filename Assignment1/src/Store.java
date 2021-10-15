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

}