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
    public void nouvelArret(Bus bus, int numeroArret) {
        if (numeroArret == this.destination) {
            bus.demanderChangerEnDebout(this);
            bus.demanderSortie(this);
        }
        if (this.estAssis()) {
            bus.demanderPlaceDebout(this);
            bus.demanderSortie(this);
        }
    }

    @Override
    public String nom() {
        return nom;
    }

    @Override
    public void monterDans(Transport t) throws UsagerInvalideException {
        if (t instanceof Bus bus) {
            bus.demanderPlaceAssise(this);
        } else {
            throw new UsagerInvalideException("Le passager n'est pas dans un bus");
        }
    }

    @Override
    public String toString() {
        return nom + " " + etat.toString();
    }
}