
package Admin.DeleteCustomerAccount;

import Admin.AdminChoices;
import Customer.details.FundDetails;
import bankingsystem.CheckFile;
import bankingsystem.Input;
import com.oracle.nio.BufferSecrets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class DeleteCustomerAccountByAdmin 
{
     Input input = new Input();
     
     public void replaceData()
     {
         try
         {
            
               FileReader fileReader = new FileReader("temp.txt");
               BufferedReader reader = new BufferedReader(fileReader);
               FileWriter fileWriter = new FileWriter("AccountNumbers.txt", false);
               BufferedWriter writer = new BufferedWriter(fileWriter);
               String data =  "";
               while((data = reader.readLine()) != null)
               {
                      writer.write(data);
                      writer.newLine();
               }
               writer.close();
               reader.close();
         }
         catch (Exception e) 
         {
         }
     }
     
     public void deleteDataFromCheckFileData(String accountNumber)
     {
         try
         {
               FileReader fileReader = new FileReader("AccountNumbers.txt");
               BufferedReader reader = new BufferedReader(fileReader);
               FileWriter fileWriter = new FileWriter("temp.txt", false);
               BufferedWriter writer = new BufferedWriter(fileWriter);
               String data =  "";
               while((data = reader.readLine()) != null)
               {
                      if(data.equals(accountNumber))
                      {
                          writer.write("");
                      }
                      else
                      {
                         writer.write(data);
                         writer.newLine();
                      }
               }
               writer.close();
               reader.close();
               replaceData();
         }
         catch (Exception e) 
         {
         }
     }
     
     public void deleteFile(String accountNumber)
     {
           File file = new File(accountNumber+".txt");
            if(file.delete())
            {
                System.out.println("File Deleted Successfully ...........");
                deleteDataFromCheckFileData(accountNumber);
            }
            else
            {
                System.out.println("File are not Deleted  ...........");
                AdminChoices ac = new AdminChoices();
                ac.adminChoices();
            }
     }
     
     public void deleteData()
     {
           System.out.println("/////////////////////////////////////////////////////////////////////////////");
          System.out.println("Enter there Account Numer  :::: ");
          int accountNo = input.integerBug();
          CheckFile cf = new CheckFile();
          boolean check =  cf.fileIsAvailable(Integer.toString(accountNo));
          System.out.println("/////////////////////////////////////////////////////////////////////////////");
          if(check)
          {
               deleteFile(Integer.toString(accountNo));
               
          }
          else
          {
                    System.out.println("Acount Number is Not Available  !! ...............");
                    System.out.println("Invalid Information you want to try Again (Yes / No) :: ");
                    String str1 = input.inputString();
                    str1 = str1.toUpperCase().trim();
                    if(str1.equals("YES"))
                    {
                        deleteData();
                    }
                    else
                    {
                            AdminChoices ac = new AdminChoices();
                           ac.adminChoices();
                    }
          }
     }
    
}
