package sample.project_db.model;

public class Admin {
    private Integer adminId;
    private String username;
    private String password;
    private String question;    
    private String answer;
    private String name;
    private String phoneNumber;
    private String email;

    public Admin(Integer adminid, String adminname, String adminpassword, String adminusername, String answer, String email, String phonenumber, String question) {
        this.adminId = adminid;
        this.name = adminname;
        this.password = adminpassword;
        this.username = adminusername;
        this.answer = answer;
        this.email = email;
        this.phoneNumber = phonenumber;
        this.question = question;
    }

    public Admin(String adminpassword, String adminusername, String answer, String question) {
        this.password = adminpassword;
        this.username = adminusername;
        this.answer = answer;
        this.question = question;
    }

    public Admin() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminid) {
        this.adminId = adminid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String adminusername) {
        this.username = adminusername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String adminpassword) {
        this.password = adminpassword;

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

    public String getName() {
        return name;
    }

    public void setName(String adminname) {
        this.name = adminname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phonenumber) {
        this.phoneNumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

}
