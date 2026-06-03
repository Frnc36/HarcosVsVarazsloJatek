package app;

import modell.Harcos;
import modell.Varazslo;
import java.util.Random;

public class Program {

    private static final Random RND = new Random();

    public static void main(String[] args) {
        /* Kimenet Terv */
        // ⚔ _ 🔮
        // 1. 2. 3.
        // _  X  _

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

        while (harcos.getEletEro() > 0 && varazslo.getEletEro() > 0) {
            System.out.println("----------------------------------------");
            System.out.println(kor + ". kör:");

            /**
             * Kiírás a kör elején (toString-et használva)
             */
            System.out.println(harcos);
            System.out.println(varazslo);

            /**
             * Random lépések
             */
            int hLepes = RND.nextInt(3);
            int vLepes = RND.nextInt(3);

            harcos.setMezo(hLepes);
            varazslo.setMezo(vLepes);

            System.out.println("\n" + harcos.getNev() + " a " + (harcos.getMezo() + 1) + ". mezőre lépett");
            System.out.println(varazslo.getNev() + " a " + (varazslo.getMezo() + 1) + ". mezőre lépett");

            /**
             * Harc ellenőrzés
             */
            if (harcos.getMezo() == varazslo.getMezo()) {
                System.out.println("\n*** HARC! ***");
                System.out.println("X");

                int harcosSebzes = harcos.sebzes();
                int varazsloSebzes = varazslo.sebzes();

                varazslo.setEletEro(varazslo.getEletEro() - harcosSebzes);
                harcos.setEletEro(harcos.getEletEro() - varazsloSebzes);

                System.out.println("\n" + harcos.getNev() + " élete: " + Math.max(0, harcos.getEletEro()));
                System.out.println(varazslo.getNev() + " élete: " + Math.max(0, varazslo.getEletEro()));
            } else {
                System.out.println("\n(Nem találkoztak)");
            }

            /**
             * Gyógyulás minden kör végén A feltétel akkor teljesül, ha a
             * varázsló életereje nagyobb, mint 0.
             */
            if (varazslo.getEletEro() > 0) {
                varazslo.gyogyul();
            }

            /**
             * Ne menjen a végtelenségig
             */
            kor++;
            if (kor > 3) {
                System.err.println("Túl sok körig ment");
                break;
            }
        }

        // Végeredmény
        System.out.println("=== JÁTÉK VÉGE ===");
        if (harcos.getEletEro() <= 0 && varazslo.getEletEro() <= 0) { //ha a Harcos és a Varázsló életereje is 0 vagy annál kisebb.
            System.out.println("DÖNTETLEN! Mindketten meghaltak.");
        } else if (harcos.getEletEro() <= 0) {//ha a Harcos életereje 0 vagy annál kisebb.
            System.out.println(varazslo.getNev() + " győzött!");
        } else {
            System.out.println(harcos.getNev() + " győzött!");
        }
    }//main

}//class
