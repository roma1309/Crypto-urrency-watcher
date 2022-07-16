package crypto.restCrypto.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cryptocurrency {
    private long id;
    @Id
    private String symbol;
    private double price;

    @OneToMany(mappedBy = "cryptocurrency", fetch = FetchType.EAGER)
    private List<User> users;

    public Cryptocurrency() {
    }

    public Cryptocurrency(long id, String symbol) {
        this.id = id;
        this.symbol = symbol;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Cryptocurrency{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                ", users=" + users +
                '}';
    }
}

