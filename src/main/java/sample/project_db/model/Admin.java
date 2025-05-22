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
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
