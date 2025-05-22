package sample.project_db.model;

public class Cart {
    private int cartid;
    private int customerid;
    private double totalcost;
    private double finalcost;

    public Cart(int cartid, int customerid, double finalcost, double totalcost) {
        this.cartid = cartid;
        this.customerid = customerid;
        this.finalcost = finalcost;
        this.totalcost = totalcost;
    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public double getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(double totalcost) {
        this.totalcost = totalcost;
    }

    public double getFinalcost() {
        return finalcost;
    }

    public void setFinalcost(double finalcost) {
        this.finalcost = finalcost;
    }



}
