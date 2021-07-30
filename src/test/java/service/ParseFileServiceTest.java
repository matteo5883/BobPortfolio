package service;

import main.java.model.CryptoItem;
import main.java.service.ParseFileService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParseFileServiceTest {

    private ParseFileService service;

    @Before
    public void setUp() throws Exception {
        service = new ParseFileService();
    }

    @Test
    public void parseFile_wrongFilename() {
        assertEquals(0, service.parseFile("a file").size());
    }

    @Test
    public void parseFile() {
        assertEquals(1, service.parseFile("src\\test\\resources\\bobs_crypto.txt").size());
    }

    @Test
    public void parseFile_checkItem() {
        List<CryptoItem> cryptoItems = service.parseFile("src\\test\\resources\\bobs_crypto.txt");
        assertEquals("BTC", cryptoItems.get(0).getSymbol());
        assertEquals(new Long(10), cryptoItems.get(0).getValue());
    }
}