import java.time.LocalDate;
import java.util.*;

public class CompactDisc extends Item {
	String bandName;
	String recordLabel;

	/*
	 * Develop a class called CompactDisc, which is also a type of Item. In addition
	 * to Item properties, it has a String called bandName and another called
	 * recordLabel. CompactDisc has three constructors . The first takes everything
	 * required for Item, but also a String for bandName and a String for
	 * recordLabel. The second only takes a bandName, and initializes recordLabel to
	 * “Indie” by calling the first constructor. The third constructor is only for
	 * copying items – in addition to the above properties from the first
	 * constructor, it should also take an int itemID. It also has the following
	 * methods:
	 */
	public CompactDisc(String title, double regularPrice, LocalDate releaseDate, int quantity, String bandName,
			String recordLabel) {
		super(title, regularPrice, releaseDate, quantity);
		this.bandName = bandName;
		this.recordLabel = recordLabel;
	}

	public CompactDisc(String bandName) {
		this("",0,0,0,bandName, "Indie");

	}

	public CompactDisc(CompactDisc o, int itemID, String bandName, String recordLabel) {
		super(o, itemID);
		this.bandName = bandName;
		this.recordLabel = recordLabel;

	}

	@Override
	public String toString() {
        return super.toString()+"\n\tBand: " + bandName + "\n\tRecord Label:" + recordLabel;
	}

	@Override
	public Item makeCopy() {
		return new CompactDisc(this, getItemID(), bandName, recordLabel);
	}

}
