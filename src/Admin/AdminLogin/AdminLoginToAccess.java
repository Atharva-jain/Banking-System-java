
package Admin.AdminLogin;

import Admin.AdminChoices;
import HomePage.FrontPage;
import bankingsystem.Input;


public class AdminLoginToAccess
{
      Input input = new Input();
      public void loginData()
      {
            System.out.println("Enter Username ::: ");
            String username = input.inputString();
            System.out.println("Enter Password ::: ");
            String password = input.inputString();
            if(username.equals("user")  && password.equals("user"))
           {
                   System.out.println("Login Successful !!! ...........................");
                   AdminChoices ac = new AdminChoices();
                   ac.adminChoices();
           }
           else
           {
                    System.out.println("Invalid Username / Password !! ...............");
                    System.out.println("Invalid Information you want to try Again (Yes / No) :: ");
                    String str1 = input.inputString();
                    str1 = str1.toUpperCase().trim();
                    if(str1.equals("YES"))
                    {
                        loginData();
                    }
                    else
                    {
                         FrontPage fp = new FrontPage();
                         fp.design();
                    }
           }
      }
    
}
