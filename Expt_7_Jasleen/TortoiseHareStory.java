
// Performed By: Jasleen Minhas
// UID: 20BCS6897

class tortoise extends Thread {
    public void run() {
        for (int i = 0; i <= 20; i++) {
            try {
                System.out.println("TORTOISE is running: distance covered - " + i);
                if (i == 20) {
                    System.out.println("\n* * * * * TORTOISE WON THE RACE * * * *\n");
                    System.out.println("* * * * * HARE AGAIN STARTED THE RACE * * * *\n");
                }
            } catch (Exception e) {
                System.out.println("Exception occured");
            }
        }
    }
}

class hare extends Thread {
    public void run() {
        for (int i = 0; i <= 20; i++) {
            try {
                System.out.println("HARE is running: distance covered - " + i);
                if (i == 10) {
                    System.out.println("\n* * * * * HARE SLEPT * * * *\n");
                    Thread.sleep(5000);
                }

                if (i == 20) {
                    System.out.println("\n* * * * * HARE COMPLETED THE RACE * * * *\n");
                }
            } catch (Exception e) {
                System.out.println("Exception occured");
            }
        }
    }
}

public class TortoiseHareStory {
    public static void main(String[] args) {

        System.out.println("\n\nPerformed By: Jasleen Minhas, UID: 20BCS6897\n\n");

        Thread ob = new tortoise();
        Thread ob1 = new hare();

        ob.start();
        ob1.start();
    }
}