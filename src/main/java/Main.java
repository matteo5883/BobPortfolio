package main.java;

import main.java.client.IRestClient;
import main.java.client.RestClient;
import main.java.model.CryptoItem;
import main.java.model.Currency;
import main.java.service.CalculateTotalValueService;
import main.java.service.ICalculateTotalValueService;
import main.java.service.IParseFileService;
import main.java.service.ParseFileService;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String file;
        Currency currency;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            file = args[0];
            System.out.println("args[0] passed as input : " + file);
        } else {
            file = "src\\main\\resources\\bobs_crypto.txt";
            System.out.println("Default file taken as input file : " + file);
        }
        System.out.println("--------");
        if (args.length > 1 && args[1] != null && !"".equals(args[1])) {
            try {
                currency = Currency.valueOf(args[1].toUpperCase());
                System.out.println("args[1] passed as input : " + currency);
            } catch (IllegalArgumentException e) {
                System.out.println("Sorry I don't know the currency you put. I'll be better in future. For now let keep going using EUR");
                currency = Currency.EUR;
            }
        } else {
            currency = Currency.EUR;
            System.out.println("Default currency taken as currency : " + currency);
        }
        System.out.println("--------");
        IParseFileService util = new ParseFileService();
        IRestClient client = new RestClient();
        try {
            ICalculateTotalValueService calculateTotalValueService = new CalculateTotalValueService();
            List<CryptoItem> cryptoItems = util.parseFile(file);
            BigDecimal totalValue = calculateTotalValueService.getTotalValue(currency, client, cryptoItems);
            System.out.println("Portfolio total value : " + totalValue + " " + currency);
        } catch (IllegalArgumentException e) {
            System.out.println("Error during calculation");
        }

    }
}
