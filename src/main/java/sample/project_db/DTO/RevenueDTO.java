package sample.project_db.DTO;

public class RevenueDTO {
    private String month;
    private double revenue;
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public double getRevenue() {
        return revenue;
    }
    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
    public RevenueDTO(String month, double revenue) {
        this.month = month;
        this.revenue = revenue;
    }
    public RevenueDTO() {
    }
    
    
}

