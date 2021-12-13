package tec;

/**
 * class PassagerStandard implement Usager et Passager
 *
 * @author Matteo MUNOZ
 */

public class PassagerStandard implements Usager, Passager {
    private EtatPassager etat;
    private String nom;
    private int destination;

    public PassagerStandard(String string, int i) {
        etat = new EtatPassager(EtatPassager.Etat.DEHORS);
        this.nom = string;
        this.destination = i;
    }

    @Override
    public boolean estDehors() {
        return false;
    }

    @Override
    public boolean estAssis() {
        return false;
    }

    @Override
    public boolean estDebout() {
        return false;
    }

    @Override
    public void accepterSortie() {
    }

    @Override
    public void accepterPlaceAssise() {

    }

    @Override
    public void accepterPlaceDebout() {

    }

    @Override
    public void nouvelArret(Bus bus, int numeroArret) {

    }

    @Override
    public String nom() {
        return null;
    }

    @Override
    public void monterDans(Transport t) throws UsagerInvalideException {

    }

    @Override
    public String toString() {
        return nom + " " + etat.toString();
    }
}