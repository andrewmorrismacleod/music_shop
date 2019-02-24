import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ShopTest {

    Shop shop;
    Cello cello;
    Flute flute;
    ArrayList<ISell> stock;

    @Before
    public void before(){
        cello = new Cello("Stradivarius");
        flute = new Flute("Brannen");
        stock = new ArrayList<>();
        stock.add(cello);
        stock.add(flute);
        shop = new Shop(stock);
    }

    @Test
    public void celloHasStrings(){
        assertEquals(4, ((Cello) shop.stock.get(0)).getNumberOfStrings());
    }

    @Test
    public void celloCanBePlayed(){
        assertEquals("The Swan", ((Cello) shop.stock.get(0)).play());
    }

    @Test
    public void shopHasStock(){
        assertEquals(2, shop.stock.size());
    }

    @Test
    public void shopHasCelloProfit(){
        assertEquals(200,shop.stock.get(0).calculateMarkUp(),0.01);
    }

    @Test
    public void hasTotalProfit(){
        assertEquals(650,shop.totalPotentialProfit(),0.01);
    }


}
