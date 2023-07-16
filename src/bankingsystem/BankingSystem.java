package bankingsystem;

import Admin.DeleteCustomerAccount.DeleteCustomerAccountByAdmin;
import Admin.DisplayHoleData.ShowHoleDataToAdmin;
import Customer.CreateAccount.CreateAccountOfCustomer;
import Customer.CreateAccount.storeCustomerData;
import Customer.customerEditData.CustomerEditData;
import Customer.customerLogin.CustomerLogin;
import Customer.details.DisplayPersonalData;
import Customer.details.FundDetails;
import Customer.details.TransactionDetails;
import Customer.fundTranfer.FundTransfer;
import Customer.transaction.CustomerTransaction;
import HomePage.FrontPage;

public class BankingSystem {

    
    public static void main(String[] args) {
       storeCustomerData data = new storeCustomerData();
      // data.storeData("","", 0,"","","","");
        CreateAccountOfCustomer caoc = new CreateAccountOfCustomer();
        CustomerLogin customerLogin = new CustomerLogin();
        CustomerTransaction ct = new CustomerTransaction();
        FundTransfer ft = new FundTransfer();
        FundDetails ftd = new FundDetails();
        TransactionDetails td = new TransactionDetails();
        DisplayPersonalData data1 = new DisplayPersonalData();
        CustomerEditData  ced = new CustomerEditData();
      
        ShowHoleDataToAdmin admin = new ShowHoleDataToAdmin(); 
       // DeleteCustomerAccountByAdmin accountByAdmin = new  DeleteCustomerAccountByAdmin();
        //accountByAdmin.deleteData();
        FrontPage fp = new FrontPage();
        fp.design();
    
    }
    
}
