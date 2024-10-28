package Q1;
import java.io.*;
import java.util.*;
import java.text.*;
public class BankAccount {
    public BankAccount(String nm, double amt)
    {
        name = nm;
        balance = amt;
    }
    public void deposit(double dp)
    {
        balance = balance + dp;
    }
    public void withdraw(double wd)
    {
        balance = balance - wd;
    }
    public String name;
    public double balance;



    public static void main(String args[])
    {

        NumberFormat formatter = new DecimalFormat("$#,###.##");
        String name;
        var aryLst = new ArrayList<BankAccount>();
        do
        {
            Scanner kbReader = new Scanner(System.in);
            System.out.print("Please enter the name to whom the account belongs.\"Exit\" to abort");

            name = kbReader.nextLine( );
            if( !name.equalsIgnoreCase("EXIT") )
            {
                System.out.print("Please enter the amount of the deposit. ");
                double amount = kbReader.nextDouble();
                System.out.println(" "); //gives an eye-pleasing blank line
                var bankObj = new BankAccount(name, amount);
                aryLst.add(bankObj);
            }
        }while(!name.equalsIgnoreCase("EXIT"));
//Search aryList and print out the name and amount of the largest bank account
        BankAccount ba = aryLst.get(0);
        double maxBalance = ba.balance;
        String maxName = ba.name;
        for(int j = 1; j < aryLst.size( ); j++)
        {
            if (maxBalance < aryLst.get(j).balance) {
                maxBalance = aryLst.get(j).balance;
                maxName = aryLst.get(j).name;
            }
        }
        System.out.println(maxName + " " + maxBalance);
    }
}
