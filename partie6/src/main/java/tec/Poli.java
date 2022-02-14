package tec;

public class Poli extends CaractereAbstrait {
    public Poli(EtatCaractere etatCaractere) {
        super(etatCaractere);
    }

    @Override
    public void choixChangerPlace(int numeroArret) {
        Bus b = this.etatCaractere.getBus();
        PassagerAbstrait passager = this.etatCaractere.getPassager();
        if (passager.getDestination() == b.getNumeroArret()) {
            b.demanderSortie(passager);
            passager.accepterSortie();
        } else if (passager.estAssis()) {
            if (!b.aPlaceAssise()) {
                b.demanderChangerEnDebout(passager);
            }
        }
    }
}
