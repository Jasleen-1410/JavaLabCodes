// Performed By: Jasleen Minhas
// UID: 20BCS6897

public class Event {
    // Data members of Event class
    String event_id;
    String event_name;
    String event_stage;
    String event_judge;
    String event_anchor;

    public Event() {
    }

    // Constructor to store
    public Event(String event_id, String event_name, String event_stage, String event_judge,
            String event_anchor) {
        this.event_id = event_id;
        this.event_name = event_name;
        this.event_stage = event_stage;
        this.event_anchor = event_anchor;
        this.event_judge = event_judge;
    }
}