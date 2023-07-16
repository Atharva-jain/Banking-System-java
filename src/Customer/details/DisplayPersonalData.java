 
package Customer.details;
 
import Admin.AdminChoices;
import Customer.CustomerChoicesToChoose;
import java.io.BufferedReader;
import java.io.FileReader;

public class DisplayPersonalData 
{
      public void displayPersonalData(String accountNo, int index)
      {    
           try
           {
                 FileReader fileReader = new FileReader(accountNo+".txt");
                 BufferedReader reader = new BufferedReader(fileReader);
                 String data = "";
                 System.out.println("/////////////////////////////////////////////////////////////////////////////");
                 int i = 0 ;
                 while((data = reader.readLine()) != null)
                 {
                     if(i == 0 )
                     {
                         System.out.println("ID ::::: " +data );
                         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                          
                     }
                     if(i == 1 )
                     {
                         System.out.println("Account Number ::::: " +data );
                         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                          
                     }
                     if(i == 2 )
                     {
                         System.out.println("Name ::::: " +data );
                         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                          
                     }
                     if(i == 3)
                     {
                         System.out.println("Male ::::: " +data );
                         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                
                     } 
                     if(i == 4 )
                     {
                         System.out.println("Phone Number ::::: " +data );
                         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                          
                     }
                     if(i == 5 )
                     {
                         System.out.println("Address ::::: " +data );
                         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                          
                     }
                     if(i == 6 )
                     {
                         System.out.println("Account Type ::::: " +data );
                         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                          
                     }
                     if(i == 7 )
                     {
                         System.out.println("Gmail ::::: " +data );
                         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                          
                     }
                     i++;
                 }
                 System.out.println("/////////////////////////////////////////////////////////////////////////////");
                 reader.close();
                 if(index == 0){
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
               System.out.println(" You dont have any fund transaction................");
            }
      } 
}
