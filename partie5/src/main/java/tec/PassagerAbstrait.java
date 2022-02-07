package tec;

/**
 * class PassagerStandard implement Usager et Passager
 *
 * @author Matteo MUNOZ and Dahbia BERRANI
 */

public abstract class PassagerAbstrait implements Passager, Usager {
    private final EtatPassager etat;
    private final String nom;
    private final int destination;

    protected PassagerAbstrait(String string, int i) {
        etat = new EtatPassager(EtatPassager.Etat.DEHORS);
        this.nom = string;
        this.destination = i;
    }

    @Override
    public boolean estDehors() {
        return etat.estExterieur();
    }

    @Override
    public boolean estAssis() {
        return etat.estAssis();
    }

    @Override
    public boolean estDebout() {
        return etat.estDebout();
    }

    @Override
    public void accepterSortie() {
        etat.setEtat(EtatPassager.Etat.DEHORS);
    }

    @Override
    public void accepterPlaceAssise() {
        etat.setEtat(EtatPassager.Etat.ASSIS);
    }

    @Override
    public void accepterPlaceDebout() {
        etat.setEtat(EtatPassager.Etat.DEBOUT);
    }

    @Override
    public void nouvelArret(Bus bus, int numeroArret) throws IllegalArgumentException, UsagerInvalideException {
        if (this.destination < numeroArret) {
            throw new IllegalArgumentException("Arrêt a dépasser la destination");
        }
        choixChangerPlace(bus, numeroArret);
    }

    public int getDestination() {
        return destination;
    }

    @Override
    public String nom() {
        return nom;
    }

    @Override
    public void monterDans(Transport t) throws UsagerInvalideException {
        if (t instanceof Autobus autobus) {
            choixPlaceMontee(autobus);
        }
    }

    public abstract void choixPlaceMontee(Bus b) throws UsagerInvalideException;

    public abstract void choixChangerPlace(Bus b, int numeroArret) throws UsagerInvalideException;

    @Override
    public String toString() {
        return nom + " " + etat.toString();
    }
}
