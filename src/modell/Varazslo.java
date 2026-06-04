/*
    Az utódosztályokban azért nem lehet generálni hashCode() és equals() metódusokat, 
    mert a Jatekos osztály adattagjai private-ok
 */
package modell;

import java.util.Random;

public class Varazslo extends Karakter {

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
     * Varázsló képes gyógyulni 40% eséllyel gyógyul +3 életet, de maximum 9
     * életet érhet el
     *
     * @return true ha sikerült a gyógyulás, false ha nem
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
