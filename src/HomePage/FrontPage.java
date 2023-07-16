 
package HomePage;

import Admin.AdminChoices;
import Admin.AdminLogin.AdminLoginToAccess;
import Customer.CreateAccount.CreateAccountOfCustomer;
import Customer.CreateAccount.customerForgotPassword.CustomerForgotPassword;
import Customer.customerLogin.CustomerLogin;
import bankingsystem.Input;

 
public class FrontPage 
{
      public void design()
      {
          System.out.println("/////////////////////////////////////////////////////////////////////////////");
          System.out.println("/////////////////////////////////////////////////////////////////////////////");
          System.out.println("+++++++++++ Banking System +++++++++++++");
          System.out.println("/////////////////////////////////////////////////////////////////////////////");
          System.out.println("/////////////////////////////////////////////////////////////////////////////");
          System.out.println("--------------------------------------------------------------");
          System.out.println("+++++++++++ A. Admin Login +++++++++++++");
          System.out.println("+++++++++++ B. Customer Login +++++++++++");
          System.out.println("+++++++++++ C. Create Account  +++++++++++");
          System.out.println("+++++++++++ D. Forgot Password  ++++++++++");
          System.out.println("+++++++++++ X. Exit  +++++++++++++++++++");
          System.out.println("--------------------------------------------------------------");
          System.out.println("+++++++++++ Enter your Choice ::::::::::");
          Input input = new Input();
          String str = input.inputString();
          str = str.toUpperCase().trim();
          if(str.equals("A"))
          {
               AdminLoginToAccess access = new AdminLoginToAccess();
               access.loginData();
          }
          else if(str.equals("B"))
          {
                CustomerLogin cl = new CustomerLogin();
                cl.login();
          }
          else if(str.equals("C"))
          {
                 CreateAccountOfCustomer caoc = new CreateAccountOfCustomer();
                 caoc.customerDetails();
          }
          else if(str.equals("D"))
          {
                  CustomerForgotPassword cfp = new CustomerForgotPassword();
                  cfp.forgotPassword();
          }
          else if(str.equals("X"))
          {
              System.exit(0);
          }
          else
          {
              System.out.println("--- Please Enter the Value Between given Choices................... ");
              design();
          }
      }
}
