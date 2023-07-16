
package bankingsystem;

import java.io.BufferedReader;
import java.io.FileReader;

public class CheckFile 
{
    public boolean fileIsAvailable(String accountNumber)
    {
           boolean check = false;
           try 
           {
                 FileReader fileReader = new FileReader("AccountNumbers.txt");
                 BufferedReader reader = new BufferedReader(fileReader);
                 String data = "";
                 while((data = reader.readLine()) != null)
                 {
                       if(accountNumber.equals(data))
                       {
                           check = true;
                           break;
                       }
                 }
                
           }
           catch (Exception e) 
           {
           }
           return check;
    }    
}
