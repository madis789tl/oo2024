import java.util.Random;

public class Mangija {
    int xCoord; // deklareerin (loob + mälukoht)
    int yCoord; // parem klõps tema peal -> refactor -> rename
    char symbol;

    public Mangija(Random random, int kaardiKorgus, int kaardiLaius) {
        xCoord = saaKoordinaat(random, kaardiLaius); // initsialiseerin (annan esimest korda väärtuse)
        yCoord = saaKoordinaat(random, kaardiKorgus);
        symbol = 'x';
    }

    public void liigu(String sisend) {
        switch (sisend) {
            case "w" -> yCoord--;
            case "s" -> yCoord++;
            case "a" -> xCoord--;
            case "d" -> xCoord++;
        } // switch() kinniminek
    } // liigu() kinniminek

    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
} // <-- Mangija kinniminek
