package Customer.transaction;

import Customer.CustomerChoicesToChoose;
import bankingsystem.Input;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
 

public class CustomerTransaction 
{
    
       public void transactionHistorySave(String accountNo, int amount)
       {
           try
           {
                 LocalDate date = LocalDate.now();
                 String currentDate = date.toString();
                 LocalTime time = LocalTime.now();
                 String currentTime = time.toString();
                 FileWriter fileWriter = new FileWriter(accountNo+"transactionhistory.txt", true);
                 BufferedWriter writer = new BufferedWriter(fileWriter);
                 writer.write(currentDate);
                 writer.newLine();
                 writer.write(currentTime);
                 writer.newLine();
                 writer.write(Integer.toString(amount));
                 writer.newLine();
                 writer.close();
           }
           catch (Exception e) 
           {
           }
       }
       public void createFile(String accountNo, int amount)
       {
           try
           {
               FileWriter fileWriter = new FileWriter(accountNo+"transaction.txt");
               BufferedWriter writer = new BufferedWriter(fileWriter);
               writer.close();
               transactionAmountToSave(accountNo, amount, 0);
           } 
           catch (Exception e) 
           {
               System.out.println("small"+e);
           }
       }
       public void transactionAmountToSave(String accountNo, int amount, int index)
       {
              try 
              {
                     String currentBalance = "";
                     FileReader fileReader = new FileReader(accountNo+"transaction.txt");
                     BufferedReader reader = new BufferedReader(fileReader);
                     currentBalance = reader.readLine();
                     if(currentBalance == null)
                     {
                         String amountS = Integer.toString(amount);
                         FileWriter fileWriter = new FileWriter(accountNo+"transaction.txt" ,false);
                         fileWriter.write(amountS);
                         fileWriter.close();
                     }
                     else
                     {
                         int currentAmount = Integer.parseInt(currentBalance);
                         if(index  == 0)
                         {
                             currentAmount = currentAmount + amount;
                         }
                         if(index == 1)
                         {
                             currentAmount = currentAmount - amount;
                         }
                         FileWriter fileWriter = new FileWriter(accountNo+"transaction.txt" ,false);
                         fileWriter.write(Integer.toString(currentAmount));
                         fileWriter.close();
                     }
                     if(index == 0)
                     {
                         transactionHistorySave(accountNo, amount);
                     }
              } 
              catch (Exception e) 
              {          
                  
                  createFile(accountNo, amount);
              }
       }
       public void customerTransaction(String accountNumber)
       {
           Input input = new Input();
           try
           {
                  System.out.println("/////////////////////////////////////////////////////////////////////////////");
                  System.out.println("Enter the Amount :: ");
                  int amount = input.integerBug();
                  if(amount  > 0)
                  {
                      transactionAmountToSave(accountNumber, amount, 0);
                      System.out.println("Transfer Successfully !!! ......................");
                      CustomerChoicesToChoose cctc = new CustomerChoicesToChoose();
                      cctc.CustomerChoose(accountNumber);
                  }
                  else
                  {
                      System.out.println("/////////////////////////////////////////////////////////////////////////////");
                      System.out.println("Amount is Greater than 0 Please Enter amount GREATER THAN 0 ................ ");
                      customerTransaction(accountNumber);
                  }
           } 
           catch (Exception e) {
           }
       }
    
}
