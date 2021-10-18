package comp3220;

import java.time.LocalDate;
import java.util.ArrayList;

public class Book extends Item {
    private ArrayList<String> authors=new ArrayList<>();
    public Book(String title, double regularPrice, LocalDate releaseDate, int quantity, ArrayList<String> authors) {
        super(title, regularPrice, releaseDate, quantity);
        this.authors=authors;
    }

    public Book(Item o, int itemID, ArrayList<String> authors) {
        super(o, itemID);
        this.authors = authors;
    }

    public ArrayList<String> getAuthors(){
        ArrayList<String> copy=(ArrayList<String>)authors.clone();
        return copy;
    }

    @Override
    public String toString(){
        String superToString=super.toString();
        superToString+="\n\tAuthors:";
        for(String e:authors){
            superToString+="\n\t "+e;
        }
        return superToString;
    }

    @Override
    public double getPrice(LocalDate sellDate){
        if(this.getDiscount()!=0)
            return this.getRegularPrice()*this.getDiscount();
        else return this.getRegularPrice();
    }

    public Item makeCopy(){
        Book copy=new Book(this,this.getItemID(),authors);
        return copy;
    }
}

