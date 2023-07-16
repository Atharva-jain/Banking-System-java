 
package Customer;

import Customer.customerEditData.CustomerEditData;
import Customer.details.DisplayPersonalData;
import Customer.details.FundDetails;
import Customer.details.TransactionDetails;
import Customer.fundTranfer.FundTransfer;
import Customer.transaction.CustomerTransaction;
import HomePage.FrontPage;
import bankingsystem.Input;

public class CustomerChoicesToChoose
{
      public void CustomerChoose(String accountNO)
      {
          System.out.println("--------------------------------------------------------------");
          System.out.println("+++++++++++ A. Deposite  ++++++++++++++++");
          System.out.println("+++++++++++ B. Fund Transfer  ++++++++++++");
          System.out.println("+++++++++++ C. Edit Information  +++++++++++");
          System.out.println("+++++++++++ D. Show Data  ++++++++++++++");
          System.out.println("+++++++++++ E.  Show Fund History  ++++++++");
          System.out.println("+++++++++++ F.  Show Deposit History  +++++++");
          System.out.println("+++++++++++ X. Exit  ++++++++++++++++++++");
          System.out.println("--------------------------------------------------------------");
          System.out.println("+++++++++++ Enter your Choice ::::::::::");
          Input input = new Input();
          String str = input.inputString();
          str = str.toUpperCase().trim();
           if(str.equals("A"))
          {
                  CustomerTransaction ct = new CustomerTransaction();
                  ct.customerTransaction(accountNO);
          }
           else if(str.equals("B"))
          {
                  FundTransfer ft = new FundTransfer();
                  ft.transferFund(accountNO);
          } 
          else if(str.equals("C"))
          {
                  CustomerEditData ced = new CustomerEditData();
                  ced.editData(accountNO, 0);
          } 
           else if(str.equals("D"))
          {
                  DisplayPersonalData data = new DisplayPersonalData();
                  data.displayPersonalData(accountNO, 0);
          }
           else if(str.equals("E"))
          {
                  FundDetails details = new FundDetails();
                  details.fundTransferDetails(accountNO, 0);
          }
           else if(str.equals("F"))
          {
                   TransactionDetails transactionDetails = new TransactionDetails();
                   transactionDetails.fundTransferDetails(accountNO, 0);
          }
          else if(str.equals("X"))
          {
                  FrontPage fp = new FrontPage();
                  fp.design();
          }
           else
          {
              System.out.println("Enter the Value Betweeen Given Choices ..............");
              CustomerChoose(accountNO);
          }
          
      }
    
}
