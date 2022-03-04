// Performed By Jasleen Minhas 
// UID: Jasleen Minhas
import java.util.Scanner;

class SBaccount extends UserAccount {
    // Data Members of SBaccount Class
    double SBamount, SbInterestRate;
    Scanner SB_Scanner = new Scanner(System.in);
    
    // Overriding the calculateBankInterest method from UserAccount class
    @Override
    double calculateBankInterest(double amount) throws Invalid_Amount_Exception{
        this.SBamount = amount;
        
        // Expections
        if(SBamount < 0 )
            throw new Invalid_Amount_Exception();
    
        System.out.println("\nSelect SB account type: \n1. Normal \n2. NRI ");
        System.out.print("Enter choice (1 or 2): ");
        int accountChoice = SB_Scanner.nextInt();
        switch (accountChoice) {
            case 1:
                SbInterestRate = .04;
                break;
            case 2:
                SbInterestRate = .06;
                break;
            default:
                System.out.println("Please choose right account again");
        }
     // SBInterest = Principle * rate 
     return SBamount * SbInterestRate ;
    }
}