// Performed By Jasleen Minhas 
// UID: Jasleen Minhas
import java.util.Scanner;

// Abstract Account class that will be inherited by other classes
public abstract class UserAccount {
    double interestRate;
    double amount; 

    abstract double calculateBankInterest(double amount)
            throws Invalid_Months_Exception, Invalid_Age_Exception, Invalid_Amount_Exception, Invalid_Days_Exception;

    // Getting the user's name
    Scanner input = new Scanner(System.in);
    String getUserName() {
        System.out.println("Hey There! Kindly tell you name: ");
        String name = input.next();
        return name;
    }
}