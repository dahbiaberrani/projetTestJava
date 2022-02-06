package tec;

/**
 * class PassagerStandard implement Usager et Passager
 *
 * @author Matteo MUNOZ
 */

public abstract class PassagerAbstrait extends Passager implements Usager {
    private EtatPassager etat;
    private String nom;
    private int destination;

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
    public void nouvelArret(Bus bus, int numeroArret) throws IllegalArgumentException{
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

    public abstract void choixPlaceMontee(Bus b);

    public abstract void choixChangerPlace(Bus b, int numeroArret);

    @Override
    public String toString() {
        return nom + " " + etat.toString();
    }
}