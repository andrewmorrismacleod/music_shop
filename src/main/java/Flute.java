public class Flute extends Instrument implements IPlay {

    private int numberOfHoles;

    public Flute(String maker) {
        super("Flute", maker, "Metal", Types.WOODWIND, 200, 650);
        this.numberOfHoles = 16;
    }

    public int getNumberOfButtons() {
        return numberOfHoles;
    }

    public String play(){
        return "Spring";
    }
}

