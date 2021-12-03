package tec;

/** class Autobus iplement l'interface Bus
 * un autobus a un nombre déterminer de place assises et debouts et sont fixer à l'instanciation d'un autobus
 * @author Dahbia BERRANI
 */
public class Autobus implements Bus, Transport{
    private int numeroArret;
    private Passager listePassager [];
    private jaugeNaturel nbPlaceDebout;
    private jaugeNaturel nbPlaceAssises;

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

    }

    /**
     * Change un passager d'une place assise vers une place debout.
     * Elle change l'état du passager.
     * @param p le passager avec un état assis.
     */
    public void demanderPlaceDebout(Passager p){

    }


    /**
     * Change un passager d'une place assise vers une place debout.
     * Elle change l'état du passager.
     * @param p le passager avec un état assis.
     */

    public void demanderChangerEnDebout(Passager p){

    }


    /**
     * Change un passager d'une place debout vers une place assise.
     * Elle change l'état du passager.
     * @param p le passager avec un état debout.
     */
    public void demanderChangerEnAssis(Passager p){

    }

    /**
     * Fait sortir un passager du bus.
     * Elle change l'état du passager.
     * @param p le passager avec un état soit assis soit debout.
     */

    public void demanderSortie(Passager p){

    }

    @Override
    public void allerArretSuivant() throws UsagerInvalideException {

    }
}
