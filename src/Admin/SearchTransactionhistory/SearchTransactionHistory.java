
package Admin.SearchTransactionhistory;

import Customer.details.FundDetails;
import Customer.details.TransactionDetails;
import bankingsystem.CheckFile;
import bankingsystem.Input;

public class SearchTransactionHistory 
{ 
       Input input = new Input();
       public void searchTransactionHistory()
       {
          System.out.println("/////////////////////////////////////////////////////////////////////////////");
          System.out.println("Enter there Account Numer  :::: ");
          int accountNo = input.integerBug();
          CheckFile cf = new CheckFile();
          boolean check =  cf.fileIsAvailable(Integer.toString(accountNo));
          System.out.println("/////////////////////////////////////////////////////////////////////////////");
          if(check)
          {
                 TransactionDetails details = new TransactionDetails();
                 details.fundTransferDetails(Integer.toString(accountNo), 1);
              
          }
          else
          {
                    System.out.println("Acount Number is Not Available  !! ...............");
                    System.out.println("Invalid Information you want to try Again (Yes / No) :: ");
                    String str1 = input.inputString();
                    str1 = str1.toUpperCase().trim();
                    if(str1.equals("YES"))
                    {
                         searchTransactionHistory();
                    }
                    else
                    {
                            
                    }
          }
       }
}
