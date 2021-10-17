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

    public Movie(Movie o, int itemID, String directory,
                 String producer) {
        super(o,itemID);
        this.director = directory;
        this.producer = producer;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tDirectory: " + director + "\n\tProducer: " + producer;
    }

    @Override
    public Item makeCopy() {
        return new Movie(this,getItemID(), director, producer);
    }

}
