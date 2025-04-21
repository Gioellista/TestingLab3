package seller;

import java.time.LocalDateTime;

public class Auction {
    private Item item;
    private String startingPrice;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private boolean isNewAuction;
    private boolean isExistingAuction;

    public Auction(Item item, String startingPrice, LocalDateTime startDateTime,
                   LocalDateTime endDateTime, boolean isNewAuction, boolean isExistingAuction) {
        this.item = item;
        this.startingPrice = startingPrice;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.isNewAuction = isNewAuction;
        this.isExistingAuction = isExistingAuction;
    }

    public Item getItem() {
        return item;
    }

    public String getStartingPrice() {
        return startingPrice;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public boolean isNewAuction() {
        return isNewAuction;
    }

    public boolean isExistingAuction() {
        return isExistingAuction;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "item=" + (item != null ? item.getDescription() : "null") +
                ", price=" + startingPrice +
                ", start=" + startDateTime +
                ", end=" + endDateTime +
                ", new=" + isNewAuction +
                ", existing=" + isExistingAuction +
                '}';
    }
}
