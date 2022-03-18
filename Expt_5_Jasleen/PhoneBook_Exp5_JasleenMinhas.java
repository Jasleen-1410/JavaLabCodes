// Performed By: Jasleen Minhas 
// UID:20BCS6872

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBook_Exp5_JasleenMinhas {
  // User can add details in the phonebook using their phone number.

  int menuChoice = 0;
  Scanner input = new Scanner(System.in); // For taking user input

  // For storing Phone number, name and their address we are using a Hash Table
  // and HashSet
  Hashtable<Long, HashSet<String>> ht = new Hashtable<>();

  public static void main(String[] args) {
    System.out.print("\nPerformed By: Jasleen Minhas, 20BCS6897");

    // Creating object
    PhoneBook_Exp5_JasleenMinhas obj = new PhoneBook_Exp5_JasleenMinhas();
    obj.getMenu();
    // Getting the menu for the user
    while (obj.menuChoice != 3) {
      // For taking the input from user till he/she exists.
      obj.getMenu();
    }
  }

  private void getMenu() {
    // Display a Menu for the user, and let user choose the menu Options.
    System.out.println("\n\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
    System.out.println("Phonebook: Main Menu: (Jasleen Minhas, 20BCS6897)");
    System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
    System.out.println("1. Add number in the Phonebook");
    System.out.println("2. Get details from Phonebook");
    System.out.println("3. Exit");

    System.out.print("\nEnter choice: ");
    menuChoice = input.nextInt();
    System.out.println("");

    try {
      switch (menuChoice) {
        case 1:
          addDetails();
          break;
        case 2:
          recordedDetails();
          getDetails();
          break;
        case 3:
          System.out.println("Thank you for using the Phonebook!!");
          System.exit(0);
        default:
          System.out.println("Wrong Choice Selected!!!");
      }
    } catch (Exception e) {
      System.out.println("Exception is " + e);
    }
  }

  private void getDetails() {
    // Get the Details of th user from the user when user enter a correct Phone

    System.out.print("Please Enter the Phone Number of the person: ");
    long number = input.nextLong();
    if (ht.get(number) == null) {
      System.out.println("\n* * * ERROR!! No such person is there with that Numbered in the Phonebook * * *");
      return;
    }
    System.out.println("- - - - - - - - - - - - - - - - - - - - - ");
    Iterator<String> it = ht.get(number).iterator();
    System.out.println("Phone Number: " + number);
    while (it.hasNext()) {
      System.out.println(it.next());
    }
    System.out.println("- - - - - - - - - - - - - - - - - - - - - ");
  }

  private void addDetails() {
    // Get the Details of the user from the user and store it in the Hash Tables.

    String name = "";
    String address = "";
    String occ = "";
    String email = "";

    System.out.print("Enter Phone Number of the person: ");
    long number = input.nextLong();
    input.nextLine();
    System.out.print("Enter Name of the person: ");
    name = input.nextLine();
    System.out.print("Enter Address of the person: ");
    address = input.nextLine();
    System.out.print("Enter Occupation of the person: ");
    occ = input.nextLine();
    System.out.print("Enter Email of the person: ");
    email = input.nextLine();

    HashSet<String> hs = new HashSet<>();
    hs.add("Name: " + name);
    hs.add("Address: " + address);
    hs.add("Occupation: " + occ);
    hs.add("Email: " + email);

    ht.put(number, hs);
    System.out.println("\n* * * Person Added Successfully in the PhoneBook * * *");
  }

  public void recordedDetails() {
    // Already recored data

    long nums[] = { 9876543210L, 9345678216L, 764372964L };
    String names[] = { "Swati", "Rudransh", "Simar" };
    String add[] = { "Rajasthan", "Himachal", "Hoshiarpur" };
    String occ[] = { "Teacher", "Manager", "Diver" };
    String email[] = { "Swati.joshi@gmail.com", "Rudranshtrivedi@gmail.com", "Simardeepsingh07@gmail.com" };

    for (int i = 0; i < nums.length; i++) {
      HashSet<String> hs = new HashSet<>();
      hs.add("Name: " + names[i]);
      hs.add("Address: " + add[i]);
      hs.add("Occupation: " + occ[i]);
      hs.add("Email: " + email[i]);
      ht.put(nums[i], hs);
    }
  }
}