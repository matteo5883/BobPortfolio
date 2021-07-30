package main.java.service;

import main.java.client.IRestClient;
import main.java.model.CryptoItem;
import main.java.model.Currency;

import java.math.BigDecimal;
import java.util.List;

public interface ICalculateTotalValueService {

    BigDecimal getTotalValue(Currency currency, IRestClient client, List<CryptoItem> cryptoItems) throws IllegalArgumentException;
}
