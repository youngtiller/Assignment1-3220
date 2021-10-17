import java.time.LocalDate;
import java.util.*;

public class Movie extends Item {
	String director;
	String producer;

	public Movie(String title, double regularPrice, LocalDate releaseDate, int quantity, String director,
			String producer) {
		super(title, regularPrice, releaseDate, quantity);
		this.director = director;
		this.producer = producer;
	}

	public Movie(String title, double regularPrice, LocalDate releaseDate, int quantity, int itemID, String directory,
			String producer) {
		super(title, regularPrice, releaseDate, quantity);
		this.director = directory;
		this.producer = producer;
	}

	@Override
	public String toString() {
		return toString() + "\n\tDirectory: " + director + "\n\tProducer: " + producer;
	}
	
	@Override
	public Item makeCopy() {
		return new Movie(getTitle(), getRegularPrice(), getReleaseDate(), getQuantity(), getItemID(), director, producer);
	}

}
