package sample.project_db.model;

import java.time.LocalDate;

public class Product {
    private Integer productid;
    private String name;
    private String distributor;
    private String desscription;
    private LocalDate addeddate;
    private int quantity;
    private double  importprice;
    private double  sellprice;
    private int age;
    private String isbn;
    private String author;
    private LocalDate publishdate;
    private int categoryid;
    private boolean isdeleted;
    public Product() {
    }
    public Product(Integer productid, String name, String distributor, String desscription,
            LocalDate   addeddate, int quantity, double  importprice, double  sellprice, int age, String isbn, String author,
            LocalDate publishdate, int categoryid) {
        this.productid = productid;
        this.name = name;
        this.distributor = distributor;
        this.desscription = desscription;
        this.addeddate = addeddate;
        this.quantity = quantity;
        this.importprice = importprice;
        this.sellprice = sellprice;
        this.age = age;
        this.isbn = isbn;
        this.author = author;
        this.publishdate = publishdate;
        this.categoryid = categoryid;
        this.isdeleted = false;
    }
    public Product(String name, int quantity, double  sellprice) {
        this.name=name;
        this.quantity=quantity;
        this.sellprice=sellprice;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public String getDesscription() {
        return desscription;
    }

    public void setDesscription(String desscription) {
        this.desscription = desscription;
    }

    public LocalDate getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(LocalDate addeddate) {
        this.addeddate = addeddate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getImportprice() {
        return importprice;
    }

    public void setImportprice(double  importprice) {
        this.importprice = importprice;
    }

    public double  getSellprice() {
        return sellprice;
    }

    public void setSellprice(double  sellprice) {
        this.sellprice = sellprice;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(LocalDate publishdate) {
        this.publishdate = publishdate;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }
}

