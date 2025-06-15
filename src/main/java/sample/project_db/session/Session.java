package sample.project_db.session;

import sample.project_db.model.Admin;
import sample.project_db.model.Customer;

public class Session {
    private static Customer currentCustomer;
    private static Admin currentAdmin;
    public static void setCurrentCustomer(Customer currentCustomer){
        Session.currentCustomer=currentCustomer;
    }
    public static Customer getCurrenCustomer(){
        return Session.currentCustomer;
    }
    public static void setCurrentAdmin(Admin currentAdmin) {
        Session.currentAdmin = currentAdmin;
    }
    
    public static Customer getCurrentCustomer() {
        return currentCustomer;
    }
    public static Admin getCurrentAdmin() {
        return currentAdmin;
    }
    public Session() {
    }

    public static void logout(){
        currentAdmin=null;
        currentCustomer=null;
    }

}
