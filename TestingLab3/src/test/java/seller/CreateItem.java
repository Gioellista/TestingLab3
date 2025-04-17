package seller;

import java.util.List;

public class CreateItem {

    private static final int MAX_DESC_LENGTH = 15;
    private static final List<String> VALID_CATEGORIES = List.of("Category", "Electronics", "Books", "Clothing");

    public static boolean createItem(Item item) {
        // Validate description length
        if (item.getDescription() == null || item.getDescription().length() > MAX_DESC_LENGTH) {
            System.err.println("Error: Description is too long.");
            return false;
        }

        // Validate bid increment
        try {
            if (item.getBidIncrement() == null || Double.parseDouble(item.getBidIncrement()) <= 0) {
                System.err.println("Error: Invalid bid increment.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: Bid increment is not a valid number.");
            return false;
        }

        // Validate category
        if (item.getCategory() == null || !VALID_CATEGORIES.contains(item.getCategory())) {
            System.err.println("Error: Invalid category.");
            return false;
        }

        // Check image presence (warning only)
        if (item.getImage() == null) {
            System.out.println("Warning: No image provided. Item will still be added.");
        }

        // Simulate adding item to auction (stubbed logic)
        System.out.println("Item successfully added to auction: " + item.getDescription());
        return true;
    }
}

