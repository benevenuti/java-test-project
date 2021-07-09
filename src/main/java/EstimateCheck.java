import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EstimateCheck {
    private final List<Hotel> availableHotels;

    public EstimateCheck(List<Hotel> availableHotels) {
        this.availableHotels = availableHotels;
    }

    public Estimate findCheaper(EstimateParam estimateParam) {
        Comparator<Estimate> priceComparator = Comparator.comparingInt(Estimate::getPrice)
                .thenComparingInt(estimate -> estimate.getHotel().getLevel() * -1); // sorry

        List<Estimate> estimateList = availableHotels.stream()
                .map(hotel -> hotel.doEstimate(estimateParam))
                .sorted(priceComparator)
                .collect(Collectors.toList());

        return estimateList.get(0);
    }
}
