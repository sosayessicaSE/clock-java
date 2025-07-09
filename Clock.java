import java.text.SimpleDateFormat;
import java.util.Date;

// Clock class
public class Clock {

    private volatile String currentTime;

    public Clock() {
        updateTime();
    }

    // update the current time in the background
    public void startClock() {
        Thread updaterThread = new Thread(() -> {
            while (true) {
                updateTime();
                try {
                    Thread.sleep(1000); // Update every second
                } catch (InterruptedException e) {
                    System.err.println("Updater thread interrupted.");
                }
            }
        });
        updaterThread.setPriority(Thread.MIN_PRIORITY); // background update has lower priority
        updaterThread.start();
    }

    // display the current time and date
    public void startDisplay() {
        Thread displayThread = new Thread(() -> {
            while (true) {
                System.out.println(currentTime);
                try {
                    Thread.sleep(1000); // Display every second
                } catch (InterruptedException e) {
                    System.err.println("Display thread interrupted.");
                }
            }
        });
        displayThread.setPriority(Thread.MAX_PRIORITY); // display has higher priority
        displayThread.start();
    }

    // method to update time safely
    private synchronized void updateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        currentTime = formatter.format(new Date());
    }

    // Entry point of the application
    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.startClock(); // start background update thread
        clock.startDisplay(); // start display thread
    }
}
