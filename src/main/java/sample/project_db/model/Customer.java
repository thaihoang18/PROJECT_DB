package sample.project_db.model;

public class Customer{
    private Integer customerid;
    private String customerusername;
    private String customerpassword;
    private String question;
    private String answer;
    private String customername;
    private String phonenumber;
    private String email;
    private String address;
    
    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getCustomerusername() {
        return customerusername;
    }

    public void setCustomerusername(String customerusername) {
        this.customerusername = customerusername;
    }

    public String getCustomerpassword() {
        return customerpassword;
    }

    public void setCustomerpassword(String customerpassword) {
        this.customerpassword = customerpassword;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Customer() {
    }

    public Customer(Integer customerid, String customerusername, String customerpassword, String question,
            String answer, String customername, String phonenumber, String email, String address) {
        this.customerid = customerid;
        this.customerusername = customerusername;
        this.customerpassword = customerpassword;
        this.question = question;
        this.answer = answer;
        this.customername = customername;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
    }
    

}
