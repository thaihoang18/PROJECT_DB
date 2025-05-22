package sample.project_db.model;

public class CartItem {
    public int cartitemid;
    public int cartid;
    public int productid;
    public int quantity;

    public CartItem(int cartid, int cartitemid, int productid, int quantity) {
        this.cartid = cartid;
        this.cartitemid = cartitemid;
        this.productid = productid;
        this.quantity = quantity;
    }

    public int getCartitemid() {
        return cartitemid;
    }

    public void setCartitemid(int cartitemid) {
        this.cartitemid = cartitemid;
    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
