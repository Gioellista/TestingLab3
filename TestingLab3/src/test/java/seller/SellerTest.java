package seller;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class SellerTest {

    @TestFactory
    Iterator<DynamicTest> createItem() {
        List<DynamicTest> dynamicTests = new ArrayList<>();

        int maxLenDesc = 15;

        List<Object[]> itemList = List.of(
                new Object[]{new Item("Description", "Category", "img-1", "10"), true},
                new Object[]{new Item("Description that is too long", "Category", "img-1", "10"), false},
                new Object[]{new Item("Description", "Category", "img-1", null), false},
                new Object[]{new Item("Description", null, "img-1", "10"), false},
                new Object[]{new Item("Description", "Category", null, "10"), true}
        );

        int i = 1;

        for (Object[] item : itemList) {
            Item input = (Item)item[0];
            Boolean expected = (Boolean)item[1];

            dynamicTests.add(dynamicTest(
                    "TC" + i + ": createItemTest",
                    () -> assertEquals(expected, CreateItem.createItem(input))
            ));
            i++;
        }

        return dynamicTests.iterator();
    }
}
