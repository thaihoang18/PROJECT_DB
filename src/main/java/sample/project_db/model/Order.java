package sample.project_db.model;

import java.util.Date;

public class Order {
    private int orderid;
    private int customerid;
    private double  totalprice;
    private Date purchasedate;
    private int voucherid;

    public Order(int customerid, int orderid, Date purchasedate, double totalprice) {
        this.customerid = customerid;
        this.orderid = orderid;
        this.purchasedate = purchasedate;
        this.totalprice = totalprice;
    }
    

    public Order(int orderid, int customerid, double totalprice, Date purchasedate, int voucherid) {
        this.orderid = orderid;
        this.customerid = customerid;
        this.totalprice = totalprice;
        this.purchasedate = purchasedate;
        this.voucherid = voucherid;
    }


    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public Date getPurchasedate() {
        return purchasedate;
    }

    public void setPurchasedate(Date purchasedate) {
        this.purchasedate = purchasedate;
    }


    public int getVoucherid() {
        return voucherid;
    }


    public void setVoucherid(int voucherid) {
        this.voucherid = voucherid;
    }


}