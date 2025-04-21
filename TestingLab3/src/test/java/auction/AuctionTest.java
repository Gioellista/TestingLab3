package auction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuctionTest {

    // ogni entità (tipo "User" o "Seller") é una diversa classe di test
    // ogni user story test / acceptance test è un metodo di test
    // ogni test case di un'acceptance test é un assertion nel metodo di test

    @Test
    public void registerBidTest() {
        RegisterBid.setBasePrice(400);
        RegisterBid.setIncrement(10);
        Assertions.assertTrue(RegisterBid.registerBid(500));
        Assertions.assertFalse(RegisterBid.registerBid(495));
    }


    @Test
    public void isOngoingTest(){
        IsOngoing.setStartTime("8:00 16/06/2023");
        IsOngoing.setEndTime("11:00 16/06/2023");
        IsOngoing.setCurrentTime("8:00 15/06/2023");
        Assertions.assertFalse(IsOngoing.isOngoing(IsOngoing.getCurrentTime()));
        IsOngoing.setCurrentTime("8:30 16/06/2023");
        Assertions.assertTrue(IsOngoing.isOngoing(IsOngoing.getCurrentTime()));
        IsOngoing.setCurrentTime("12:30 17/06/2023");
        Assertions.assertFalse(IsOngoing.isOngoing(IsOngoing.getCurrentTime()));
    }

    @Test
    public void checkRemainingTimeTest() {
        CheckRemainingTime.setRemainingTime(142.76);
        assertTrue(CheckRemainingTime.getRemainingTime() > 0.0);
        CheckRemainingTime.setRemainingTime(0.0);
        assertFalse(CheckRemainingTime.getRemainingTime() > 0.0);
    }

    @Test
    public void awardItemTest() {
        int[] auctions = new int[]{400, 500, 700};
        AwardItem.addFinalAuctions(auctions);
        assertTrue(AwardItem.awardItem(auctions));

        auctions = new int[]{400, 500 ,500};
        AwardItem.addFinalAuctions(auctions);
        assertTrue(AwardItem.requestNewBid(auctions));

        int[] auctionsAfterTie = new int[]{700, 700};
        AwardItem.addFinalAuctions(auctions);
        assertTrue(AwardItem.decideWinner(auctionsAfterTie));

        auctions = new int[]{};
        AwardItem.addFinalAuctions(auctions);
        assertFalse(AwardItem.awardItem(auctions));
    }

}
