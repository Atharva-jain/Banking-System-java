
package Admin.SearchDataByAdmin;

import Admin.AdminChoices;
import Customer.customerEditData.CustomerEditData;
import Customer.details.DisplayPersonalData;
import bankingsystem.CheckFile;
import bankingsystem.Input;

public class SearchDataOfCustomer
{
    Input input = new Input();
    public void searchData()
    {
          System.out.println("/////////////////////////////////////////////////////////////////////////////");
          System.out.println("Enter there Account Numer  :::: ");
          int accountNo = input.integerBug();
          CheckFile cf = new CheckFile();
          boolean check =  cf.fileIsAvailable(Integer.toString(accountNo));
          System.out.println("/////////////////////////////////////////////////////////////////////////////");
          if(check)
          {
                DisplayPersonalData data = new DisplayPersonalData();
                data.displayPersonalData(Integer.toString(accountNo), 1);
              
          }
          else
          {
                    System.out.println("Acount Number is Not Available  !! ...............");
                    System.out.println("Invalid Information you want to try Again (Yes / No) :: ");
                    String str1 = input.inputString();
                    str1 = str1.toUpperCase().trim();
                    if(str1.equals("YES"))
                    {
                         searchData();
                    }
                    else
                    {
                            AdminChoices ac = new AdminChoices();
                            ac.adminChoices();
                    }
          }
    }
    
}
