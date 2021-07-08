public class Estimate {
    private final Hotel hotel;
    private final int price;

    public Estimate(Hotel hotel, int price) {
        this.hotel = hotel;
        this.price = price;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public int getPrice() {
        return price;
    }

}
