package main.java.client;

import main.java.model.Currency;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;

public class MockedRestClient implements IRestClient {
    @Override
    public BigDecimal getPrice(String fsym, Currency tsyms) throws IOException {
        if(Objects.equals("EUR", fsym))
            return BigDecimal.TEN;

        throw new IOException("");
    }
}
