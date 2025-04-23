package user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SearchAuction {
    private Auction auction;
    private String[] searchTerms;

    // Simulated auction database
    private static final List<Auction> auctionDB = new ArrayList<>();

    static {
        LocalDateTime now = LocalDateTime.now();
        auctionDB.add(new Auction("id", "itemName", "itemCategory", "auctionDescription", 50.0, 3300.0, now.minusHours(1), now.plusHours(3)));
    }

    public SearchAuction(Auction auction, String... searchTerms) {
        this.auction = auction;
        this.searchTerms = searchTerms;
    }

    public static boolean searchAuction(SearchAuction input) {
        if (input.searchTerms == null || input.searchTerms.length == 0) {
            System.err.println("Error: Missing or malformed search criteria.");
            return false;
        }

        for (String term : input.searchTerms) {
            if (term == null || term.trim().isEmpty()) {
                System.err.println("Error: Invalid search input.");
                return false;
            }
        }

        LocalDateTime now = LocalDateTime.now();

        for (Auction a : auctionDB) {
            if (!a.isOngoing(now)) continue;

            for (String term : input.searchTerms) {
                if (a.getId().equalsIgnoreCase(term) ||
                        a.getDescription().toLowerCase().contains(term.toLowerCase()) ||
                        a.getCategory().equalsIgnoreCase(term) ||
                        a.getStartTime().toString().contains(term)) {
                    System.out.println("Matching auction found: " + a.getId());
                    return true;
                }
            }
        }

        System.out.println("Warning: No matching auctions found.");
        return false;
    }
}
