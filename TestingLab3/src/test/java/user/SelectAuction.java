package user;

import java.time.LocalDateTime;
import java.util.List;

public class SelectAuction {

    // Method to handle auction selection
    public static boolean selectAuction(List<Auction> auctions, String selectedAuctionId) {
        if (selectedAuctionId == null || selectedAuctionId.isEmpty()) {
            System.out.println("Warning: No auction selected.");
            return false;  // No auction selected
        }

        // Find the auction by ID
        for (Auction auction : auctions) {
            if (auction.getId().equals(selectedAuctionId)) {
                // If auction is found and it's ongoing, show the details
                if (auction.isOngoing(LocalDateTime.now())) {
                    System.out.println("Auction Details:");
                    System.out.println("ID: " + auction.getId());
                    System.out.println("Name: " + auction.getName());
                    System.out.println("Category: " + auction.getCategory());
                    System.out.println("Description: " + auction.getDescription());
                    System.out.println("Current Price: " + auction.getCurrentPrice());
                    System.out.println("Remaining Time: " + auction.getEndTime().minusMinutes(LocalDateTime.now().getMinute()).toString());
                    return true;
                } else {
                    // Auction is not ongoing
                    System.out.println("Error: This auction is no longer available.");
                    return false;
                }
            }
        }

        // If auction with the selected ID doesn't exist
        System.out.println("Error: Invalid auction selection.");
        return false;
    }
}
