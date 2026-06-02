package modell;

import java.util.Random;

public class Harcos extends Jatekos {

    private static final Random RND = new Random();

    public Harcos() {
        //      nev, sebzes, mezo
        super("Harcos", 2, 0);
    }

    @Override
    public String toString() {
        return "⚔️ " + getNev() + " | ❤️ " + getEletEro() + " | 🗡️ " + getSebzes() + " | 📍 " + (getMezo() + 1);
    }

    @Override
    public int sebzes() {
        int alapSebzes = getSebzes();
        if (RND.nextInt(100) < 30) {
            System.out.println("*** DUPLA SEBZÉS! ***");
            return alapSebzes * 2;
        }
        return alapSebzes;
    }

}//class
