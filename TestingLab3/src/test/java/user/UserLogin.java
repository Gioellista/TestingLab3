package user;

import java.util.*;

public class UserLogin {
    private String username;
    private String password;
    private int failedAttempts;

    // Simulated DB
    private static final Map<String, String> userDatabase = new HashMap<>();
    private static final Map<String, Integer> failedLoginTracker = new HashMap<>();

    static {
        // Stubbed database users
        userDatabase.put("userNameA", "userPassA");
        userDatabase.put("userNameD", "userPassD");
    }

    public UserLogin(String username, String password, int failedAttempts) {
        this.username = username;
        this.password = password;
        this.failedAttempts = failedAttempts;
    }

    public static boolean login(UserLogin loginAttempt) {
        String username = loginAttempt.username;
        String password = loginAttempt.password;

        // Check for empty fields
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            System.err.println("Error: Username or password cannot be empty.");
            return false;
        }

        // Check if user is locked out
        int failedCount = failedLoginTracker.getOrDefault(username, 0);
        if (failedCount >= 3 || loginAttempt.failedAttempts >= 3) {
            System.err.println("Error: Too many failed login attempts. Please try again later.");
            return false;
        }

        // Check credentials against DB
        if (!userDatabase.containsKey(username) || !userDatabase.get(username).equals(password)) {
            // Increment failed attempt
            failedLoginTracker.put(username, failedCount + 1);
            System.err.println("Error: Invalid credentials.");
            return false;
        }

        // Reset failed attempts on successful login
        failedLoginTracker.put(username, 0);
        System.out.println("Login successful for user: " + username);
        return true;
    }
}

