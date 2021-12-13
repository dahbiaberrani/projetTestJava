package tec;

import java.util.ArrayList;
import java.util.List;

/** class Autobus iplement l'interface Bus
 * un autobus a un nombre déterminer de place assises et debouts et sont fixer à l'instanciation d'un autobus
 * @author Dahbia BERRANI
 */

public class Autobus<PassagerAbstract> implements Bus, Transport{

    /** on declare 3 attributs de la classe autobus:
     * listePassager: lorsque en appel la methode monterDans() en ajoute ce passager à cette liste.
     *nbPlaceDebout: est declarer à la creation de Autobus
     * nbPlaceAssises: est declarer à la creation de Autobus
     */

    private jaugeNaturel nbPlaceDebout;
    private jaugeNaturel nbPlaceAssises;
    private int numeroArret;
    private List<Passager> passagers;

    public Autobus(int nAssises ,  int nDebout ) {
        this.nbPlaceDebout = new jaugeNaturel(0,nDebout, 0);
        this.nbPlaceAssises = new jaugeNaturel(0,nAssises, 0);
        this.numeroArret = 0;
        this.passagers = new ArrayList<Passager>();

    }

    /**
     * vrai s'il existe des places assises.
     * @return vrai s'il existe des places assises
     */

    public boolean aPlaceAssise(){

        return !this.nbPlaceAssises.estRouge();
    }

    /**
     * vrai s'il existe des places debouts.
     * @return vrai s'il existe des places debouts
     */

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

    public void demanderPlaceAssise(Passager p){
        if (aPlaceAssise() && p.estDehors()) {
            this.nbPlaceAssises.incrementer();
            p.accepterPlaceAssise();
            this.passagers.add(p);
        }
    }

    /**
     * Le passager entre dans ce bus en demandant une place debout.
     * L'état du passager est forcément dehors.
     * Cette méthode est appelée par passager.
     * Elle change l'état du passager.
     * @param p le passager
     */

    public void demanderPlaceDebout(Passager p){
        if(p.estDehors() && this.aPlaceDebout()) {
            this.passagers.add(p);
            this.nbPlaceDebout.incrementer();
            p.accepterPlaceDebout();
        }
    }

    /**
     * Change un passager d'une place assise vers une place debout.
     * Elle change l'état du passager.
     * @param p le passager avec un état assis.
     */

    public void demanderChangerEnDebout(Passager p){
        if (p.estAssis() && this.aPlaceDebout()) {
            this.nbPlaceAssises.decrementer();
            this.nbPlaceDebout.incrementer();
            p.accepterPlaceDebout();
        }
    }

    /**
     * Change un passager d'une place debout vers une place assise.
     * Elle change l'état du passager.
     * @param p le passager avec un état debout.
     */

    public void demanderChangerEnAssis(Passager p){
        if (p.estDebout() && this.aPlaceAssise()) {
            this.nbPlaceAssises.decrementer();
            this.nbPlaceDebout.incrementer();
            p.accepterPlaceAssise();
        }
    }

    /**
     * Fait sortir un passager du bus.
     * Elle change l'état du passager.
     * @param p le passager avec un état soit assis soit debout.
     */

    public void demanderSortie(Passager p){
        if (p.estAssis()) {
            this.nbPlaceAssises.decrementer();
        }
        if (p.estDebout()) {
            this.nbPlaceDebout.decrementer();
        }
        p.accepterSortie();
        this.passagers.remove(p);
    }

    /**
     * Indique au tranport de simuler l'arrêt suivant.
     *
     * @throws  si l'état du l'usager est incohérent par rapport à sa demande.
     */

    @Override
    public void allerArretSuivant() throws UsagerInvalideException {
        this.numeroArret++;
//        for (Passager i : passagers) {
        for (int i = 0; i < passagers.size(); i++) {
            this.passagers.get(i).nouvelArret(this, numeroArret);
        }
    }

    @Override
    public String toString() {
        return ("[ arret:" + this.numeroArret + ", assis:" + this.nbPlaceAssises.toString() + ", debout:" + this.nbPlaceDebout.toString() + "]");
    }
}
