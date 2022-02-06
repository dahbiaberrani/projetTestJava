package tec;

import java.util.ArrayList;
import java.util.List;

/** class Autobus iplement l'interface Bus
 * un autobus a un nombre déterminer de place assises et debouts et sont fixer à l'instanciation d'un autobus
 * @author Dahbia BERRANI
 */

public class Autobus extends  Bus {

    /** on declare 3 attributs de la classe autobus:
     * listePassager: lorsque en appel la methode monterDans() en ajoute ce passager à cette liste.
     *nbPlaceDebout: est declarer à la creation de Autobus
     * nbPlaceAssises: est declarer à la creation de Autobus
     */

    private jaugeNaturel nbPlaceDebout;
    private jaugeNaturel nbPlaceAssises;
    private int numeroArret;
    private List<Passager> passagers;
    private List<Passager> passagersASuprimmer;

    public Autobus(int nAssises ,  int nDebout ) {
        this.nbPlaceDebout = new jaugeNaturel(0,nDebout, 0);
        this.nbPlaceAssises = new jaugeNaturel(0,nAssises, 0);
        this.numeroArret = 0;
        this.passagers = new ArrayList<Passager>();
        this.passagersASuprimmer = new ArrayList<Passager>();
    }
    public Autobus(int nbPlace ) {
        this(nbPlace,nbPlace);
    }

    /**
     * vrai s'il existe des places assises.
     * @return vrai s'il existe des places assises
     */
    @Override
    public boolean aPlaceAssise(){

        return !this.nbPlaceAssises.estRouge();
    }

    /**
     * vrai s'il existe des places debouts.
     * @return vrai s'il existe des places debouts
     */

    @Override
    public boolean aPlaceDebout(){
        return !this.nbPlaceDebout.estRouge();
    }

    /**
     * Le passager entre dans ce bus en demandant une place debout.
     * L'état du passager est forcément dehors.
     * Cette méthode est appelée par passager.
     * Elle change l'état du passager.
     * @param p le passager
     */
    @Override
    public void demanderPlaceAssise(Passager p) {
        if (! p.estDehors() || !aPlaceAssise()) {
             throw new IllegalArgumentException("le passager n'est pas dehors ou y a plus d places assises");
        }
        this.nbPlaceAssises.incrementer();
        p.accepterPlaceAssise();
        this.passagers.add(p);

    }

    /**
     * Le passager entre dans ce bus en demandant une place debout.
     * L'état du passager est forcément dehors.
     * Cette méthode est appelée par passager.
     * Elle change l'état du passager.
     * @param p le passager
     */

    @Override
    public void demanderPlaceDebout(Passager p){
        if(!p.estDehors() || !this.aPlaceDebout()) {
            throw new IllegalArgumentException("le passager n'est pas dehors");
        }
        this.passagers.add(p);
        this.nbPlaceDebout.incrementer();
        p.accepterPlaceDebout();
    }

    /**
     * Change un passager d'une place assise vers une place debout.
     * Elle change l'état du passager.
     * @param p le passager avec un état assis.
     */

    @Override
    public void demanderChangerEnDebout(Passager p){
        if (p.estDebout() || !this.aPlaceDebout()) {
            throw new IllegalArgumentException("le passager est déja debout ou il n'y a plus de places debout");
        }
        this.nbPlaceAssises.decrementer();
        this.nbPlaceDebout.incrementer();
        p.accepterPlaceDebout();
    }

    /**
     * Change un passager d'une place debout vers une place assise.
     * Elle change l'état du passager.
     * @param p le passager avec un état debout.
     */
    @Override
    public void demanderChangerEnAssis(Passager p){
        if (p.estAssis() || !this.aPlaceAssise()) {
            throw new IllegalArgumentException("le passager est déja assis ou debout");
        }
        this.nbPlaceAssises.decrementer();
        this.nbPlaceDebout.incrementer();
        p.accepterPlaceAssise();
    }

    /**
     * Fait sortir un passager du bus.
     * Elle change l'état du passager.
     * @param p le passager avec un état soit assis soit debout.
     */
    @Override
    public void demanderSortie(Passager p){
        if (p.estAssis()) {
            this.nbPlaceAssises.decrementer();
        }
        if (p.estDebout()) {
            this.nbPlaceDebout.decrementer();
        }
        p.accepterSortie();
        passagersASuprimmer.add(p);
    }

    /**
     * Indique au tranport de simuler l'arrêt suivant.
     *
     * @throws  UsagerInvalideException si l'état du l'usager est incohérent par rapport à sa demande.
     */

    @Override
    public void allerArretSuivant() throws UsagerInvalideException {
        this.numeroArret++;
        for (Passager p : passagers) {
            try {
                p.nouvelArret(this, numeroArret);
            } catch (IllegalArgumentException e) {
                throw new UsagerInvalideException("problème usager invalide");
            }
        }
        for (Passager p : passagersASuprimmer) {
            this.passagers.remove(p);
        }
        this.passagersASuprimmer.clear();
    }

    @Override
    public String toString() {
        return ("[ arret:" + this.numeroArret + ", assis:" + this.nbPlaceAssises.toString() + ", debout:" + this.nbPlaceDebout.toString() + "]");
    }

    public int getNumeroArret() {
        return numeroArret;
    }
}
