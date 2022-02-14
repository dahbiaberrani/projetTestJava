package tec;

public class Nerveux extends CaractereAbstrait {
    public Nerveux(EtatCaractere etatCaractere) {
        super(etatCaractere);
    }

    @Override
    public void choixChangerPlace(int numeroArret) throws UsagerInvalideException {
        Bus b = this.etatCaractere.getBus();
        PassagerAbstrait passager = this.etatCaractere.getPassager();

        if (passager.getDestination() == b.getNumeroArret()) {
            b.demanderSortie(passager);
            passager.accepterSortie();
        } else if (passager.estAssis()) {
            if (b.aPlaceDebout()) {
                b.demanderChangerEnDebout(passager);
            } else {
                throw new UsagerInvalideException("Usager Lunatique n'as pas pu se lever");
            }
        } else if (b.aPlaceAssise()) {
            b.demanderChangerEnAssis(passager);
        } else  {
            throw new UsagerInvalideException("Usager Lunatique n'as pas pu s'assoir");
        }
    }
}
