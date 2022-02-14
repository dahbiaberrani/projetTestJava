package tec;

/**
 * class PassagerStandard implement Usager et Passager
 *
 * @author Matteo MUNOZ and Dahbia BERRANI
 */

public abstract class PassagerAbstrait extends Passager implements  Usager {
    private final EtatPassager etat;
    private final String nom;
    private final int destination;
    private  CaracterePassager caractere;

    protected PassagerAbstrait(String string, int i, CaracterePassager caractere) {
        etat = new EtatPassager(EtatPassager.Etat.DEHORS);
        this.nom = string;
        this.destination = i;
        this.caractere = caractere;
        this.caractere.getEtatCaractere().setPassagee(this);
    }

    @Override
    boolean estDehors() {
        return etat.estExterieur();
    }

    @Override
    boolean estAssis() {
        return etat.estAssis();
    }

    @Override
    boolean estDebout() {
        return etat.estDebout();
    }

    @Override
    void accepterSortie() {
        etat.setEtat(EtatPassager.Etat.DEHORS);
    }

   @Override
    void accepterPlaceAssise() {
        etat.setEtat(EtatPassager.Etat.ASSIS);
    }

    @Override
    void accepterPlaceDebout() {
        etat.setEtat(EtatPassager.Etat.DEBOUT);
    }

    @Override
    void nouvelArret(Bus bus, int numeroArret) throws IllegalArgumentException, UsagerInvalideException {
        if (this.destination < numeroArret) {
            throw new IllegalArgumentException("Arrêt a dépasser la destination");
        }
        choixChangerPlace(numeroArret);
    }

    int getDestination() {
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

    abstract void choixPlaceMontee(Bus b) throws UsagerInvalideException;

    void choixChangerPlace(int numeroArret) throws UsagerInvalideException {
        this.caractere.choixChangerPlace(numeroArret);
    }

    @Override
    public String toString() {
        return nom + " " + etat.toString();
    }
}
