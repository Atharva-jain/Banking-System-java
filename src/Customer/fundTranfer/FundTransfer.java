
package Customer.fundTranfer;
import Customer.CustomerChoicesToChoose;
import Customer.transaction.CustomerTransaction;
import bankingsystem.CheckFile;
import bankingsystem.Input;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
public class FundTransfer
{
      boolean check = false;
      private int balance;
      Input input = new Input();
      CheckFile cf = new CheckFile();
      
      public void savedfundTransferHistory(String accountNo, int money)
      {
          try
          {
                 LocalDate date = LocalDate.now();
                 String currentDate = date.toString();
                 LocalTime time = LocalTime.now();
                 String currentTime = time.toString();
                 FileWriter fileWriter = new FileWriter(accountNo+"fundhistory.txt", true);
                 BufferedWriter writer = new BufferedWriter(fileWriter);
                 writer.write(currentDate);
                 writer.newLine();
                 writer.write(currentTime);
                 writer.newLine();
                 writer.write(Integer.toString(money));
                 writer.newLine();
                 writer.close();
          }
          catch (Exception e) {
          }
          
      }
      
      public void fundIncrement(String accountNo, int balanceExpend)
      {
            try
            {
         
               FileReader fileReader = new FileReader(accountNo+"transaction.txt");
               BufferedReader reader = new BufferedReader(fileReader);
               String data = reader.readLine();
                System.out.println("Another account amount : "+data);
               int  currentBalance = Integer.parseInt(data);
               currentBalance = currentBalance + balanceExpend;
                System.out.println("increment value : "+currentBalance);
               reader.close();
               
               FileWriter fileWriter = new FileWriter(accountNo+"transaction.txt", false);
               BufferedWriter writer = new BufferedWriter(fileWriter);
               writer.write(Integer.toString(currentBalance));
               writer.close();
                
            }
            catch (Exception e) 
            {
             }
      }
      
      public int  fetchBalance(String accountNo)
      {
           try 
           {
               FileReader fileReader = new FileReader(accountNo+"transaction.txt");
               BufferedReader reader = new BufferedReader(fileReader);
               String data = reader.readLine();
               balance = Integer.parseInt(data);
               System.out.println("Balance ::: "+data);
               reader.close();
           }
           catch (Exception e) 
           {
            }
           return balance;
      }
      public boolean fetchData(String accountNo)
      {
          try
          {
               check = false;
               FileReader fileReader = new FileReader(accountNo+".txt");
               BufferedReader reader = new BufferedReader(fileReader);
               String data = "";
               int i = 0;
               while((data = reader.readLine()) != null)
               {
  
                     if(i==0)
                     {
                         System.out.println("Customer  ID  ::: "+data);
                     }
                     if(i==2)
                     {
                         System.out.println("Customer Name ::: "+data);
                     }
                      if(i==6)
                     {
                          System.out.println("Customer Type ::: "+data);
                     }
                     i++;
               }
               reader.close();
               fetchBalance(accountNo);
               check = true;
          } catch (Exception e) 
          {
              System.out.println("Account no is not available you want to try again(Yes / No)............");
              String str = input.inputString();
              str = str.toUpperCase().trim();
              if(str.equals("YES"))
              {
                  transferFund(accountNo);
              }
              else
              {
                   CustomerChoicesToChoose cctc = new CustomerChoicesToChoose();
                   cctc.CustomerChoose(accountNo);
              }
              check = false;
          }
          return check;    
      }
      public void transferFund(String accountNo)
      {
          try
          {
                 System.out.println("/////////////////////////////////////////////////////////////////////////////");
                 System.out.println("From Account No :::  " +accountNo);
                 fetchData(accountNo);
                 System.out.println("/////////////////////////////////////////////////////////////////////////////");
                 System.out.println("/////////////////////////////////////////////////////////////////////////////");
                 System.out.println("To (Enter Transferer account No ) ::::::::: ");
                 String anotherAccountNo = input.inputString();
                 boolean checkDemo = cf.fileIsAvailable(anotherAccountNo);
                 if(checkDemo)
                 {
                     fetchData(anotherAccountNo);
                     System.out.println("/////////////////////////////////////////////////////////////////////////////");
                     System.out.println("Enter Amount To Transfer Money ::: ");
                     int money = input.integerBug();
                     int balanceDemo = fetchBalance(accountNo);
                     if( balanceDemo > money   && balanceDemo > 0 && money > 0)
                     {
                          CustomerTransaction ct = new CustomerTransaction();
                          ct.transactionAmountToSave(accountNo, money, 1);
                          System.out.println("Fund Transfer Successfully !!! ...............");
                          fundIncrement(anotherAccountNo, money);
                          savedfundTransferHistory(accountNo, money);
                          CustomerChoicesToChoose cctc = new CustomerChoicesToChoose();
                          cctc.CustomerChoose(accountNo);
                     }
                     else
                     {
                         System.out.println("Ensufficient Balance !!!! .................");
                         System.out.println("you want to try again (Yes / No )");
                         String str = input.inputString();
                         str = str.toUpperCase().trim();
                         if(str.equals("YES"))
                         {
                            transferFund(accountNo);
                        }
                       else
                        {
                                CustomerChoicesToChoose cctc = new CustomerChoicesToChoose();
                                cctc.CustomerChoose(accountNo);
                       }
                     }
                 }
                 else
                 {
                         System.out.println("This Account Number is not available ......................");
                         System.out.println("you want to try again (Yes / No )");
                         String str = input.inputString();
                         str = str.toUpperCase().trim();
                         if(str.equals("YES"))
                         {
                              transferFund(accountNo);
                         }
                         else
                         {
                               CustomerChoicesToChoose cctc = new CustomerChoicesToChoose();
                              cctc.CustomerChoose(accountNo);
                         }
                 }
          }
          catch (Exception e) 
          {
              
          }
      }
}
