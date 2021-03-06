package tec;

class FauxPassager extends Passager {
  static final byte DEHORS = 0;
  static final byte ASSIS  = 1;
  static final byte DEBOUT = 2;
  byte status = DEHORS;

  String message ="???";

   public String nom() {
    return null;
  }

  @Override
  public void monterDans(Transport t) throws UsagerInvalideException {
      message = ":Monter dasn le transport:";
  }

  public boolean estDehors() {
    return status == DEHORS;
  }
  
   public boolean estAssis() {
    return status == ASSIS;
  }
  
   public boolean estDebout() {
    return status == DEBOUT;
  }

   public void accepterSortie() {
    message = ":accepterSortie:";
  }

   public void accepterPlaceAssise() {
    message = ":accepterPlaceAssise:";
  }

   public void accepterPlaceDebout() {

    message = ":accepterPlaceDebout:";
  }

  public void nouvelArret(Bus b, int numeroArret) {
    message = ":nouvelArret " + numeroArret + ":";
  }
}
