package main.java.model;

public class CryptoItem {

    private String symbol;
    private Long value;

    public String getSymbol() {
        return symbol;
    }

    public Long getValue() {
        return value;
    }

    public CryptoItem setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public CryptoItem setValue(Long value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "CryptoItem{" +
                "symbol='" + symbol + '\'' +
                ", value=" + value +
                '}';
    }
}
