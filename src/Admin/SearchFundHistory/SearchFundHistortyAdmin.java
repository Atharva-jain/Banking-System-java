
package Admin.SearchFundHistory;

import Admin.AdminChoices;
import Customer.details.DisplayPersonalData;
import Customer.details.FundDetails;
import bankingsystem.CheckFile;
import bankingsystem.Input;

public class SearchFundHistortyAdmin
{
    Input input = new Input();
      public void searchFund()
     {
          System.out.println("/////////////////////////////////////////////////////////////////////////////");
          System.out.println("Enter there Account Numer  :::: ");
          int accountNo = input.integerBug();
          CheckFile cf = new CheckFile();
          boolean check =  cf.fileIsAvailable(Integer.toString(accountNo));
          System.out.println("/////////////////////////////////////////////////////////////////////////////");
          if(check)
          {
                FundDetails details = new FundDetails();
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
                         searchFund();
                    }
                    else
                    {
                            AdminChoices ac = new AdminChoices();
                            ac.adminChoices();
                    }
          }
         }
}
