 
package Admin.DisplayHoleData;

import Admin.AdminChoices;
import Customer.CustomerChoicesToChoose;
import Customer.details.TransactionDetails;
import bankingsystem.CheckFile;
import bankingsystem.Input;
import java.io.BufferedReader;
import java.io.FileReader;


public class ShowHoleDataToAdmin 
{
      Input input = new Input();
      public void getAccountNumber()
      {
          try
          {
               FileReader fileReader = new FileReader("AccountNumbers.txt");
               BufferedReader reader = new BufferedReader(fileReader);
               String data = "";
               while((data = reader.readLine()) != null)
               {
                        System.out.println("Number :: "+data);
                        showHoleData(data+".txt");
               }
               AdminChoices ac = new AdminChoices();
               ac.adminChoices();
          }
          catch (Exception e) 
          {
          }
      }
      public void showHoleData(String accountNO)
      {
           try
           {
                 FileReader fileReader = new FileReader(accountNO);
                 BufferedReader reader = new BufferedReader(fileReader);
                 String data = "";
                 System.out.println("/////////////////////////////////////////////////////////////////////////////");
                 int i = 0 ;
                 while((data = reader.readLine()) != null)
                 {
                     if(i == 0 )
                     {
                         System.out.println("ID ::::: " +data );
                          
                          
                     }
                     if(i == 1 )
                     {
                         System.out.println("Account Number ::::: " +data );
                          
                          
                     }
                     if(i == 2 )
                     {
                         System.out.println("Name ::::: " +data );
                          
                          
                     }
                     if(i == 3)
                     {
                         System.out.println("Male ::::: " +data );
                          
                
                     } 
                     if(i == 4 )
                     {
                         System.out.println("Phone Number ::::: " +data );
                          
                          
                     }
                     if(i == 5 )
                     {
                         System.out.println("Address ::::: " +data );
                          
                          
                     }
                     if(i == 6 )
                     {
                         System.out.println("Account Type ::::: " +data );
                          
                          
                     }
                     if(i == 7 )
                     {
                         System.out.println("Gmail ::::: " +data );
                          
                          
                     }
                     i++;
                 }
                 System.out.println("/////////////////////////////////////////////////////////////////////////////");
                 reader.close();
                
            }
           catch (Exception e) 
            {
             }
 
      }
    
}
