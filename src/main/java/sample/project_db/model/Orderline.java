package sample.project_db.model;

public class Orderline {
    private int orderlineid;
    private int orderid;    
    private int productid;     
    private double  quantity;
    private double  pricepurchase;

    public Orderline(int orderid, int orderlineid, double pricepurchase, int productid, double quantity) {
        this.orderid = orderid;
        this.orderlineid = orderlineid;
        this.pricepurchase = pricepurchase;
        this.productid = productid;
        this.quantity = quantity;
    }

    public int getOrderlineid() {
        return orderlineid;
    }

    public void setOrderlineid(int orderlineid) {
        this.orderlineid = orderlineid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPricepurchase() {
        return pricepurchase;
    }

    public void setPricepurchase(double pricepurchase) {
        this.pricepurchase = pricepurchase;
    }


}
