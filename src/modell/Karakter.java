package modell;

import java.util.Objects;
import java.util.Random;

public class Karakter {

    private static final Random RND = new Random();

    private String nev;
    private int eletEro;
    private int sebzes;
    private int mezo;

    public Karakter(String nev, int sebzes, int mezo) {
        this.nev = nev;
        this.eletEro = 9;   //fix 9, mindenki ezt örökli
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

    //Élet módosítása (harconként)
    public void setEletEro(int eletEro) {
        this.eletEro = eletEro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nev);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Karakter other = (Karakter) obj;
        return Objects.equals(this.nev, other.nev);
    }

    @Override
    public String toString() {
        return "Jatekos{" + "nev=" + nev + ", eletEro=" + eletEro + ", sebzes=" + sebzes + ", mezo=" + mezo + '}';
    }

    public int sebzes() {
        System.out.println(nev + " sebzése: " + sebzes);
        return sebzes;
    }

    //ezt használja
    public void lep() {
        int ujMezo = RND.nextInt(3);  // 0, 1 vagy 2
        int regMezo = this.mezo;
        this.mezo = ujMezo;
        System.out.println(nev + " lép: " + regMezo + " -> " + ujMezo);//ez mikor írodik ki?
    }

    public String eletInfo() {
        return " | ❤️ " + Math.max(0, getEletEro()) + " | ";
    }

    //Félkész, műkődése mint az eletInfo
    public String sebzesInfo() {
        return "| ️🤺 " + getSebzes() + " |";
    }

}//class
