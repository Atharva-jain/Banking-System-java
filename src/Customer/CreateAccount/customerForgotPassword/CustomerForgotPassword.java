 
package Customer.CreateAccount.customerForgotPassword;

import Customer.CustomerChoicesToChoose;
import HomePage.FrontPage;
import bankingsystem.CheckFile;
import bankingsystem.Input;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CustomerForgotPassword 
{
    Input input = new Input();
    
    public void replaceData(String accountNo)
    {
        try
        {
            
            FileReader fileReader = new FileReader("temp.txt");
            FileWriter fileWriter = new FileWriter(accountNo,false);
            BufferedReader reader= new BufferedReader(fileReader);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            String data = "";
            int i =0;
            while((data = reader.readLine()) != null)
            {
                writer.write(data);
                writer.newLine();
                i++;
            }
            writer.close();
            reader.close();
        }
        catch (Exception e) 
        {
           
        }
    }
    
    
    public void replacePassword(String accountNo, String password)
    {
        try
        {
            
            FileReader fileReader = new FileReader(accountNo);
            FileWriter fileWriter = new FileWriter("temp.txt",false);
            BufferedReader reader= new BufferedReader(fileReader);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            
            String data = "";
            int i =0;
            while((data = reader.readLine()) != null)
            {
                if(i==8)
                {
                     data = data.replaceAll(data, password);
                     writer.write(data);
                     writer.newLine();
                }
                else
                {
                    writer.write(data);
                    writer.newLine();
                }
                i++;
            }
            writer.close();
            reader.close();
            replaceData(accountNo);
        }
        catch (Exception e) 
        {
            
        }
    }
    
    
    public boolean checkValid(String accountNo)
    {
        String gmail = "" , phone = "", accountNoS="";
        System.out.println("Enter Gmail :: ");
        String Gmail = input.inputString();
        Gmail = Gmail.toUpperCase().trim();
        System.out.println("Enter Phone No :: ");
        Long phoneNo = input.longBug();
        try
        {
               FileReader fileReader = new FileReader(accountNo);
               BufferedReader reader = new BufferedReader(fileReader);
               String data = "";
               int i = 0;
               while((data = reader.readLine()) != null)
               {
                    if(i == 4)
                    {
                         
                        phone = data;
                    }
                    if(i == 7)
                    {
                        
                        gmail = data;
                    }
                    i++;
               }
              
               if(gmail.equals(Gmail)  && phone.equals(Long.toString(phoneNo)))
               {
                   System.out.println("Enter New Password :: ");
                   String password =  input.inputString();
                   replacePassword(accountNo, password);
                   return true;
               }
               else
               {
                   System.out.println("Invalid Information you want to try Again (Yes / No) :: ");
                   String str1 = input.inputString();
                   str1 = str1.toUpperCase().trim();
                   if(str1.equals("YES"))
                   {
                       checkValid(accountNo);
                   }
                   else
                   {
                       FrontPage fp = new FrontPage();
                       fp.design();
                   }
                    
               }
               reader.close();
             
        } 
        catch (Exception e) 
        {
            System.out.println(""+e);
            FrontPage fp = new FrontPage();
            fp.design();
            
        }
        
        return false;
    }
   
    public void forgot(String accountNo)
    {
          try 
          {
              // you are user or not 
               
               boolean check = checkValid(accountNo);
               if(check)
               {
                     System.out.println("Password Chaged Successfully ...............");
                     FrontPage fp = new FrontPage();
                     fp.design();
               }
               else
               {
                    System.out.println("Password are NOT Changed !! ...............");
                    System.out.println("Invalid Information you want to try Again (Yes / No) :: ");
                    String str1 = input.inputString();
                    str1 = str1.toUpperCase().trim();
                    if(str1.equals("YES"))
                    {
                         forgot(accountNo);
                    }
                    else
                    {
                           FrontPage fp = new FrontPage();
                           fp.design();
                    }
               }
          } 
         catch (Exception e) 
         {
           
         }
    }
    public void forgotPassword()
    {
        System.out.println("/////////////////////////////////////////////////////////////////////////////");
        System.out.println("Enter Account Number :: ");
        int accountNo = input.integerBug();
        CheckFile cf = new CheckFile();
        boolean check = cf.fileIsAvailable(Integer.toString(accountNo));
        if(check)
        {
            forgot(Integer.toString(accountNo)+".txt");
        }
        else
        {
                    System.out.println("Acount Number is Not Available  !! ...............");
                    System.out.println("Invalid Information you want to try Again (Yes / No) :: ");
                    String str1 = input.inputString();
                    str1 = str1.toUpperCase().trim();
                    if(str1.equals("YES"))
                    {
                         forgotPassword();
                    }
                    else
                    {
                           FrontPage fp = new FrontPage();
                           fp.design();
                    }
        }
    }
}
