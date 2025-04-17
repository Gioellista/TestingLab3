package auction;

public class RegisterBid {

    private static int basePrice;
    private static int increment;
    private static int currentPrice;

    public static void setBasePrice(int price) {
        basePrice = price;
        currentPrice = price;
    }

    public static void setIncrement(int inc) {
        increment = inc;
    }

    public static boolean registerBid(int bidAmount) {
        // Check if bidAmount is a valid bid
        if (bidAmount > currentPrice && (bidAmount - currentPrice) % increment == 0) {
            currentPrice = bidAmount;
            return true;
        }
        return false;
    }

    // Optional: Get current price for other tests
    public static int getCurrentPrice() {
        return currentPrice;
    }
}
