package main.java.client;

import main.java.model.Currency;

import java.io.IOException;
import java.math.BigDecimal;

public interface IRestClient {

    BigDecimal getPrice(String fsym, Currency tsyms) throws IOException;
}
