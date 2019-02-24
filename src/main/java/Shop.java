import java.util.ArrayList;
import java.util.stream.DoubleStream;

public class Shop {

    ArrayList<ISell> stock;

    public Shop(ArrayList<ISell> stock) {
        this.stock = stock;
    }

    public void addItem(ISell item){
        this.stock.add(item);
    }

    public void removeItem(ISell item){
        this.stock.remove(item);
    }

    public ArrayList<ISell> totalStock(){
        return this.stock;
    }

    public double totalPotentialProfit(){
        return this.stock.stream().mapToDouble( (item) -> item.calculateMarkUp()).sum();
    }
}
