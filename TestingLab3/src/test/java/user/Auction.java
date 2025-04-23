package user;

import java.time.LocalDateTime;

public class Auction {
    private String id;
    private String name;
    private String category;
    private String description;
    private double bidIncrement;
    private double currentPrice;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Auction(String id, String name, String category, String description,
                   double bidIncrement, double currentPrice, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.bidIncrement = bidIncrement;
        this.currentPrice = currentPrice;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isOngoing(LocalDateTime now) {
        return (now.isEqual(startTime) || now.isAfter(startTime)) && now.isBefore(endTime);
    }

    public double getBidIncrement() {
        return bidIncrement;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void updatePrice(double newPrice) {
        this.currentPrice = newPrice;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
}

