public class Cello extends Instrument implements IPlay {

    private int numberOfStrings;

    public Cello(String maker) {
        super("Cello", maker, "Wood", Types.STRING, 400, 600);
        this.numberOfStrings = 4;
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public String play(){
        return "The Swan";
    }

    public void playNotes(){

    }
}
