package auction;

import java.util.*;

public class AwardItem {
    private static List<int[]> finalAuctions = new ArrayList<>();

    public static void addFinalAuctions(int[] auctions) {
        finalAuctions.add(auctions);
    }

    // TC1: Single highest bid
    public static boolean awardItem(int[] auctions) {
        if (auctions == null || auctions.length == 0) {
            return false; // TC4: No bids
        }

        int max = Arrays.stream(auctions).max().orElse(0);
        long count = Arrays.stream(auctions).filter(x -> x == max).count();

        if (count == 1) {
            // Notify winner, remove auction (stubbed)
            System.out.println("Item awarded to bidder with bid: " + max);
            return true;
        } else {
            // Tie exists
            return false;
        }
    }

    // TC2: Tie - request new bid
    public static boolean requestNewBid(int[] auctions) {
        if (auctions == null || auctions.length == 0) {
            return false;
        }

        int max = Arrays.stream(auctions).max().orElse(0);
        long count = Arrays.stream(auctions).filter(x -> x == max).count();

        if (count > 1) {
            // Request new bids from tied users (stubbed)
            System.out.println("Requesting new bids from users tied at: " + max);
            return true;
        }

        return false;
    }

    // TC3: Tie again - seller decides winner
    public static boolean decideWinner(int[] tiedAuctions) {
        if (tiedAuctions == null || tiedAuctions.length == 0) {
            return false;
        }

        int max = Arrays.stream(tiedAuctions).max().orElse(0);
        long count = Arrays.stream(tiedAuctions).filter(x -> x == max).count();

        if (count > 1) {
            // Seller decides (stubbed)
            System.out.println("Seller decides the winner from tied bids: " + max);
            return true;
        }

        return false;
    }
}
