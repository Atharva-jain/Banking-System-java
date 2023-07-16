
package bankingsystem;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Input 
{
     BufferedReader obj =new BufferedReader(new InputStreamReader(System.in));
     String input = "";
     int n = 0 ;
     long l;
     public String inputString()
      {
           try
           {
               input = obj.readLine();
           } catch (Exception e) 
           {
                e.printStackTrace();
            }
           return input;
       }     
       public int integerBug()
       {
           Scanner in = new Scanner(System.in);
           try
           {
              n = in.nextInt();
           }
           catch(Exception e)
           {
                System.out.println("Enter Proper value ::::");
                integerBug();
            }
           return n;
       }
       public long longBug()
      {
         Scanner in = new Scanner(System.in);
         try
         {
             l = in.nextLong();
         }
         catch(Exception e)
         {
            System.out.println("Enter Proper value ::::");
            longBug();
         }
         return l;
     }
    
}
