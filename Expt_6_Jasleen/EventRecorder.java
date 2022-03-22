// Performed By: Jasleen Minhas
// UID: 20BCS6897

import java.util.Scanner;

public class EventRecorder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        // Creating object of the Event Recorder class
        EventStore eventStore = new EventStore();
        System.out.println("\nPerformed By: Jasleen Minhas, 20BCS6897");

        do {
            // Main Menu
            System.out.println("\n\n* * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("Event Details, Main Menu: (Jasleen Minhas)");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("\t1. Add an Event.");
            System.out.println("\t2. Display all the Event Record.");
            System.out.println("\t3. Search an Event From Record.");
            System.out.println("\t4. Delete an Event From Record.");
            System.out.println("\t5. Exit the Program!");

            System.out.print("\nEnter your choice(1..5): ");
            choice = input.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    // Letting the user add events in the array list
                    System.out.print("Enter the Event ID: ");
                    String id = input.next();
                    System.out.print("Enter the Event name: ");
                    String name = input.next();
                    System.out.print("Enter the Event stage: ");
                    String stage = input.next();
                    System.out.print("Enter the Event judge: ");
                    String judge = input.next();
                    System.out.print("Enter the Event anchor: ");
                    String anchor = input.next();
                    eventStore.addEvent(id, name, stage, judge, anchor);
                    break;
                case 2:
                    // Letting the user display all the events in the array list
                    eventStore.displayEvent();
                    break;
                case 3:
                    // Letting the user search for a particular event in the array list
                    System.out.print("Enter the name of the event you want to Search: ");
                    eventStore.searchEvent(input.next());
                    break;
                case 4:
                    // Letting the user remove a particular event in the array list
                    System.out.print("Enter the name of the event you want to Remove: ");
                    eventStore.removeEvent(input.next());
                    break;
                case 5:
                    System.err.println("Thanks for using the application!! Hope you liked it:)");
                    System.exit(1);
                    break;
            }

        } while (!(choice == 5));
        input.close();
    }
}