/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin.editCustomerDataByAdmin;

import Admin.AdminChoices;
import Customer.customerEditData.CustomerEditData;
import HomePage.FrontPage;
import bankingsystem.CheckFile;
import bankingsystem.Input;

public class EditCustomerDataFromAdmin 
{
      Input input = new Input();
      public void editData()
      {
          System.out.println("/////////////////////////////////////////////////////////////////////////////");
          System.out.println("Enter there Account Numer  :::: ");
          int accountNo = input.integerBug();
          CheckFile cf = new CheckFile();
          boolean check =  cf.fileIsAvailable(Integer.toString(accountNo));
          System.out.println("/////////////////////////////////////////////////////////////////////////////");
          if(check){
             CustomerEditData ced = new CustomerEditData();
             ced.editData(Integer.toString(accountNo), 1);
          }
          else
          {
                    System.out.println("Acount Number is Not Available  !! ...............");
                    System.out.println("Invalid Information you want to try Again (Yes / No) :: ");
                    String str1 = input.inputString();
                    str1 = str1.toUpperCase().trim();
                    if(str1.equals("YES"))
                    {
                         editData();
                    }
                    else
                    {
                            AdminChoices ac = new AdminChoices();
                            ac.adminChoices();
                    }
          }
      }
    
}

