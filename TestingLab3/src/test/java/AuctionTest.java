import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuctionTest {

    // ogni entità (tipo "User" o "Seller") é una diversa classe di test
    // ogni user story test / acceptance test è un metodo di test
    // ogni test case di un'acceptance test é un assertion nel metodo di test

    @Test
    public void registerBid() {
        RegisterBid.setBasePrice(400);
        RegisterBid.setIncrement(10);
        assertTrue(RegisterBid.registerBid(500));
        assertFalse(RegisterBid.registerBid(495));
    }


    @Test
    public void isOngoing(){
        IsOngoing.setStartTime("8:00 16/06/2023");
        IsOngoing.setEndTime("11:00 16/06/2023");
        IsOngoing.setCurrentTime("8:00 15/06/2023");
        assertFalse(IsOngoing.isOngoing(IsOngoing.getCurrentTime()));
        IsOngoing.setCurrentTime("8:30 16/06/2023");
        assertTrue(IsOngoing.isOngoing(IsOngoing.getCurrentTime()));
        IsOngoing.setCurrentTime("12:30 17/06/2023");
        assertFalse(IsOngoing.isOngoing(IsOngoing.getCurrentTime()));
    }

    @Test
    public void checkRemainingTime() {
        CheckRemainingTime.setRemainingTime(142.76);
        assertTrue(CheckRemainingTime.getRemainingTime() > 0.0);
        CheckRemainingTime.setRemainingTime(0.0);
        assertFalse(CheckRemainingTime.getRemainingTime() > 0.0);
    }

    @Test
    public void awardItem() {

    }
}
