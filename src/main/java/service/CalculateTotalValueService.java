package main.java.service;

import main.java.client.IRestClient;
import main.java.model.CryptoItem;
import main.java.model.Currency;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class CalculateTotalValueService implements ICalculateTotalValueService {

    @Override
    public BigDecimal getTotalValue(Currency currency, IRestClient client, List<CryptoItem> cryptoItems) throws IllegalArgumentException {
        if(cryptoItems == null) throw new IllegalArgumentException("Null input list");

        Optional<BigDecimal> eur = cryptoItems.stream()
                .map(item -> {
                    try {
                        BigDecimal val = client.getPrice(item.getSymbol(), currency)
                                .multiply(new BigDecimal(item.getValue()));
                        System.out.println("You have " + val + " " + currency + " of " + item.getSymbol());
                        System.out.println("--------");
                        return val;
                    } catch (IOException e) {
                        System.out.println("Invalid item " + item);
                        System.out.println("--------");
                        return BigDecimal.ZERO;
                    }
                })
                .reduce(BigDecimal::add);
        return eur.orElseThrow(IllegalArgumentException::new);
    }
}
