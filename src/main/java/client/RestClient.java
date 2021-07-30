package main.java.client;

import main.java.model.Currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestClient implements IRestClient {

    private final String URL = "https://min-api.cryptocompare.com/data/price?fsym={fsym}&tsyms={tsyms}";

    private String getPriceString(String fsym, Currency tsyms) throws IOException {
        URL url = null;
        HttpURLConnection con = null;
        try {
            String parseUrl = URL.replace("{fsym}", fsym).replace("{tsyms}", tsyms.name());
            url = new URL(parseUrl);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            return content.toString();

        }
        catch (IOException e) {
            throw e;
        }
    }

    public BigDecimal getPrice(String fsym, Currency tsyms) throws IOException {
        String priceString = getPriceString(fsym, tsyms);
        String trim = priceString
                .replace("{", "")
                .replace("}", "")
                .replace("\"", "")
                .replace(tsyms.name(), "")
                .replace(":", "")
                .trim();
        return new BigDecimal(trim);
    }

}
