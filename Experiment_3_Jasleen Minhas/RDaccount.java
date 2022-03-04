// Performed By Jasleen Minhas 
// UID: Jasleen Minhas
import java.util.Scanner;

public class RDaccount extends UserAccount {
    // Data Members of RDaccount Class
    double RDInterestRate;
    double RDMonthlyAmount;
    int no_of_months;
    double general_InterestRate, senCitizen_InterestRate;
    Scanner RD_Scanner = new Scanner(System.in);

    // Overriding the calculateBankInterest method from UserAccount class
    @Override
    double calculateBankInterest(double amount) throws Invalid_Months_Exception,Invalid_Amount_Exception ,Invalid_Age_Exception {
        this.RDMonthlyAmount = amount;

        System.out.print("Enter RD holder age: ");
        int age_of_Account_Holder = RD_Scanner.nextInt();
        System.out.print("Enter the number of months you paid payments: ");
        no_of_months = RD_Scanner.nextInt();
        
        // Expections
        if (RDMonthlyAmount< 0) 
            throw new Invalid_Amount_Exception();
        if (no_of_months<0)
            throw new Invalid_Months_Exception();
        if (age_of_Account_Holder<0)
            throw new Invalid_Age_Exception();
    
        if (no_of_months >= 0 && no_of_months <= 6) {
            general_InterestRate = .0750;
            senCitizen_InterestRate = 0.080;
        } else if (no_of_months >= 7 && no_of_months <= 9) {
            general_InterestRate = .0775;
            senCitizen_InterestRate = 0.0825;
        } else if (no_of_months >= 10 && no_of_months <= 12) {
            general_InterestRate = .0800;
            senCitizen_InterestRate = 0.0850;
        } else if (no_of_months >= 13 && no_of_months <= 15) {
            general_InterestRate = .0825;
            senCitizen_InterestRate = 0.0875;
        } else if (no_of_months >= 16 && no_of_months <= 18) {
            general_InterestRate = .0850;
            senCitizen_InterestRate = 0.0900;
        } else if (no_of_months >= 22) {
            general_InterestRate = .0875;
            senCitizen_InterestRate = 0.0925;
        }
        RDInterestRate = (age_of_Account_Holder < 50) ? general_InterestRate : senCitizen_InterestRate;
        
        // Interest = P * n * (n+1) * r / 24
        // where:
        // P is the monthly deposit,
        // n is number of months,
        // r is the annual interest rate.
        return RDMonthlyAmount * no_of_months * (no_of_months+1) * RDInterestRate/24;
    }
}