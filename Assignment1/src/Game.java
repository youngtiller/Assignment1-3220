import java.time.LocalDate;
import java.util.*;

public class Game extends Item {
	String studio;
	boolean discontinued;

	public Game(String title, double regularPrice, LocalDate releaseDate, int quantity, String studio,
			boolean discontinued) {
		super(title, regularPrice, releaseDate, quantity);
		this.studio = studio;
		this.discontinued = discontinued;
	}

	public Game(String title, double regularPrice, LocalDate releaseDate, int quantity, int itemID, String studio,
			boolean discontinued) {
		super(title, regularPrice, releaseDate, quantity);
		this.studio = studio;
		this.discontinued = discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public boolean getDiscontinued() {
		return discontinued;
	}

	@Override
	public String toString() {
		return toString() + "\n\tStudio: " + studio + "\n\tDiscontinued: " + discontinued;
	}

	@Override
	public double getPrice(LocalDate sellDate) {
		double price = getRegularPrice();
		if (getDiscontinued()) {
			price = price * 20;
		}
		return price;
	}

	@Override
	public Item makeCopy() {
		return new Game(getTitle(), getRegularPrice(), getReleaseDate(), getQuantity(), getItemID(), studio, discontinued);
		
	}

}
