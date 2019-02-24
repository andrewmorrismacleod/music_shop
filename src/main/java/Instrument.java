public abstract class Instrument implements ISell{

    protected String description;
    protected String maker;
    protected String material;
    protected Types type;
    protected double buy;
    protected double sell;

    public Instrument(String description, String maker, String material, Types type, double buy, double sell) {
        this.description = description;
        this.maker = maker;
        this.material = material;
        this.type = type;
        this.buy = buy;
        this.sell = sell;
    }

    public String getMaker() {
        return maker;
    }

    public String getMaterial() {
        return material;
    }

    public Types getType() {
        return type;
    }

    public double calculateMarkUp(){
        return this.sell - this.buy;
    }

    public double getSell(){
        return this.sell;
    }

    public double getBuy(){
        return this.buy;
    }
}
