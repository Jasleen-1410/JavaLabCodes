// Performed By: Jasleen Minhas
// UID: 20BCS6897

import java.util.*;

public class EventStore {
    List<Event> store = new ArrayList<Event>();

    // Constructor to add events initially
    public EventStore() {
        store.add(new Event("D1", "Dance", "Main Stage", "Vaibhav Sir", "Jasleen"));
        store.add(new Event("S1", "Singing", "Fountain Stage", "Kuljeet Sir", "Anchal"));
        store.add(new Event("A1", "Acting", "Block D1 Stage", "Shivani Mam", "Ruhi"));
        store.add(new Event("P2", "Poetry", "Main Stage", "Wasson Sir", "Prince"));
    }

    // Add event function
    public void addEvent(String event_id, String event_name, String event_stage, String event_judge,
            String event_anchor) {
        store.add(new Event(event_id, event_name, event_stage, event_judge, event_anchor));
        System.out.println("\n* Event added successfully *");
    }

    // Remove event function
    public void removeEvent(String name) {
        Iterator itr = store.iterator();
        // traversing elements of ArrayList object
        while (itr.hasNext()) {
            Event e = (Event) itr.next();
            if (e.event_name.equals(name)) {
                System.out.println("Event " + e.event_name + " Successfully Removed!!");
                store.remove(e);
                return;
            }
        }
        System.out.println("\nNo Such Event!!");
        return;
    }

    // Search event function
    public void searchEvent(String name) {
        Iterator itr = store.iterator();
        // traversing elements of ArrayList object
        while (itr.hasNext()) {
            Event e = (Event) itr.next();
            if (e.event_name.equals(name)) {
                System.out.println("Event ID: " + e.event_id);
                System.out.println("Event Name: " + e.event_name);
                System.out.println("Event Stage: " + e.event_stage);
                System.out.println("Event Judge: " + e.event_judge);
                System.out.println("Event Anchor: " + e.event_anchor);
                return;
            }
        }
        System.out.println("\nNo Such Event!!");
        return;
    }

    // Display events function
    public void displayEvent() {
        System.out.println(
                "------------------------------------------------------------------------------------------------");
        System.out
                .println("Event ID.     Event Name.        Event Stage.         Event Judge.        Event Anchor ");
        System.out.println(
                "------------------------------------------------------------------------------------------------");
        Iterator itr = store.iterator();
        // traversing elements of ArrayList object
        while (itr.hasNext()) {
            Event e = (Event) itr.next();
            System.out
                    .println(
                            e.event_id + "\t\t" + e.event_name + "\t\t" +
                                    e.event_stage
                                    + "\t\t" + e.event_judge + "\t\t" + e.event_anchor);
        }
        System.out.println(
                "------------------------------------------------------------------------------------------------");
    }
}