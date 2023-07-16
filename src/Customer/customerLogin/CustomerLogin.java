package Customer.customerLogin;

import Customer.CustomerChoicesToChoose;
import bankingsystem.Input;
import java.io.BufferedReader;
import java.io.FileReader;

public class CustomerLogin 
{
      Input input = new Input();
      public String getPassword(int accountNumber)
      {
          String accountNumberS = Integer.toString(accountNumber);
          String password ="";
          try
          {
              FileReader fileReader = new FileReader(accountNumberS+".txt");
              BufferedReader reader = new BufferedReader(fileReader);
              String data =  " ";
              int i  = 0 ;
              while((data = reader.readLine()) != null)
              {
                  if(i == 8)
                  {
                      password = data;
                      break;
                  }
                   i++;
              }
              reader.close();
          } 
          catch (Exception e) 
          {
              System.out.println("////////////////////////////////////////////////////////////////");
              System.out.println("Account no is invaild you want to try again(Yes / No)............");
              String str = input.inputString();
              str = str.toUpperCase().trim();
              if(str.equals("YES"))
              {
                  login();
              }
              else
              {
                  // home
              }
          }
          return password;
      }
      
      public String getGmail(int accountNumber)
      {
          String accountNumberS = Integer.toString(accountNumber);
          String gmail ="";
          try
          {
              FileReader fileReader = new FileReader(accountNumberS+".txt");
              BufferedReader reader = new BufferedReader(fileReader);
              String data =  " ";
              int i  = 0 ;
              while((data = reader.readLine()) != null)
              {
                  if(i == 7)
                  {
                      gmail = data;
                      break;
                  }
                   i++;
              }
              reader.close();
          } 
          catch (Exception e) 
          {
              System.out.println("/////////////////////////////////////////////////////////////////////////////");
              System.out.println("Account no is invaild you want to try again(Yes / No)............");
              String str = input.inputString();
              str = str.toUpperCase().trim();
              if(str.equals("YES"))
              {
                  login();
              }
              else
              {
                  // home
              }
          }
          return gmail;
      }
      
      public void login()
      {
          try
          {
              System.out.println("/////////////////////////////////////////////////////////////////////////////");
              System.out.println("Enter Account No ::: ");
              int  accontNumber = input.integerBug();
              System.out.println("Enter Gmail :: ");
              String gmail = input.inputString();
              gmail = gmail.toUpperCase().trim();
              System.out.println("Enter Password :: ");
              String password = input.inputString();
              password = password.trim();
              String gmailCheck = getGmail(accontNumber);
              String passwordCheck =  getPassword(accontNumber);
              if(gmailCheck.equals(gmail)  && passwordCheck.equals(password))
              {
                   System.out.println("Successfully Login !!!...............");
                   CustomerChoicesToChoose cctc = new CustomerChoicesToChoose();
                   cctc.CustomerChoose(Integer.toString(accontNumber));
              }
              else
              {
                   System.out.println("/////////////////////////////////////////////////////////////////////////////");
                   System.out.println("Invalid Username / Password you want to try again(Yes / No)............");
                   String str = input.inputString();
                   str = str.toUpperCase().trim();
                   if(str.equals("YES"))
                  {
                      login();
                  }
                  else
                 {
                   // home
                 }
              }
              
          } catch (Exception e) {
          }
      }
    
}
