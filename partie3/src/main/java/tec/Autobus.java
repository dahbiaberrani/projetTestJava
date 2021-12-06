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

    public Autobus(int nbPlaceDebout, int nbPlaceAssises) {
    }

    /**
     * vrai s'il existe des places assises.
     * @return vrai s'il existe des places assises
     */

    public boolean aPlaceAssise(){
        return false;
    }

    /**
     * vrai s'il existe des places debouts.
     * @return vrai s'il existe des places debouts
     */

    public boolean aPlaceDebout(){
        return false;
    }

    /**
     * Le passager entre dans ce bus en demandant une place debout.
     * L'état du passager est forcément dehors.
     * Cette méthode est appelée par passager.
     * Elle change l'état du passager.
     * @param p le passager
     */

    public void demanderPlaceAssise(Passager p){
//        this.mesPassagers.add(p);
//        this.nbPlaceAssises.incrementer();
    }

    /**
     * Le passager entre dans ce bus en demandant une place debout.
     * L'état du passager est forcément dehors.
     * Cette méthode est appelée par passager.
     * Elle change l'état du passager.
     * @param p le passager
     */

    public void demanderPlaceDebout(Passager p){
//        this.mesPassagers.add(p);
//        this.nbPlaceDebout.incrementer();

    }

    /**
     * Change un passager d'une place assise vers une place debout.
     * Elle change l'état du passager.
     * @param p le passager avec un état assis.
     */

    public void demanderChangerEnDebout(Passager p){
//        this.nbPlaceDebout.incrementer();
//        this.nbPlaceAssises.decrementer();
    }

    /**
     * Change un passager d'une place debout vers une place assise.
     * Elle change l'état du passager.
     * @param p le passager avec un état debout.
     */

    public void demanderChangerEnAssis(Passager p){
//        this.nbPlaceAssises.incrementer();
//        this.nbPlaceDebout.decrementer();
    }

    /**
     * Fait sortir un passager du bus.
     * Elle change l'état du passager.
     * @param p le passager avec un état soit assis soit debout.
     */

    public void demanderSortie(Passager p){
    }

    /**
     * Indique au tranport de simuler l'arrêt suivant.
     *
     * @throws si l'état du l'usager est incohérent par rapport à sa demande.
     */

    @Override
    public void allerArretSuivant() throws UsagerInvalideException {
    }

    @Override
    public String toString() {
        return "[ arret:" + this.numeroArret + ", assis:" + this.nbPlaceAssises + ", debout:" + this.nbPlaceDebout + "]";
    }
}
