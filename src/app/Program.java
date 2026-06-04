package app;

import modell.Harcos;
import modell.Varazslo;
import java.util.Random;

public class Program {

    private static final Random RND = new Random();

    public static void main(String[] args) {
        /* Kimenet Terv - Tömbbel */
        // ⚔ _ 🔮 karakter
        // 1 2 3 mezo
        // _ X _ harc

        /**
         * Fejelsztés do while be kérés ne legyen osztályba kiírás
         */
        /**
         * Példányonsítás
         */
        Harcos harcos = new Harcos();
        Varazslo varazslo = new Varazslo();

        /**
         * Infó + toString
         */
        System.out.println("=== HARCOS vs VARÁZSLÓ JÁTÉK ===");
        System.out.println("A karakterek 1-3 mezők között lépnek.");
        System.out.println("Ha ugyanarra a mezőre lépnek, harcolnak!\n");

        System.out.println("<--- Kezdő Értékek --->");
        System.out.println(harcos);
        System.out.println(varazslo + "\n");

        int kor = 1;
        //addig fut amíg mind ketten élnek
        while (harcos.getEletEro() > 0 && varazslo.getEletEro() > 0) { //azért && mert a || tovább menne
            System.out.println("\n----------------------------------------");
            System.out.println(kor + ". kör:");

            /**
             * Kiírás a kör elején (toString-et használva)
             */
            System.out.println(harcos);
            System.out.println(varazslo);

            /**
             * Random lépések
             */
//            int hLepes = RND.nextInt(3);
//            int vLepes = RND.nextInt(3);
//
//            harcos.setMezo(hLepes);
//            varazslo.setMezo(vLepes);
//
//            System.out.println("\n" + harcos.getNev() + " a " + (harcos.getMezo() + 1) + ". mezőre lépett");
//            System.out.println(varazslo.getNev() + " a " + (varazslo.getMezo() + 1) + ". mezőre lépett");
                
            harcos.lep();
            varazslo.lep();

            /**
             * Harc ellenőrzés
             */
            if (harcos.getMezo() == varazslo.getMezo()) {
                System.out.println("\n*** HARC! ***");
                //System.out.println("X");
                
                //sebzés
                int harcosSebzes = harcos.sebzes();
                int varazsloSebzes = varazslo.sebzes();
                
                //Életpontok csökkentése
                varazslo.setEletEro(varazslo.getEletEro() - harcosSebzes);
                harcos.setEletEro(harcos.getEletEro() - varazsloSebzes);

                System.out.println("\n=== Élet Kiírás ===");
                System.out.println("⚔ " + harcos.getNev() + harcos.eletInfo());
                System.out.println("🔮 " + varazslo.getNev() + varazslo.eletInfo());

            } else {
                System.out.println("\n(Nem találkoztak)");
            }

            /**
             * Gyógyulás minden kör végén A feltétel akkor teljesül, ha a
             * varázsló életereje nagyobb, mint 0.
             */
            if (varazslo.getEletEro() > 0) {
                if (varazslo.gyogyul()) {
                    System.out.println("=== VARÁZSLÓ GYÓGYUL ===");
                }
            }

            /**
             * Ne menjen a végtelenségig, AI ajánlotta
             */
            kor++;
            if (kor > 15) {
                System.out.println("!!! Túl sok körig ment !!!");
                break;
            }
        }

        // Végeredmény
        System.out.println("\n=== JÁTÉK VÉGE ===");
        if (harcos.getEletEro() <= 0 && varazslo.getEletEro() <= 0) { //ha a Harcos és a Varázsló életereje is 0 vagy annál kisebb.
            System.out.println("DÖNTETLEN! Mindketten meghaltak.");
        } else if (harcos.getEletEro() <= 0) {//ha a Harcos életereje 0 vagy annál kisebb.
            System.out.println(varazslo.getNev() + " győzött!");
        } else {
            System.out.println(harcos.getNev() + " győzött!");
        }
    }//main

}//class
