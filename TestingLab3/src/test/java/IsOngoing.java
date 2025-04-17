import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IsOngoing {

    private static LocalDateTime startTime;
    private static LocalDateTime endTime;
    private static LocalDateTime currentTime;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm dd/MM/yyyy");

    public static void setStartTime(String time) {
        startTime = LocalDateTime.parse(time, formatter);
    }

    public static void setEndTime(String time) {
        endTime = LocalDateTime.parse(time, formatter);
    }

    public static void setCurrentTime(String time) {
        currentTime = LocalDateTime.parse(time, formatter);
    }

    public static LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public static boolean isOngoing(LocalDateTime now) {
        if (now.isBefore(startTime)) {
            System.out.println("Auction Status: Not Started");
            return false;
        } else if (now.isAfter(endTime)) {
            System.out.println("Auction Status: Ended");
            return false;
        } else {
            System.out.println("Auction Status: Ongoing");
            return true;
        }
    }
}
