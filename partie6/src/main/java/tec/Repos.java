/**
 * *
 *
 * @author Dahbia BERRANI and Matteo MUNOZ
 */

package tec;

public class Repos extends PassagerAbstrait {
    public Repos(String string, int i, CaracterePassager caractere) {
        super(string, i, caractere);
    }

    @Override
    public void choixPlaceMontee(Bus b) throws UsagerInvalideException {
        if (b.aPlaceAssise()) {
            b.demanderPlaceAssise(this);
        } else {
            if (b.aPlaceDebout()) {
                b.demanderPlaceDebout(this);
            } else {
                throw new UsagerInvalideException("Usager  n'a pas pu monter car aucune place n'est disponible");
            }
        }
    }
}
