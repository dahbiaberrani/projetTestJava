/**
 * *
 *
 * @author Dahbia BERRANI and Matteo MUNOZ
 */

package tec;

public class FauxBusDebout {
  String message = "???";

  boolean aPlaceAssise() {
    return false;
  }

  boolean aPlaceDebout() {
    return true;
  }

  void demanderPlaceAssise() {
    message = ":demanderPlaceAssise:";
  }

  void demanderPlaceDebout(Passager p) {
    message = ":demanderPlaceDebout:";
    p.accepterPlaceDebout();
  }

  void demanderChangerEnDebout(Passager p) {
    message = ":demanderChangerEnDebout:";
    p.accepterPlaceDebout();
  }
  
  void demanderChangerEnAssis() {
    message = ":demanderChangerEnAssis:";
  }

  void demanderSortie(Passager p) {
    message = ":demanderSortie:";    
    p.accepterSortie();
  }
}
