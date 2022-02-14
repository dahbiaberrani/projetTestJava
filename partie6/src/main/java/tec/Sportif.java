/**
 * *
 *
 * @author Dahbia BERRANI and Matteo MUNOZ
 */

package tec;

public class Sportif extends PassagerAbstrait {
    public Sportif(String string, int i, CaracterePassager caractere) {
        super(string, i, caractere);
    }

    @Override
    public void choixPlaceMontee(Bus b) throws UsagerInvalideException {
        if (b.aPlaceDebout()) {
            b.demanderPlaceDebout(this);
        } else {
            if (b.aPlaceAssise()) {
                b.demanderPlaceAssise(this);
            } else {
                throw new UsagerInvalideException("Pas de place debout ni assise pour un passager Sportif");
            }
        }
    }
}
