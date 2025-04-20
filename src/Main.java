// Compile Command: javac -cp "lib/two-slices-0.9.4.jar" -d bin src/Main.java

import com.sshtools.twoslices.Toast;

public class Main {
    public static void main(String[] args) {
        final long duration = Math.abs(Long.parseLong(args[0]));
        String timeUnit = args[1].toLowerCase();
        
        // Start a thread for a timer (using lambda syntax)
        new Thread(() -> runTimer(duration, timeUnit)).start();
    }

    private static void runTimer(long duration, String timeUnit) {
        long msDuration = duration * 1000;
        
        String capitalizedTimeUnit = timeUnit.substring(0, 1).toUpperCase() + timeUnit.substring(1);
        String capitalizedSingularTimeUnit = capitalizedTimeUnit.endsWith("s") ? capitalizedTimeUnit.substring(0, capitalizedTimeUnit.length() - 1) : capitalizedTimeUnit;
        
        if (timeUnit.equals("hours")) {
            msDuration *= 60 * 60;
        } else if (timeUnit.equals("minutes")) {
            msDuration *= 60;
        // Handle invalid time units
        } else if (!timeUnit.equals("seconds")) {
            System.out.println("Valid Units Include: hours, minutes, and seconds");
            System.exit(1);
        }

        // Timer Started Notification
        Toast.toast(duration + " " + capitalizedSingularTimeUnit + " Timer Started!");
        System.out.println("Timer Started!");

        // Wait logic 
        try {
            Thread.sleep(msDuration);
        } catch (InterruptedException e) {
            System.out.println(e);
            // Exit (and thus end) the thread
            return;
        }

        // Timer Ended Notification
        Toast.toast(duration + " " + capitalizedSingularTimeUnit + " Timer Ended!");
        System.out.println("Timer Ended!");
    }
}
