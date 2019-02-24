import javax.sound.midi.*;
import javax.sound.midi.Instrument;
import java.util.HashMap;
import java.util.Scanner;

public class PlayTheInstrument {

        public static void main(String[] args) {

            System.out.println("Turn up the volume on your machine %n");
            System.out.println("Please enter your name");
            Scanner reader = new Scanner(System.in);
            String name = reader.nextLine();
            String instrument;

            HashMap<String, Integer> MidiList = MidiInstruments();

            int instrumentNumber = 81;

            while (instrumentNumber > 80) {

                System.out.println("Type in an instrument name - consult MidiInstruments HashMap for list");
                instrument = reader.nextLine();

                if (MidiList.containsKey(instrument)) {
                    instrumentNumber = MidiList.get(instrument);
                    System.out.printf("Playing %s on the %s", name, instrument);
                } else {
                    System.out.println("Not a valid instrument!!!");
                }
            }

            try {

                Synthesizer midiSynth = MidiSystem.getSynthesizer();
                midiSynth.open();

                Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();

//                midiSynth.loadInstrument(instr[instrumentNumber]);
                MidiChannel[] mChannels = midiSynth.getChannels();
                mChannels[0].programChange(0,instrumentNumber);


                for (String letter : name.split("")){
                    int note = ((int) letter.charAt(0))-15;
                    playSingleNote(mChannels[0], note);
                }


            } catch (MidiUnavailableException e) {}
        }

        public static void playSingleNote(MidiChannel mChannel, int note){

            mChannel.noteOn(note, 200);
            try { Thread.sleep(250);
            } catch( InterruptedException e ) { }
            mChannel.noteOff(note);
        }

        public static HashMap<String, Integer> MidiInstruments(){

            HashMap<String, Integer> instruments = new HashMap<>();

            instruments.put("Acoustic Grand Piano",1);
            instruments.put("Bright Acoustic Piano",2);
            instruments.put("Electric Grand Piano",3);
            instruments.put("Honky-tonk Piano",4);
            instruments.put("Electric Piano 1",5);
            instruments.put("Electric Piano 2",6);
            instruments.put("Harpsichord",7);
            instruments.put("Clavi",8);
            instruments.put("Celesta",9);
            instruments.put("GLockenspiel",10);
            instruments.put("Music Box",11);
            instruments.put("Vibraphone",12);
            instruments.put("Mariba",13);
            instruments.put("Xylophone",14);
            instruments.put("Tubular Bells",15);
            instruments.put("Dulcimer",16);
            instruments.put("Drawbar Organ",17);
            instruments.put("Percussive Organ",18);
            instruments.put("Rock Organ",19);
            instruments.put("Church Organ",20);
            instruments.put("Reed Organ",21);
            instruments.put("Accordion",22);
            instruments.put("Harmonica",23);
            instruments.put("Tango Accordion",24);
            instruments.put("Acoustic Guitar (nylon)",25);
            instruments.put("Acoustic Guitar (steel)",26);
            instruments.put("Acoustic Guitar (jazz)",27);
            instruments.put("Acoustic Guitar (clean)",28);
            instruments.put("Acoustic Guitar (muted)",29);
            instruments.put("Overdriven Guitar",30);
            instruments.put("Distortion Guitar",31);
            instruments.put("Guitar Harmonics",32);
            instruments.put("Acoustic Bass",34);
            instruments.put("Electric Bass (finger)",34);
            instruments.put("Electric Bass (pick)",35);
            instruments.put("Fretless Bass",36);
            instruments.put("Slap Bass 1",37);
            instruments.put("Slap Bass 2",38);
            instruments.put("Synth Bass 1",39);
            instruments.put("Synth Bass 2",40);
            instruments.put("Violin",41);
            instruments.put("Viola",42);
            instruments.put("Cello",43);
            instruments.put("Contrabass",44);
            instruments.put("Tremolo Strings",45);
            instruments.put("Pizzicato Strings",46);
            instruments.put("Orchestral Harp",47);
            instruments.put("Timpani",48);
            instruments.put("String Ensemble 1",49);
            instruments.put("String Ensemble 2",50);
            instruments.put("Synth Strings 1",51);
            instruments.put("Synth Strings 2",52);
            instruments.put("Choir Aaahs",53);
            instruments.put("Choir Oohs",54);
            instruments.put("Synth Voice",55);
            instruments.put("Orchestra Hit",56);
            instruments.put("Trumpet",57);
            instruments.put("Trombone",58);
            instruments.put("Tuba",59);
            instruments.put("Muted Trumpet",60);
            instruments.put("French Horn",61);
            instruments.put("Brass Section",62);
            instruments.put("SynthBrass 1",63);
            instruments.put("SynthBrass 2",64);
            instruments.put("Soprano Sax",65);
            instruments.put("Alto Sax",66);
            instruments.put("Tenor Sax",67);
            instruments.put("Baritone Sax",68);
            instruments.put("Oboe",69);
            instruments.put("English Horn",70);
            instruments.put("Bassoon",71);
            instruments.put("Clarinet",72);
            instruments.put("Piccolo",73);
            instruments.put("Flute",74);
            instruments.put("Recorder",75);
            instruments.put("Pan Flute",76);
            instruments.put("Blown Bottle",77);
            instruments.put("Shakuhachi",78);
            instruments.put("Whistle",79);
            instruments.put("Ocarina",80);

            return instruments;
        }

}


