package modell;

import java.util.Random;

public class Varazslo extends Jatekos {

    private static final Random RND = new Random();

    public Varazslo() {
        //      nev, sebzes, mezo
        super("Varázsló", 2, 2);
    }

    @Override
    public String toString() {
        return "🔮 " + getNev() + " | ❤️ " + getEletEro() + " | 🗡️ " + getSebzes() + " | 📍 " + (getMezo() + 1);
    }

    /**
     * Varázsló képes gyógyulni Mikor igaz akkor a 9 től is több lehet
     * @return 
     */
    public boolean gyogyul() {
        if (RND.nextInt(100) < 40) { //40% eséllyel
            int gyogyitoErtek = 3;
            int ujElet = getEletEro() + gyogyitoErtek;
            if (ujElet > 9) {
                ujElet = 9;
            }
            setEletEro(ujElet);
            return true;  // Sikeres gyógyulás
        } else {
            return false; // Nem sikerült a gyógyulás
        }
    }

}//class
