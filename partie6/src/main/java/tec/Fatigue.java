package tec;

public class Fatigue extends PassagerAbstrait {

    public Fatigue(String string, int i, CaracterePassager caractere) {
        super(string, i, caractere);
    }

    @Override
    public void choixPlaceMontee(Bus b) throws UsagerInvalideException {
        if (b.aPlaceAssise() && b.aPlaceDebout()) {
            b.demanderPlaceAssise(this);
        } else {
            throw new UsagerInvalideException("Pas de place assise pour un passager stressé");
        }
    }
}
