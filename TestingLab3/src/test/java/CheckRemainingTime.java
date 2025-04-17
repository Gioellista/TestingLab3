public class CheckRemainingTime {

    private static double remainingTime;

    public static void setRemainingTime(double time) {
        remainingTime = time;
    }

    public static double getRemainingTime() {
        return remainingTime;
    }

    public static String displayAuctionDetails() {
        // Stubbed auction details for now, real data would be pulled from auction object/db
        return "Auction: 'Antique Vase' | Current Bid: $500 | Remaining Time: " + remainingTime + " minutes";
    }
}

