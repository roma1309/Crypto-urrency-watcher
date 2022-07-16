package crypto.restCrypto.model;

public class Price {

    private double price;
    private String symbol;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Price{" +
                "price=" + price +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
