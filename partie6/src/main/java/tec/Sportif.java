package tec;

public class Sportif extends PassagerAbstrait {
    public Sportif(String string, int i, CaracterePassager caractere) {
        super(string, i, caractere);
    }

    @Override
    public void choixPlaceMontee(Bus b) throws UsagerInvalideException {
        if (b.aPlaceDebout()) {
            b.demanderPlaceDebout(this);
        } else {
            throw new UsagerInvalideException("Pas de place debout pour un passager lunatique");
        }
    }
}
