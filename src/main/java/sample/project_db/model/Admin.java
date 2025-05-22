package sample.project_db.model;


public class Admin {
    private Integer adminid;
    private String adminusername;
    private String adminpassword;
    private String question;    
    private String answer;
    private String adminname;
    private String phonenumber;
    private String email;

    public Admin(Integer adminid, String adminname, String adminpassword, String adminusername, String answer, String email, String phonenumber, String question) {
        this.adminid = adminid;
        this.adminname = adminname;
        this.adminpassword = adminpassword;
        this.adminusername = adminusername;
        this.answer = answer;
        this.email = email;
        this.phonenumber = phonenumber;
        this.question = question;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getAdminusername() {
        return adminusername;
    }

    public void setAdminusername(String adminusername) {
        this.adminusername = adminusername;
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;


    public Admin(String username, String password, String question, String answer, String name, String phoneNumber, String email, int adminId) {
        this.username = username;
        this.password = password;
        this.question = question;
        this.answer = answer;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adminId = adminId;
    }

    public Admin(String username, String password, String question, String answer, String name, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.question = question;
        this.answer = answer;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Admin(String username, String password, String question, String answer) {
        this.username = username;
        this.password = password;
        this.question = question;
        this.answer = answer;
    }

    public Admin() {

    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;

