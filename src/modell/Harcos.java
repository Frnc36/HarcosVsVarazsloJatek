package modell;

import java.util.Random;

public class Harcos extends Jatekos {

    private static final Random RND = new Random();

    public Harcos() {
        //      nev, sebzes, mezo
        super("Harcos", 3, 0);
    }

    @Override
    public String toString() {
        return "⚔️ " + getNev() + " | ❤️ " + getEletEro() + " | 🗡️ " + getSebzes() + " | 📍 " + (getMezo() + 1);
    }
    
    /**
     * Harcosna van eséllye dupla sebzése
     */
    @Override
    public int sebzes() {
        int alapSebzes = getSebzes();
        boolean dupla = RND.nextInt(100) < 30; // 30% eséllyel
        if (dupla) {
            System.out.println("*** HARCOS DUPLA SEBZÉS! ***");
            System.out.println("Harcos sebzése: " + (alapSebzes * 2));
            return alapSebzes * 2;
        } else {
            System.out.println("Harcos sebzése: " + alapSebzes);
            return alapSebzes;
        }
    }

}//class
