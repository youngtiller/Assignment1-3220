package comp3220;

import java.time.LocalDate;
import java.time.Period;

public class Item {
    private String title;
    private double regularPrice;
    private int itemID;
    private double discount=0;
    private LocalDate releaseDate;
    private int quantity;
    private static int currentItemID=9000;

    public Item(String title, double regularPrice, LocalDate releaseDate, int quantity){
        this.title=title;
        this.regularPrice=regularPrice;
        this.releaseDate=releaseDate;
        if(quantity>100)
            this.quantity=100;
        else
            this.quantity=quantity;
        this.itemID=currentItemID;
        currentItemID+=100;
    }
    public Item(Item o, int itemID){
        this.title=o.title;
        this.regularPrice=o.regularPrice;
        this.releaseDate=o.releaseDate;
        this.quantity=o.quantity;
        this.itemID=itemID;
    }

    public String getTitle() {
        return title;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public int getItemID() {
        return itemID;
    }

    public double getDiscount() {
        return discount;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice(LocalDate sellDate){
        double price=this.regularPrice;
        Period difference= Period.between(this.releaseDate,sellDate);
        if(difference.getYears()>1){
            price=price*0.5*this.discount;
            return price;
        }
        else return price*this.discount;
    }

    public boolean setDiscount(double discount){
        if(discount>=1 || discount<0.5)
            return false;
        else {
            this.discount=discount;
            return true;
        }
    }

    public double sell(int amount, LocalDate sellDate){
        if(sellDate.isBefore(this.releaseDate))
            return 0;
        if(amount>0 && amount<=this.quantity){
            double salesValue=amount*this.regularPrice*this.discount;
            this.quantity-=amount;
            return salesValue;
        }
        return 0;
    }

    public boolean addStock(int amount){
        if(amount<0 || amount+quantity>100)
            return false;
        else {
            this.quantity+=amount;
            return true;
        }
    }

    @Override
    public String toString(){
        String ret="ITEM "+this.itemID+":\n\tTitle:"+this.title+"\n\tRegular Price:"+this.regularPrice+"\n\tRelease Date:"+this.releaseDate+
                "\n\tDiscount:"+this.discount+"\n\tQuantity:"+this.quantity;
        return ret;
    }

    public void makeCopy(){
        
    }
}
