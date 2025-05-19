package sample.project_db.session;

import sample.project_db.model.Customer;

public class Session {
    private static Customer currentCustomer;
    public static void setCurrentCustomer(Customer currentCustomer){
        Session.currentCustomer=currentCustomer;
    }
    public static Customer getCurrenCustomer(){
        return Session.currentCustomer;
    }
    public static void logout(){
        currentCustomer=null;
    }

}
