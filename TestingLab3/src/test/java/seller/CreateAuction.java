package seller;

import java.time.LocalDateTime;

public class CreateAuction {


    public static boolean createAuction(Auction auction) {
        if (auction == null) return false;

        // TC3: No item
        if (auction.getItem() == null) {
            System.out.println("Error: No item selected.");
            return false;
        }

        // TC4: Starting price is null or invalid
        try {
            String priceStr = auction.getStartingPrice();
            if (priceStr == null || priceStr.trim().isEmpty()) {
                System.out.println("Error: Starting price is missing.");
                return false;
            }
            double price = Double.parseDouble(priceStr);
            if (price <= 0) {
                System.out.println("Error: Starting price must be positive.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Starting price format is invalid.");
            return false;
        }

        // TC5: Invalid date/time
        LocalDateTime start = auction.getStartDateTime();
        LocalDateTime end = auction.getEndDateTime();
        if (start == null || end == null || !end.isAfter(start)) {
            System.out.println("Error: End date must be after start date.");
            return false;
        }

        // TC1 & TC2: Valid new or existing auction
        if (auction.isNewAuction() || auction.isExistingAuction()) {
            System.out.println("Auction created or updated successfully.");
            return true;
        }

        return false;
    }
}
