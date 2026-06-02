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
     * Varázsló képes gyógyulni
     * Mikor igaz akkor a 9 től is több lehet
     */
    public void gyogyul() {
        if (RND.nextInt(100) < 40) { //40% eséllyel
            int gygogyitoErtek = 3;
            int ujElet = getEletEro() + gygogyitoErtek;
            if (ujElet > 9) {
                ujElet = 9;
            }
            setEletEro(ujElet);
            System.out.println("*** VARÁZSLÓ GYÓGYUL! ***");
        }else{
            
        }
    }

}//class
