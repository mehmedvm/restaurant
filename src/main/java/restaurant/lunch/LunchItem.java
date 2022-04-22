package restaurant.lunch;

public class LunchItem {
    //Fields
    private String itemName;
    private String itemNote;
    private int price;

    //Constructors
    public LunchItem() {
    }

    public LunchItem(String itemName, String itemNote, int price) {
        this.itemName = itemName;
        this.itemNote = itemNote;
        this.price = price;
    }

    //Getters an Setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemNote() {
        return itemNote;
    }

    public void setItemNote(String itemNote) {
        this.itemNote = itemNote;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //To String
    @Override
    public String toString() {
        return "LunchItem{" +
                "itemName='" + itemName + '\'' +
                ", itemNote='" + itemNote + '\'' +
                ", price=" + price +
                '}';
    }

}
