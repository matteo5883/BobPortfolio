package service;

import main.java.client.MockedRestClient;
import main.java.model.CryptoItem;
import main.java.model.Currency;
import main.java.service.CalculateTotalValueService;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class CalculateTotalValueServiceTest {

    private CalculateTotalValueService service = new CalculateTotalValueService();

    @Test
    public void getTotalValue() {
        CryptoItem mockedItem = new CryptoItem().setSymbol("EUR").setValue(1l);
        BigDecimal actualValue = service.getTotalValue(Currency.EUR, new MockedRestClient(), Collections.singletonList(mockedItem));
        assertEquals(BigDecimal.TEN, actualValue);
    }

    @Test
    public void getTotalValue_clientException() {
        CryptoItem mockedItem = new CryptoItem().setSymbol("USD").setValue(1l);
        BigDecimal actualValue = service.getTotalValue(Currency.USD, new MockedRestClient(), Collections.singletonList(mockedItem));
        assertEquals(BigDecimal.ZERO, actualValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTotalValue_exceptionEmptyList() {
        service.getTotalValue(Currency.USD, new MockedRestClient(), Collections.emptyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTotalValue_exceptionNullList() {
        service.getTotalValue(Currency.USD, new MockedRestClient(), null);
    }

}