
package shoppingcatalog.dto;


public class ItemDTO {
    private int itemId;
    private String itemType,itemName,itemDesc,itemImage;
    private double itemPrice;

    @Override
    public String toString() {
        return "ItemDTO{" + "itemId=" + itemId + ", itemType=" + itemType + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", itemImage=" + itemImage + ", itemPrice=" + itemPrice + '}';
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    
}
