package user;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class UserTest {

    @TestFactory
    Iterator<DynamicTest> registerToAuctionTest() {
        List<DynamicTest> dynamicTests = new ArrayList<>();

        User user = new User("userName", "userPass");
        LocalDateTime now = LocalDateTime.now();

        List<Object[]> registerToAuctionList = List.of(
                new Object[]{new RegisterToAuction(user, List.of(), now.minusHours(2), now.plusHours(3)), true},
                new Object[]{new RegisterToAuction(user, List.of(), now.plusDays(1), now.plusDays(1).plusHours(5)), false},
                new Object[]{new RegisterToAuction(user, List.of(user), now.minusHours(2), now.plusHours(3)), false}
        );

        int i = 1;

        for (Object[] item : registerToAuctionList) {
            RegisterToAuction input = (RegisterToAuction)item[0];
            Boolean expected = (Boolean)item[1];

            dynamicTests.add(dynamicTest(
                    "TC" + i + ": registerToAuctionTest",
                    () -> assertEquals(expected, RegisterToAuction.registerToAuction(input))
            ));
            i++;
        }

        return dynamicTests.iterator();
    }

    @TestFactory
    Iterator<DynamicTest> loginTest() {
        List<DynamicTest> dynamicTests = new ArrayList<>();

        List<Object[]> userLoginList = List.of(
                new Object[]{new UserLogin("userNameA", "userPassA", 1), true},
                new Object[]{new UserLogin("userNameB", "", 1), false},
                new Object[]{new UserLogin("userNameNonExisting", "userPassC", 1), false},
                new Object[]{new UserLogin("userNameD", "userPassD", 5), false}
        );

        int i = 1;

        for (Object[] item : userLoginList) {
            UserLogin input = (UserLogin)item[0];
            Boolean expected = (Boolean)item[1];

            dynamicTests.add(dynamicTest(
                    "TC" + i + ": userLoginTest",
                    () -> assertEquals(expected, UserLogin.login(input))
            ));
            i++;
        }

        return dynamicTests.iterator();
    }

    @TestFactory
    Iterator<DynamicTest> placeBidTest() {
        List<DynamicTest> dynamicTests = new ArrayList<>();

        LocalDateTime now = LocalDateTime.now();

        User user = new User("userName", "userPass");
        Auction auction = new Auction("id", "itemName", "itemCategory", "auctionDescription", 50.0, 3300.0, now, now.plusHours(3));

        List<Object[]> placeBidList = List.of(
                new Object[]{new PlaceBid(user, 3350.0, auction), true},
                new Object[]{new PlaceBid(user, 3338.0, auction), false}
        );

        int i = 1;

        for (Object[] item : placeBidList) {
            PlaceBid input = (PlaceBid)item[0];
            Boolean expected = (Boolean)item[1];

            dynamicTests.add(dynamicTest(
                    "TC" + i + ": userLoginTest",
                    () -> assertEquals(expected, PlaceBid.updateBid(input))
            ));
            i++;
        }

        return dynamicTests.iterator();
    }

    @TestFactory
    Iterator<DynamicTest> searchAuctionTest() {
        List<DynamicTest> dynamicTests = new ArrayList<>();

        LocalDateTime now = LocalDateTime.now();

        Auction auction = new Auction("id", "itemName", "itemCategory", "auctionDescription", 50.0, 3300.0, now, now.plusHours(3));

        List<Object[]> searchAuctionList = List.of(
                new Object[]{new SearchAuction(auction, "id"), true},
                new Object[]{new SearchAuction(auction, "non-existent-id"), false},
                new Object[]{new SearchAuction(auction, "malformed", "search", "criteria"), false}
        );

        int i = 1;

        for (Object[] item : searchAuctionList) {
            SearchAuction input = (SearchAuction)item[0];
            Boolean expected = (Boolean)item[1];

            dynamicTests.add(dynamicTest(
                    "TC" + i + ": userLoginTest",
                    () -> assertEquals(expected, SearchAuction.searchAuction(input))
            ));
            i++;
        }

        return dynamicTests.iterator();
    }

    @TestFactory
    Iterator<DynamicTest> selectAuctionTest() {
        List<DynamicTest> dynamicTests = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();


        Auction auction1 = new Auction("1", "Item1", "Category1", "Description1", 50.0, 3300.0, now, now.plusHours(3));
        Auction auction2 = new Auction("2", "Item2", "Category2", "Description2", 100.0, 3500.0, now.plusMinutes(10), now.plusHours(5));


        List<Auction> availableAuctions = List.of(auction1, auction2);

        List<Object[]> selectAuctionList = List.of(
                new Object[]{availableAuctions, "1", true},
                new Object[]{availableAuctions, "non-existent-id", false},
                new Object[]{availableAuctions, null, false}
        );

        int i = 1;

        for (Object[] item : selectAuctionList) {
            List<Auction> auctions = (List<Auction>) item[0];
            String selectedAuctionId = (String) item[1];
            Boolean expected = (Boolean) item[2];

            dynamicTests.add(dynamicTest(
                    "TC" + i + ": selectAuctionTest",
                    () -> assertEquals(expected, SelectAuction.selectAuction(auctions, selectedAuctionId))
            ));
            i++;
        }

        return dynamicTests.iterator();
    }

}
