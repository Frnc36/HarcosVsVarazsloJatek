package modell;

import java.util.Random;

public class Varazslo extends Jatekos {

    private static final Random RND = new Random();

    public Varazslo() {
        //      nev, sebzes, mezo
        super("Varázsló", 3, 2);
    }

    @Override
    public String toString() {
        return "🔮 " + getNev() + " | ❤️ " + getEletEro() + " | 🗡️ " + getSebzes() + " | 📍 " + (getMezo() + 1);
    }

    public void gyogyul() {
        if (RND.nextInt(100) < 40) {
            int gygogyitoErtek = 2;
            int ujElet = getEletEro() + gygogyitoErtek;
            if (ujElet > 9) {
                ujElet = 9;
            }
            setEletEro(ujElet);
            System.out.println("*** GYÓGYUL! ***");
        }
    }

}//class
