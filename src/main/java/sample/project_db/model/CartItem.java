package sample.project_db.model;


public class CartItem {
    public int cartitemid;
    public int customerid;
    public int productid;
    public int quantity;
    public int getCartitemid() {
        return cartitemid;
    }
    public void setCartitemid(int cartitemid) {
        this.cartitemid = cartitemid;
    }
    public int getCustomerid() {
        return customerid;
    }
    public void setCustomerid(int customerid) {
        this.customerid = customerid;
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
    public CartItem(int cartitemid, int customerid, int productid, int quantity) {
        this.cartitemid = cartitemid;
        this.customerid = customerid;
        this.productid = productid;
        this.quantity = quantity;
    }
    

 
}
