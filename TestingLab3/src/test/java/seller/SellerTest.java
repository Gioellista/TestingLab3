package seller;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class SellerTest {

    @TestFactory
    Stream<DynamicTest> createItemTest() {

        List<Object[]> itemList = List.of(
                new Object[]{new Item("Description", "Category", "img-1", "10"), true},
                new Object[]{new Item("Description that is too long", "Category", "img-1", "10"), false},
                new Object[]{new Item("Description", "Category", "img-1", null), false},
                new Object[]{new Item("Description", null, "img-1", "10"), false},
                new Object[]{new Item("Description", "Category", null, "10"), true}
        );

        Iterator<Object[]> iter = itemList.iterator();

        Function<Object[], String> displayNameGenerator = (item) -> "createItemTest: " + item;

        ThrowingConsumer<Object[]> testExecutor = (items) -> assertEquals(items[1], CreateItem.createItem((Item)items[0]));

        return DynamicTest.stream(iter, displayNameGenerator, testExecutor);
    }


    @TestFactory
    Stream<DynamicTest> modifyItemTest() {

        List<Object[]> itemList = List.of(
                new Object[]{new Item("Description", "Category", "img-1", "10"), true},
                new Object[]{new Item("Description that is too long", "Category", "img-1", "10"), false},
                new Object[]{new Item(null, "Category", "img-1", "10"), false},
                new Object[]{new Item("Description", null, "img-1", "10"), false},
                new Object[]{new Item("Description", "Category", null, "10"), true}
        );

        Iterator<Object[]> iter = itemList.iterator();

        Function<Object[], String> displayNameGenerator = (item) -> "modifyItemTest: " + item;

        ThrowingConsumer<Object[]> testExecutor = (items) -> assertEquals(items[1], ModifyItem.modifyItem((Item)items[0]));

        return DynamicTest.stream(iter, displayNameGenerator, testExecutor);
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

        Iterator<Object[]> iter = auctionList.iterator();

        Function<Object[], String> displayNameGenerator = (auction) -> "createAuctionTest: " + auction;

        ThrowingConsumer<Object[]> testExecutor = (auctions) -> assertEquals(auctions[1], CreateAuction.createAuction((Auction)auctions[0]));

        return DynamicTest.stream(iter, displayNameGenerator, testExecutor);
    }
}
