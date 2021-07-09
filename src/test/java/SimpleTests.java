import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class SimpleTests {

    Hotel hotelParqueDasFlores = new Hotel("Parque das flores", 3, 110, 80, 90, 80);
    Hotel hotelJardimBotanico = new Hotel("Jardim botânico", 4, 160, 110, 60, 50);
    Hotel hotelMarAtlantico = new Hotel("Mar Atlântico", 5, 220, 100, 150, 40);

    List<Hotel> availableHotels = Arrays.asList(
            hotelParqueDasFlores,
            hotelJardimBotanico,
            hotelMarAtlantico
    );

    @Test
    public void estimateTest01() {

        EstimateParam estimateParam = new EstimateParam(ClientTypeEnum.REGULAR,
                Arrays.asList(
                        LocalDate.of(2020, 3, 16),
                        LocalDate.of(2020, 3, 17),
                        LocalDate.of(2020, 3, 18))
        );

        EstimateCheck estimateCheck = new EstimateCheck(availableHotels);

        Estimate cheaper = estimateCheck.findCheaper(estimateParam);

        Logger.getLogger(SimpleTests.class.getName()).info(cheaper.toString());

        assertEquals(hotelParqueDasFlores, cheaper.getHotel());

    }

    @Test
    public void estimateTest02() {

        EstimateParam estimateParam = new EstimateParam(ClientTypeEnum.REGULAR,
                Arrays.asList(
                        LocalDate.of(2020, 3, 20),
                        LocalDate.of(2020, 3, 21),
                        LocalDate.of(2020, 3, 22))
        );

        EstimateCheck estimateCheck = new EstimateCheck(availableHotels);

        Estimate cheaper = estimateCheck.findCheaper(estimateParam);

        Logger.getLogger(SimpleTests.class.getName()).info(cheaper.toString());

        assertEquals(hotelJardimBotanico, cheaper.getHotel());

    }

    @Test
    public void estimateTest03() {

        EstimateParam estimateParam = new EstimateParam(ClientTypeEnum.LOYAL,
                Arrays.asList(
                        LocalDate.of(2020, 3, 26),
                        LocalDate.of(2020, 3, 27),
                        LocalDate.of(2020, 3, 28))
        );

        EstimateCheck estimateCheck = new EstimateCheck(availableHotels);

        Estimate cheaper = estimateCheck.findCheaper(estimateParam);

        Logger.getLogger(SimpleTests.class.getName()).info(cheaper.toString());

        assertEquals(hotelMarAtlantico, cheaper.getHotel());

    }
}
