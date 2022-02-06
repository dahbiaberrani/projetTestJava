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
    public void nouvelArret(Bus bus, int numeroArret) throws IllegalArgumentException {
        if (this.getDestination() < bus.getNumeroArret()) {
            throw new IllegalArgumentException("Arrêt a dépasser la destination");
        }
        if (bus.getNumeroArret() == this.getDestination()) {
            bus.demanderSortie(this);
        }
    }

    @Override
    public void monterDans(Transport t) throws UsagerInvalideException {
        if (t instanceof Bus bus) {
            if (bus.aPlaceAssise()) {
                bus.demanderPlaceAssise(this);
            } else {
                if (bus.aPlaceDebout()) {
                    bus.demanderPlaceDebout(this);
                }
            }
        } else {
            throw new UsagerInvalideException("Le passager n'est pas dans un bus");
        }
    }

}