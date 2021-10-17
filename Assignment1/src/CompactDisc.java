import java.time.LocalDate;
import java.util.*;

public class CompactDisc extends Item {
	String bandName;
	String recordLabel;
	
	public CompactDisc(String title, double regularPrice, LocalDate releaseDate, int quantity, String bandName,
			String recordLabel) {
		super(title, regularPrice, releaseDate, quantity);
		this.bandName=bandName;
		this.recordLabel=recordLabel;
	}
	
	public CompactDisc

}
