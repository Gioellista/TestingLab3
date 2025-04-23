package user;

import java.time.LocalDateTime;
import java.util.List;

public class RegisterToAuction {

    private User user;
    private List<User> registeredUsers;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public RegisterToAuction(User user, List<User> registeredUsers, LocalDateTime startTime, LocalDateTime endTime) {
        this.user = user;
        this.registeredUsers = registeredUsers;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static boolean registerToAuction(RegisterToAuction input) {
        LocalDateTime now = LocalDateTime.now();

        // Case: User already registered
        if (input.registeredUsers.contains(input.user)) {
            System.out.println("Warning: User is already registered for this auction.");
            return false;
        }

        // Case: Auction not ongoing
        if (now.isBefore(input.startTime) || now.isAfter(input.endTime)) {
            System.out.println("Error: Auction is not currently ongoing.");
            return false;
        }

        // Case: Auction ongoing and user not yet registered
        System.out.println("User registered successfully. Auction details displayed.");
        return true;
    }
}
