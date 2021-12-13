package tec;

import java.util.ArrayList;

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
    private ArrayList<Passager> mesPassagers;
    private jaugeNaturel nbPlaceDebout;
    private jaugeNaturel nbPlaceAssises;
    private int numeroArret;

    public Autobus(int nAssises ,  int nDebout ) {
        this.nbPlaceDebout = new jaugeNaturel(0,nDebout,nDebout);
        this.nbPlaceAssises = new jaugeNaturel(0,nAssises,nAssises);
        this.numeroArret = 0;
        this.mesPassagers = new ArrayList<Passager>();

    }

    /**
     * vrai s'il existe des places assises.
     * @return vrai s'il existe des places assises
     */

    public boolean aPlaceAssise(){
        return this.nbPlaceAssises.estVert();
    }

    /**
     * vrai s'il existe des places debouts.
     * @return vrai s'il existe des places debouts
     */

    public boolean aPlaceDebout(){

        return this.nbPlaceDebout.estVert();
    }

    /**
     * Le passager entre dans ce bus en demandant une place debout.
     * L'état du passager est forcément dehors.
     * Cette méthode est appelée par passager.
     * Elle change l'état du passager.
     * @param p le passager
     */

    public void demanderPlaceAssise(Passager p){
        this.nbPlaceAssises.incrementer();
        p.accepterPlaceAssise();
        this.mesPassagers.add(p);
    }

    /**
     * Le passager entre dans ce bus en demandant une place debout.
     * L'état du passager est forcément dehors.
     * Cette méthode est appelée par passager.
     * Elle change l'état du passager.
     * @param p le passager
     */

    public void demanderPlaceDebout(Passager p){
        this.mesPassagers.add(p);
        this.nbPlaceDebout.incrementer();
        p.accepterPlaceDebout();

    }

    /**
     * Change un passager d'une place assise vers une place debout.
     * Elle change l'état du passager.
     * @param p le passager avec un état assis.
     */

    public void demanderChangerEnDebout(Passager p){
        this.nbPlaceDebout.incrementer();
        this.nbPlaceAssises.decrementer();
        p.accepterPlaceDebout();
    }

    /**
     * Change un passager d'une place debout vers une place assise.
     * Elle change l'état du passager.
     * @param p le passager avec un état debout.
     */

    public void demanderChangerEnAssis(Passager p){
        this.nbPlaceAssises.incrementer();
        this.nbPlaceDebout.decrementer();
        p.accepterPlaceAssise();
    }

    /**
     * Fait sortir un passager du bus.
     * Elle change l'état du passager.
     * @param p le passager avec un état soit assis soit debout.
     */

    public void demanderSortie(Passager p){
        p.accepterSortie();
        this.mesPassagers.remove(p);
        if (p.estAssis()) {
            this.nbPlaceAssises.decrementer();
        }
        if (p.estDebout()) {
            this.nbPlaceDebout.decrementer();
        }
    }

    /**
     * Indique au tranport de simuler l'arrêt suivant.
     *
     * @throws si l'état du l'usager est incohérent par rapport à sa demande.
     */

    @Override
    public void allerArretSuivant() throws UsagerInvalideException {
        this.numeroArret = numeroArret+1;
    }

    @Override
    public String toString() {
        return "[ arret:" + this.numeroArret + ", assis:" + this.nbPlaceAssises + ", debout:" + this.nbPlaceDebout + "]";
    }
}
