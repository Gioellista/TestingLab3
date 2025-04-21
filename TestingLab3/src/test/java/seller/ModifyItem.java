package seller;

public class ModifyItem {
    private static final int MAX_DESC_LENGTH = 15;

    public static boolean modifyItem(Item item) {
        if (item == null) return false;

        String description = item.getDescription();
        String category = item.getCategory();
        String image = item.getImage();

        // TC2: Description too long
        if (description != null && description.length() > MAX_DESC_LENGTH) {
            System.out.println("Error: Description is too long.");
            return false;
        }

        // TC3: Missing description
        if (description == null || description.trim().isEmpty()) {
            System.out.println("Error: Description is required.");
            return false;
        }

        // TC4: Missing category
        if (category == null || category.trim().isEmpty()) {
            System.out.println("Error: Category must be selected.");
            return false;
        }

        // TC5: Missing image - still allow update
        if (image == null || image.trim().isEmpty()) {
            System.out.println("Warning: No image provided. Proceeding without image.");
        }

        // TC1 & TC5: All valid or only image missing
        System.out.println("Item updated successfully.");
        return true;
    }
}
