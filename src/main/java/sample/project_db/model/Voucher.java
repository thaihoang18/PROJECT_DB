package sample.project_db.model;

import java.time.LocalDate;


public class Voucher {
    private int voucherid;
    private String code;
    private int remaining;
    private float discount;
    private LocalDate duration;

    public Voucher(String code, int remaining, float discount, LocalDate duration, int voucher_id) {
        this.code = code;
        this.remaining = remaining;
        this.discount = discount;
        this.duration = duration;
        this.voucherid = voucher_id;
    }

    public String getCode() {return code;}

    public void setCode(String code) {this.code = code;}

    public int getRemaining() {return remaining;}

    public void setRemaining(int remaining) {this.remaining = remaining;}

    public float getDiscount() {return discount;}

    public void setDiscount(float discount) {this.discount = discount;}

    public LocalDate getDuration() {return duration;}

    public void setDuration(LocalDate duration) {this.duration = duration;}

    public int getVoucherid() {
        return voucherid;
    }

    public void setVoucherid(int voucher_id) {
        this.voucherid = voucher_id;
    }

}
