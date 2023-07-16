package Customer.customerEditData;

import Admin.AdminChoices;
import Customer.CreateAccount.CreateAccountOfCustomer;
import Customer.CustomerChoicesToChoose;
import bankingsystem.Input;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class CustomerEditData 
{
       boolean check = true;
       Input input = new Input();
       CreateAccountOfCustomer caoc = new CreateAccountOfCustomer();
       
       public void replaceData(String fileName)
    {
        try
        {
            FileReader fileReader = new FileReader("temp.txt");
            FileWriter fileWriter = new FileWriter(fileName,false);
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
       
       
       public void updateData(String fileName, String valueOfUpdate, int index)
       {
        try
        {
            FileReader fileReader = new FileReader(fileName);
            FileWriter fileWriter = new FileWriter("temp.txt",false);
            BufferedReader reader= new BufferedReader(fileReader);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            
            String data = "";
            int i =0;
            while((data = reader.readLine()) != null)
            {
                if(i==index)
                {
                     data = data.replaceAll(data, valueOfUpdate);
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
            replaceData(fileName);
            System.out.println("SUCCESSFULLY UPDATE!!!");
          }
           catch(Exception e){}
       }
       public void editData(String accountNumber, int index)
       {
             try
             {
                     accountNumber = accountNumber+".txt";
                     while(check)
                     {
                          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");  
                          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");  
                          System.out.println("+++++++++++++ A  :  Update your Name +++++++++++++++++++++");
                          System.out.println("+++++++++++++ B  :  Update your Gender ++++++++++++++++++++");
                          System.out.println("+++++++++++++ C  :  Update your Phone Number  ++++++++++++++");
                          System.out.println("+++++++++++++ D  :  Update your Address  ++++++++++++++++++");
                          System.out.println("+++++++++++++ E  :  Update your Account Type +++++++++++++++");
                          System.out.println("+++++++++++++ F  :  Update your Gmail +++++++++++++++++++++");
                          System.out.println("+++++++++++++ X  :  Exit ++++++++++++++++++++++++++++++++");
                          System.out.println("+++++++++++++ Enter your Choice ::: ");
                          String choice =  input.inputString();
                          choice = choice.toUpperCase().trim();
                          switch(choice)
                          {
                                case "A" :
                                      System.out.println("Enter  Name :::: ");
                                      String temp = input.inputString();
                                      temp = temp.trim();
                                      updateData(accountNumber, temp, 2);
                                      break;
                                 case "B" :
                                      System.out.println("Gender Choice :::: ");
                                      temp = caoc.genderChoice();
                                      temp = temp.trim();
                                      updateData(accountNumber, temp, 3);
                                      break;
                                case "C" :
                                      System.out.println("Enter phone No :::: ");
                                      long tmp = input.longBug();
                                      updateData(accountNumber, Long.toString(tmp), 4);
                                      break;     
                                case "D" :
                                      System.out.println("Enter Address :::: ");
                                      temp =  input.inputString();
                                      temp = temp.trim();
                                      updateData(accountNumber, temp, 5);
                                      break;
                                case "E" :
                                      System.out.println("Choose Account Type :::: ");
                                      temp =  caoc.accountTypeChoose();
                                      temp = temp.trim();
                                      updateData(accountNumber, temp, 6);
                                      break;
                                case "F" :
                                      System.out.println("Enter Gmail :::: ");
                                      temp =  input.inputString();
                                      temp = temp.trim();
                                      updateData(accountNumber, temp, 7);
                                      break;
                                case "X" :
                                      check = false;
                                      break;
                                default:
                                    System.out.println("Enter the Value between the given Choices ...........................");
                                           
                          }
                     }
                     if(check == false)
                     {
                         if(index == 0 ){
                             CustomerChoicesToChoose cctc = new CustomerChoicesToChoose();
                             cctc.CustomerChoose(accountNumber);
                         }
                         if(index  == 1){
                               AdminChoices ac = new AdminChoices();
                               ac.adminChoices();
                         }
                     }
             }
             catch (Exception e) 
             {
              }
       }
}
