// Performed By Jasleen Minhas 
// UID: Jasleen Minhas
import java.util.Scanner;

public class FDaccount extends UserAccount{
    // Data Members of FDaccount Class
    double FDinterestRate;
    double FDAmount, general_InterestRate, senCitizen_InterestRate; 
    int no_of_days;
    int age_of_Account_Holder;
    Scanner FD_Scanner = new Scanner(System.in);

    // Overriding the calculateBankInterest method from UserAccount class
    @Override
    double calculateBankInterest(double amount) throws Invalid_Age_Exception,Invalid_Amount_Exception ,Invalid_Days_Exception {
        this.FDAmount = amount;

        System.out.print("Enter FD days: ");
        no_of_days = FD_Scanner.nextInt();
        System.out.print("Enter FD age holder: ");
        age_of_Account_Holder = FD_Scanner.nextInt();

        // Expections
        if (amount < 0) 
            throw new Invalid_Amount_Exception();
        if (no_of_days<0)
            throw new Invalid_Days_Exception();
        if (age_of_Account_Holder<0)
            throw new Invalid_Age_Exception();
    
        if (amount < 10000000) {
            if (no_of_days >= 7 && no_of_days <= 14) {
                general_InterestRate = 0.0450;
                senCitizen_InterestRate = 0.0500;
            } else if (no_of_days >= 15 && no_of_days <= 29) {
                general_InterestRate = 0.0470;
                senCitizen_InterestRate = 0.0525;
            } else if (no_of_days >= 30 && no_of_days <= 45) {
                general_InterestRate = 0.0550;
                senCitizen_InterestRate = 0.0600;
            } else if (no_of_days >= 45 && no_of_days <= 60) {
                general_InterestRate = 0.0700;
                senCitizen_InterestRate = 0.0750;
            } else if (no_of_days >= 61 && no_of_days <= 184) {
                general_InterestRate = 0.0750;
                senCitizen_InterestRate = 0.0800;
            } else if (no_of_days >= 185 && no_of_days <= 365) {
                general_InterestRate = 0.0800;
                senCitizen_InterestRate = 0.0850;
            }
            FDinterestRate = (age_of_Account_Holder < 50) ? general_InterestRate : senCitizen_InterestRate;
        } 
        else {
            if (no_of_days >= 7 && no_of_days <= 14) {
                FDinterestRate = 0.065;
            } else if (no_of_days >= 15 && no_of_days <= 29) {
                FDinterestRate = 0.0675;
            } else if (no_of_days >= 30 && no_of_days <= 45) {
                FDinterestRate = 0.00675;
            } else if (no_of_days >= 45 && no_of_days <= 60) {
                FDinterestRate = 0.080;
            } else if (no_of_days >= 61 && no_of_days <= 184) {
                FDinterestRate = 0.0850;
            } else if (no_of_days >= 185 && no_of_days <= 365) {
                FDinterestRate = 0.10;
            }
        }
        // FDInterest = Principle * rate * time in years
        return FDAmount * FDinterestRate * no_of_days/365;
    }
}