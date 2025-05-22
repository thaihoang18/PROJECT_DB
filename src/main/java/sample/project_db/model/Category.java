package sample.project_db.model;

public class Category {
    private int cartegoryid;
    private int categoryname;

    public Category(int cartegoryid, int categoryname) {
        this.cartegoryid = cartegoryid;
        this.categoryname = categoryname;
    }

    public int getCartegoryid() {
        return cartegoryid;
    }

    public void setCartegoryid(int cartegoryid) {
        this.cartegoryid = cartegoryid;
    }

    public int getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(int categoryname) {
        this.categoryname = categoryname;
    }



}
