package model;

import main.java.model.CryptoItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CryptoItemTest {

    private CryptoItem item;

    @Before
    public void setUp() throws Exception {
        item = new CryptoItem();
    }

    @Test
    public void getSymbol() {
        Assert.assertEquals(null, item.getSymbol());
    }

    @Test
    public void getValue() {
        Assert.assertEquals(null, item.getValue());
    }

    @Test
    public void setSymbol() {
        Assert.assertEquals("EUR", item.setSymbol("EUR").getSymbol());
    }

    @Test
    public void setValue() {
        Assert.assertEquals(new Long(1L), item.setValue(1L).getValue());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("CryptoItem{symbol='null', value=null}", item.toString());
    }
}