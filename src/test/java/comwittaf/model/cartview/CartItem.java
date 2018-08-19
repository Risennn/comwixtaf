package comwittaf.model.cartview;

public class CartItem {

    private String productName;
    private String itemSku;
    private String price;
    private Integer quantity;
    private String total;

    public String getProductName() {
        return productName;
    }

    public String getItemSku() {
        return itemSku;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setItemSku(String itemSku) {
        this.itemSku = itemSku;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getTotal() {
        return total;
    }

    @Override
    public int hashCode() {
        final int prime = 42;
        return (int)(Long.valueOf(itemSku) % prime);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CartItem other = (CartItem) obj;
        if (!productName.equals(other.productName))
            return false;
        if (!itemSku.equals(other.itemSku))
            return false;
        if (!price.equals(other.price))
            return false;
        if (!quantity.equals(other.quantity))
            return false;
        if (!total.equals(other.total))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "| productName: " + productName + " | itemSku: " + itemSku + " | price: " + price + " | quantity: " + quantity + " | total: " + total + " |";
    }
}
