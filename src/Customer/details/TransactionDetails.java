
package Customer.details;

import Admin.AdminChoices;
import Customer.CustomerChoicesToChoose;
import java.io.BufferedReader;
import java.io.FileReader;


public class TransactionDetails 
{
       public void fundTransferDetails(String accountNo, int index)
    {
           try
           {
                 FileReader fileReader = new FileReader(accountNo+"transactionhistory.txt");
                 BufferedReader reader = new BufferedReader(fileReader);
                 String data = "";
                 System.out.println("/////////////////////////////////////////////////////////////////////////////");
                 int i = 1 ;
                 while((data = reader.readLine()) != null)
                 {
                     if(i == 1 )
                     {
                         System.out.println("Date ::::: " +data );
                         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                          
                     }
                     if(i == 2 )
                     {
                         System.out.println("Time ::::: " +data );
                         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                          
                     }
                     if(i == 3)
                     {
                         System.out.println("Transaction ::::: " +data );
                         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                         i =0;
                     } 
                     i++;
                 }
                 System.out.println("/////////////////////////////////////////////////////////////////////////////");
                 reader.close();
                 if(index == 0)
                 {
                     CustomerChoicesToChoose cctc = new CustomerChoicesToChoose();
                     cctc.CustomerChoose(accountNo);
                 }
                 else
                 {
                     AdminChoices ac = new AdminChoices();
                     ac.adminChoices();
                 }
           }
           catch (Exception e) 
           {
               System.out.println(" You dont have any  transaction................");
               if(index == 0)
                 {
                     CustomerChoicesToChoose cctc = new CustomerChoicesToChoose();
                     cctc.CustomerChoose(accountNo);
                 }
                 else
                 {
                     AdminChoices ac = new AdminChoices();
                     ac.adminChoices();
                 }
            }
    }
}
