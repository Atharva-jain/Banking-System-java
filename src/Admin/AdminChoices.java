
package Admin;

import Admin.DeleteCustomerAccount.DeleteCustomerAccountByAdmin;
import Admin.DisplayHoleData.ShowHoleDataToAdmin;
import Admin.SearchDataByAdmin.SearchDataOfCustomer;
import Admin.SearchFundHistory.SearchFundHistortyAdmin;
import Admin.SearchTransactionhistory.SearchTransactionHistory;
import Admin.editCustomerDataByAdmin.EditCustomerDataFromAdmin;
import Customer.customerEditData.CustomerEditData;
import Customer.details.DisplayPersonalData;
import Customer.details.FundDetails;
import Customer.details.TransactionDetails;
import Customer.fundTranfer.FundTransfer;
import Customer.transaction.CustomerTransaction;
import HomePage.FrontPage;
import bankingsystem.Input;


public class AdminChoices
{
       public void adminChoices()
       {
          System.out.println("--------------------------------------------------------------");
          System.out.println("+++++++++++ A. Edit Customer Data  ++++++++");
          System.out.println("+++++++++++ B. Show Customer Data  +++++++");
          System.out.println("+++++++++++ C. Search Data   +++++++++++++");
          System.out.println("+++++++++++ D. Delete Account  +++++++++++");
          System.out.println("+++++++++++ E.  Fund History Search  +++++++");
          System.out.println("+++++++++++ F.  Transaction History Search  +++");
          System.out.println("+++++++++++ X. Exit  ++++++++++++++++++++");
          System.out.println("--------------------------------------------------------------");
          System.out.println("+++++++++++ Enter your Choice ::::::::::");
          Input input = new Input();
          String str = input.inputString();
          str = str.toUpperCase().trim();
           if(str.equals("A"))
          {
                 EditCustomerDataFromAdmin admin = new EditCustomerDataFromAdmin();
                 admin.editData();
          }
           else if(str.equals("B"))
          {
                 ShowHoleDataToAdmin admin = new ShowHoleDataToAdmin();
                 admin.getAccountNumber();
          } 
          else if(str.equals("C"))
          {
                 SearchDataOfCustomer customer = new SearchDataOfCustomer();
                 customer.searchData();
          } 
           else if(str.equals("D"))
          {
                  DeleteCustomerAccountByAdmin accountByAdmin = new DeleteCustomerAccountByAdmin();
                  accountByAdmin.deleteData();
          }
           else if(str.equals("E"))
          {
                  SearchFundHistortyAdmin admin = new SearchFundHistortyAdmin();
                  admin.searchFund();
          }
           else if(str.equals("F"))
          {
                 SearchTransactionHistory history = new SearchTransactionHistory();
                 history.searchTransactionHistory();
          }
          else if(str.equals("X"))
          {
                  FrontPage fp = new FrontPage();
                  fp.design();
          }
           else
          {
              System.out.println("Enter the Value Betweeen Given Choices ..............");
              adminChoices();
          }
       }
}
