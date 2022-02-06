package tec;

/**
 * class PassagerStandard implement Usager et Passager
 *
 * @author Matteo MUNOZ
 */

public class PassagerLunatique extends PassagerAbstrait {

    public PassagerLunatique(String string, int i) {
        super(string, i);
    }

    @Override
    public void choixPlaceMontee(Bus b) {
        if (b.aPlaceDebout()) {
            b.demanderPlaceDebout(this);
        }
    }

    @Override
    public void choixChangerPlace(Bus b, int numeroArret) {
        if (this.getDestination() == b.getNumeroArret()) {
            b.demanderSortie(this);
            this.accepterSortie();
        } else if (estAssis()) {
            if (b.aPlaceDebout()) {
                b.demanderChangerEnDebout(this);
            } else try {
                throw new UsagerInvalideException("Usager Lunatique n'as pas pu se lever");
            } catch (UsagerInvalideException e) {
                e.printStackTrace();
            }
        } else if (b.aPlaceAssise()) {
            b.demanderChangerEnAssis(this);
        } else try {
            throw new UsagerInvalideException("Usager Lunatique n'as pas pu s'assoir");
        } catch (UsagerInvalideException e) {
            e.printStackTrace();
        }

    }

}