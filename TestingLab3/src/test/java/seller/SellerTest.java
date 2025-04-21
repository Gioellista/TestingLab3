package seller;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class SellerTest {

    @TestFactory
    Iterator<DynamicTest> createItemTest() {
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


    @TestFactory
    Iterator<DynamicTest> modifyItemTest() {
        List<DynamicTest> dynamicTests = new ArrayList<>();

        int maxLenDesc = 15;

        List<Object[]> itemList = List.of(
                new Object[]{new Item("Description", "Category", "img-1", "10"), true},
                new Object[]{new Item("Description that is too long", "Category", "img-1", "10"), false},
                new Object[]{new Item(null, "Category", "img-1", "10"), false},
                new Object[]{new Item("Description", null, "img-1", "10"), false},
                new Object[]{new Item("Description", "Category", null, "10"), true}
        );

        int i = 1;

        for (Object[] item : itemList) {
            Item input = (Item)item[0];
            Boolean expected = (Boolean)item[1];

            dynamicTests.add(dynamicTest(
                    "TC" + i + ": modifyItemTest",
                    () -> assertEquals(expected, ModifyItem.modifyItem(input))
            ));
            i++;
        }

        return dynamicTests.iterator();
    }

    @TestFactory
    Stream<DynamicTest> createAuctionTest() {
        Item validItem = new Item ("Description", "Category", "img-1", "10");

        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(3);

        List<Object[]> auctionList = List.of(
                new Object[]{new Auction(validItem, "100.0", startTime, endTime, true, false), true},
                new Object[]{new Auction(validItem, "100.0", startTime, endTime, false, true), true},
                new Object[]{new Auction(null, "100.0", startTime, endTime, true, false), false},
                new Object[]{new Auction(validItem, null, startTime, endTime, true, false), false},
                new Object[]{new Auction(validItem, "100.0", endTime, startTime, true, false), false}
        );

        return  auctionList.stream().map((auctions) -> {
            Auction auction = (Auction) auctions[0];
            Boolean expected = (Boolean) auctions[1];

            return dynamicTest(
                    "createAuctionTest: " + auction,
                    () -> assertEquals(expected, CreateAuction.createAuction(auction))

            );

        });
    }
}
