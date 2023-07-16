 
package Customer.CreateAccount;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class storeCustomerData 
{
     public void storeAccountNumber(String accountNo)
     {
         try
         {
                FileWriter writer = new FileWriter("AccountNumbers.txt",true);
                BufferedWriter buffWriter = new BufferedWriter(writer);
                buffWriter.write(accountNo);
                buffWriter.newLine();
                buffWriter.close();
         }
         catch (Exception e) {
         }
     }
     public int getCustomerID()
    {
        //  these variable is used to store unique value 
         int number = 0 ;
         try
         {
                FileReader fileReader = new FileReader("CustomerID.txt");
                BufferedReader reader = new BufferedReader(fileReader);
                String data = reader.readLine();
                number = Integer.parseInt(data);
                number = number + 1;
                reader.close();
                FileWriter writer = new FileWriter("CustomerID.txt", false);
                BufferedWriter buffWriter = new BufferedWriter(writer);
                buffWriter.write(Integer.toString(number));
                buffWriter.close();
                
         }
         catch (Exception e) 
         {
         }
         return number;
    }
    
     public int getAccountNumber()
    {
        //  these variable is used to store unique value 
         int number = 0 ;
         try
         {
                FileReader fileReader = new FileReader("AccountNo.txt");
                BufferedReader reader = new BufferedReader(fileReader);
                String data = reader.readLine();
                number = Integer.parseInt(data);
                number = number + 1;
                reader.close();
                FileWriter writer = new FileWriter("AccountNo.txt", false);
                BufferedWriter buffWriter = new BufferedWriter(writer);
                buffWriter.write(Integer.toString(number));
                buffWriter.close();
                
         }
         catch (Exception e) 
         {
         }
         return number;
    }
         
       public void storeData(String custName, String custGender, long mobileNo, String custAddress, String accountType, 
               String custGmail, String custPassword)
       {
           int customerID = getCustomerID();
           int accountNumber = getAccountNumber();
           String customerIDS = Integer.toString(customerID);
           String accountNumberS = Integer.toString(accountNumber);
           custGmail = custGmail.toUpperCase().trim();
           custPassword = custPassword.trim();
           try
           {
               FileWriter fileWriter = new FileWriter(accountNumberS+".txt",false);
               BufferedWriter writer = new BufferedWriter(fileWriter);
               writer.write(customerIDS);
               writer.newLine();
               writer.write(accountNumberS);
               writer.newLine();
               writer.write(custName);
               writer.newLine();
               writer.write(custGender);
               writer.newLine();
               writer.write(Long.toString(mobileNo));
               writer.newLine();
               writer.write(custAddress);
               writer.newLine();
               writer.write(accountType);
               writer.newLine();
               writer.write(custGmail);
               writer.newLine();
               writer.write(custPassword);
               writer.newLine();
               writer.close();
               storeAccountNumber(accountNumberS);
               System.out.println("/////////////////////////////////////////////////////////////////////////////");
               System.out.println("Your Customer ID is "+customerIDS);
               System.out.println("Your Account Number is " +accountNumberS);
               System.out.println("/////////////////////////////////////////////////////////////////////////////");
           }
           catch (Exception e) 
           {
           }
           
       }
    
}
