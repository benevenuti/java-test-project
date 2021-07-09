import java.util.StringJoiner;

public class Hotel {
    private final String name;
    private final int level;
    private final int weekdayRegularPrice;
    private final int weekdayLoyalPrice;
    private final int weekendRegularPrice;
    private final int weekendLoyalPrice;

    public Hotel(String name, int level, int weekdayRegularPrice, int weekdayLoyalPrice, int weekendRegularPrice, int weekendLoyalPrice) {
        this.name = name;
        this.level = level;
        this.weekdayRegularPrice = weekdayRegularPrice;
        this.weekdayLoyalPrice = weekdayLoyalPrice;
        this.weekendRegularPrice = weekendRegularPrice;
        this.weekendLoyalPrice = weekendLoyalPrice;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getWeekdayRegularPrice() {
        return weekdayRegularPrice;
    }

    public int getWeekdayLoyalPrice() {
        return weekdayLoyalPrice;
    }

    public int getWeekendRegularPrice() {
        return weekendRegularPrice;
    }

    public int getWeekendLoyalPrice() {
        return weekendLoyalPrice;
    }

    public Estimate doEstimate(EstimateParam estimateParam) {

        int valor = estimateParam.getDatas().stream().mapToInt(data -> {
            // fds
            if (data.getDayOfWeek().getValue() >= 6) {
                if (estimateParam.getClientType().equals(ClientTypeEnum.REGULAR)) {
                    return this.weekendRegularPrice;
                } else {
                    return this.weekendLoyalPrice;
                }
            } else {
                if (estimateParam.getClientType().equals(ClientTypeEnum.REGULAR)) {
                    return this.weekdayRegularPrice;
                } else {
                    return this.weekdayLoyalPrice;
                }
            }
        }).sum();

        return new Estimate(this, valor);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Hotel.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("level=" + level)
                .toString();
    }
}
