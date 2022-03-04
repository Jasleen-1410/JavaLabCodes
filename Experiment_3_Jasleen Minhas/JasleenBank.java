// Performed By Jasleen Minhas 
// UID: Jasleen Minhas
import java.util.Scanner;

public class JasleenBank {
    public static void main(String[] args) {
    	int loop = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPerformed By: Jasleen Minhas, \nUID: 20BCS6897");
        System.out.println("\n\n* * * * * * * * * * * * Welcome to the JAS BANK ;) * * * * * * * * * * * * *");
        do {
            System.out.println("\n\n* * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("Main Menu:: (Jasleen Minhas, 20BCS6897) " );
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * " +
                    "\n1." + " Interest Calculator for SB" +
                    "\n2." + " Interest Calculator for FD" +
                    "\n3." + " Interest Calculator for RD" +
                    "\n4 " + " Exit");
            
            System.out.print("\nEnter Account type (1, 2, 3 or 4): ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    SBaccount sb = new SBaccount();
                    try {
                        System.out.print("Enter the SB principal amount: ");
                        double principal = sc.nextDouble();

                        double SBinterest = sb.calculateBankInterest(principal);
                        System.out.println("\nTotal SB Interest gained by you: Rs. " + String.format("%.2f", SBinterest));
                        System.out.println("Total SB Amount you will get: Rs. " + String.format("%.2f", (SBinterest + principal)));
                    
                    } catch (Invalid_Amount_Exception e) {
                        System.out.println("Exception : Invalid amount");
                    }
                    break;

                case 2:
                    FDaccount fd = new FDaccount();
                    try {
                        System.out.print("Enter the FD principal Amount: ");
                        double principal = sc.nextDouble();
                        
                        double FDinterest = fd.calculateBankInterest(principal);
                        System.out.println("\nTotal FD Interest gained by you: Rs. " + String.format("%.2f", FDinterest));
                        System.out.println("Total FD Amount you will get: Rs. " + String.format("%.2f", (FDinterest + principal)));

                    } catch (Invalid_Age_Exception e) {
                        System.out.println("Invalid Age Entered");
                    } catch (Invalid_Amount_Exception e) {
                        System.out.println("Invalid Amount Entered");
                    } catch (Invalid_Days_Exception e) {
                        System.out.println("Invalid Days Entered");
                    }
                    break;
                
                case 3:
                    RDaccount rd = new RDaccount();
                    try {
                        System.out.print("Enter the RD Monthly amount you pay: ");
                        double monthlyAmount = sc.nextDouble();
                        double RDInterest = rd.calculateBankInterest(monthlyAmount);
                        int n = rd.no_of_months;
                        double TotalDeposit = n * monthlyAmount;
                        System.out.println("\nTotal Amount Deposited: Rs. " + String.format("%.2f", TotalDeposit));
                        System.out.println("Total RD Interest will be: Rs. " + String.format("%.2f", RDInterest));
                        System.out.println("Total RD Maturity Amount will be: Rs. " + String.format("%.2f", (RDInterest+TotalDeposit)));

                    } catch (Invalid_Age_Exception e) {
                        System.out.println("Invalid Age Entered");
                    } catch (Invalid_Amount_Exception e) {
                        System.out.println("Invalid Amount Entered");
                    } catch (Invalid_Months_Exception e) {
                        System.out.println("Invalid Days Entered");
                    }
                    break;
                
                case 4:
                    System.out.println("\nThank you so much for using my bank! See you again!");
                    System.out.println("Exiting Program!!!\n");
                    loop = 2;
                    break;
                default:
                    System.out.println("Wrong choice! TRY AGAIN!!");
            }
        }
       while(loop == 1);
    sc.close();
    }
}