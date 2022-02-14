package tec;

public class Tetu extends PassagerAbstrait {
    public Tetu(String string, int i, CaracterePassager caractere) {
        super(string, i, caractere);
    }

    @Override
    public void choixPlaceMontee(Bus b) throws UsagerInvalideException {
        b.demanderPlaceDebout(this);
    }
}
