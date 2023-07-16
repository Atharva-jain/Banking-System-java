package Customer.CreateAccount; 

import HomePage.FrontPage;
import bankingsystem.Input;

public class CreateAccountOfCustomer 
{
        Input input = new Input();
        protected String custName, custGender, custEmail, custPassword, custAddress, accoutType;
        protected long  mobileNo;
        
         public String genderChoice()
         {
           boolean check = true;
           String genderChoiceDemo = "";
           while(check == true)
           {
               System.out.println("M : Male");
               System.out.println("F : Female");
               System.out.println("C : Custom");
               System.out.println("-------------------------------------------------------------------------------");
               System.out.println("Enter your Choice :: ");
               try
               {
                   String choice = input.inputString();
                   choice = choice.toUpperCase().trim();
                   switch(choice)
                  {
                      case "M" :
                         genderChoiceDemo = "Male" ; 
                         check = false;
                          break;
                      case "F" :
                          genderChoiceDemo = "Female" ; 
                          check = false;
                          break;
                      case "C" : 
                          genderChoiceDemo = "Custom" ; 
                          check = false;
                          break;
                      default:
                          System.out.println("Enter Choice Between (M,F,C) ..............");
               }
               } catch (Exception e) 
               {
                    
               }
               
           }
           return genderChoiceDemo;
      }
     
        public String accountTypeChoose()
        {
           boolean check = true;
           String accountTypeChoiceDemo = "";
           while(check == true)
           {
               System.out.println("A : Saving Account");
               System.out.println("B : Current Account");
               System.out.println("-------------------------------------------------------------------------------");
               System.out.println("Enter your Choice :: ");
               try
               {
                   String choice = input.inputString();
                   choice = choice.toUpperCase().trim();
                   switch(choice)
                  {
                      case "A" :
                          accountTypeChoiceDemo = "Saving Account" ; 
                          check = false;
                       break;
                   case "B" :
                         accountTypeChoiceDemo = "Current Account" ; 
                         check = false;
                       break;
                   default:
                       System.out.println("Enter Choice Between (A,B) ..............");
               }
               } catch (Exception e) 
               {
 
               }
           }
           return accountTypeChoiceDemo;
        }
        public void customerDetails()
        {
               System.out.println("------------------------------------------------------------------");
               System.out.println("Enter Customer Name ::: ");
               custName = input.inputString();
               System.out.println("------------------------------------------------------------------");
               System.out.println("Choose Gender ::: ");
               custGender = genderChoice();
               System.out.println("------------------------------------------------------------------");
               System.out.println("Enter Mobile Number ::: ");
               mobileNo = input.longBug();
               System.out.println("------------------------------------------------------------------");
               System.out.println("Enter Address ::: ");
               custAddress = input.inputString();
               System.out.println("------------------------------------------------------------------");
               System.out.println("Choose Account Type ::: ");
               accoutType = accountTypeChoose();
               System.out.println("------------------------------------------------------------------");
               System.out.println("Enter your Gmail ::: ");
               custEmail = input.inputString();
               System.out.println("------------------------------------------------------------------");
               System.out.println("Enter Password ::: ");
               custPassword = input.inputString();
               storeCustomerData cd = new storeCustomerData();
               cd.storeData(custName, custGender, mobileNo, custAddress, accoutType, custEmail, custPassword);
               System.out.println("Account Created !!! ..................");
               FrontPage fp = new FrontPage();
               fp.design();
               
        }
        
    
}
