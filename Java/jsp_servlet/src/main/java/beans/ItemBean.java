package beans;

import java.io.Serializable;

public class ItemBean implements Serializable {
    private String itemID;
    private String itemName;
    private int itemPrice;

    public ItemBean() {
    }

    public ItemBean(String itemID, String itemName, int itemPrice) {
    this.itemID = itemID;
    this.itemName =itemName;
    this.itemPrice = itemPrice;
    }


    public String getItemID() {
        return itemID;
    }
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    

}
