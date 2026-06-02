package modell;

import java.util.Random;

public class Jatekos {

    private static final Random RND = new Random();

    private String nev;
    private int eletEro;
    private int sebzes;
    private int mezo;

    public Jatekos(String nev, int sebzes, int mezo) {
        this.nev = nev;
        this.eletEro = 9;   // fix 9, mindenki ezt örökli
        this.sebzes = sebzes;
        this.mezo = mezo;
    }

    public String getNev() {
        return nev;
    }

    public int getEletEro() {
        return eletEro;
    }

    public int getSebzes() {
        return sebzes;
    }

    public int getMezo() {
        return mezo;
    }

    public void setEletEro(int eletEro) {
        this.eletEro = eletEro;
    }

    public void setMezo(int mezo) {
        this.mezo = mezo;
    }

    @Override
    public String toString() {
        return "Jatekos{" + "nev=" + nev + ", eletEro=" + eletEro + ", sebzes=" + sebzes + ", mezo=" + mezo + '}';
    }

    public int sebzes() {
        System.out.println(nev + " sebzése: " + sebzes);
        return sebzes;
    }

    public void lep() {
        int ujMezo = RND.nextInt(3);  // 0, 1 vagy 2
        int regMezo = this.mezo;
        this.mezo = ujMezo;
        System.out.println(nev + " lép: " + regMezo + " -> " + ujMezo);
    }

}//class
