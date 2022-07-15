package crypto.restCrypto.model.entity;

public class CoinLore {
    private long id;
    private String symbol;
    private String name;
    private String nameId;
    private String rank;
    private double price_usd;
    private double percent_change_24h;
    private double percent_change_1h;
    private double percent_change_7d;
    private double market_cap_usd;
    private double volume24;
    private double volume24_native;
    private double csupply;
    private double price_btc;
    private double tsupply;
    private double msupply;

    public CoinLore() {
    }

    public CoinLore(long id, String symbol,
                    String name, String nameId,
                    String rank, double price_usd,
                    double percent_change_24h, double percent_change_1h,
                    double percent_change_7d, double market_cap_usd,
                    double volume24, double volume24_native, double csupply,
                    double price_btc, double tsupply, double msupply) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.nameId = nameId;
        this.rank = rank;
        this.price_usd = price_usd;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_1h = percent_change_1h;
        this.percent_change_7d = percent_change_7d;
        this.market_cap_usd = market_cap_usd;
        this.volume24 = volume24;
        this.volume24_native = volume24_native;
        this.csupply = csupply;
        this.price_btc = price_btc;
        this.tsupply = tsupply;
        this.msupply = msupply;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public double getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(double price_usd) {
        this.price_usd = price_usd;
    }

    public double getPercent_change_24h() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(double percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public double getPercent_change_1h() {
        return percent_change_1h;
    }

    public void setPercent_change_1h(double percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

    public double getPercent_change_7d() {
        return percent_change_7d;
    }

    public void setPercent_change_7d(double percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }

    public double getMarket_cap_usd() {
        return market_cap_usd;
    }

    public void setMarket_cap_usd(double market_cap_usd) {
        this.market_cap_usd = market_cap_usd;
    }

    public double getVolume24() {
        return volume24;
    }

    public void setVolume24(double volume24) {
        this.volume24 = volume24;
    }

    public double getVolume24_native() {
        return volume24_native;
    }

    public void setVolume24_native(double volume24_native) {
        this.volume24_native = volume24_native;
    }

    public double getCsupply() {
        return csupply;
    }

    public void setCsupply(double csupply) {
        this.csupply = csupply;
    }

    public double getPrice_btc() {
        return price_btc;
    }

    public void setPrice_btc(double price_btc) {
        this.price_btc = price_btc;
    }

    public double getTsupply() {
        return tsupply;
    }

    public void setTsupply(double tsupply) {
        this.tsupply = tsupply;
    }

    public double getMsupply() {
        return msupply;
    }

    public void setMsupply(double msupply) {
        this.msupply = msupply;
    }
}
