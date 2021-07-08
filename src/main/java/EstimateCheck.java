import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EstimateCheck {
    private final List<Hotel> availableHotels;

    public EstimateCheck(List<Hotel> availableHotels) {
        this.availableHotels = availableHotels;
    }

    public Hotel findCheaper(EstimateParam estimateParam) {
        Estimate[] estimateList = (Estimate[]) availableHotels.stream().map(hotel -> hotel.doEstimate(estimateParam)).toArray();

        Comparator<Estimate> priceComparator = Comparator.comparingInt(Estimate::getPrice)
                .thenComparingInt(estimate -> estimate.getHotel().getLevel()).reversed();

        Arrays.sort(estimateList, priceComparator);

        return estimateList[0].getHotel();
    }
}
