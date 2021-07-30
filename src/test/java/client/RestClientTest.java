package client;

import main.java.client.IRestClient;
import main.java.client.RestClient;
import main.java.model.Currency;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class RestClientTest {

    private IRestClient client = new RestClient();

    @Test
    public void getPrice() throws IOException {
        assertNotNull(client.getPrice("BTC", Currency.EUR));
    }
}