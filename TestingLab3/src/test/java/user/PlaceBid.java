package user;

import java.time.LocalDateTime;

public class PlaceBid {
    private User user;
    private double bidAmount;
    private Auction auction;

    public PlaceBid(User user, double bidAmount, Auction auction) {
        this.user = user;
        this.bidAmount = bidAmount;
        this.auction = auction;
    }

    public static boolean updateBid(PlaceBid bid) {
        Auction auction = bid.auction;
        LocalDateTime now = LocalDateTime.now();

        if (!auction.isOngoing(now)) {
            System.err.println("Auction is not ongoing.");
            return false;
        }

        double increment = auction.getBidIncrement();
        double currentPrice = auction.getCurrentPrice();
        double difference = bid.bidAmount - currentPrice;

        // Check if bid is valid multiple
        if (difference > 0 && difference % increment == 0) {
            auction.updatePrice(bid.bidAmount);
            System.out.println("Bid accepted. New price: " + bid.bidAmount);
            return true;
        } else {
            System.err.println("Invalid bid amount.");
            return false;
        }
    }
}

