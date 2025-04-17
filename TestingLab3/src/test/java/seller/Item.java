package seller;

public class Item {
    private String description;
    private String category;
    private String image;
    private String bidIncrement;

    public Item(String description, String category, String image, String bidIncrement) {
        this.description = description;
        this.category = category;
        this.image = image;
        this.bidIncrement = bidIncrement;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public String getBidIncrement() {
        return bidIncrement;
    }
}
