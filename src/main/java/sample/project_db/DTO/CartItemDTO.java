package sample.project_db.DTO;

public class CartItemDTO {
    private int productid;
    private String name;
    private int quantity;
    private double sellprice;
    
    public CartItemDTO(int productid, String name, int quantity, double sellprice) {
        this.productid = productid;
        this.name = name;
        this.quantity = quantity;
        this.sellprice = sellprice;
    }
    public int getProductid() {
        return productid;
    }
    public void setProductid(int productid) {
        this.productid = productid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getSellprice() {
        return sellprice;
    }
    public void setSellprice(double sellprice) {
        this.sellprice = sellprice;
    }
    
}
