
package tec;

public class FauxBus implements Bus, Transport
{
  static final byte VIDE   = 0;
  static final byte DEBOUT = 1;
  static final byte ASSIS  = 2;
  static final byte PLEIN  = 3;
  byte statut = VIDE;

  String message = "???";


	// Crée les bus pour les tests

  public static FauxBus creerVide()
	{
    return new FauxBus(VIDE);
  }

  public static FauxBus creerPlein()
	{
    return new FauxBus(PLEIN);
  }

  public static FauxBus creerAssis()
	{
    return new FauxBus(ASSIS);
  }

  public static FauxBus creerDebout()
	{
    return new FauxBus(DEBOUT);
  }


  private FauxBus(byte statut)
	{
    this.statut = statut;
  }

  public FauxBus()
  {
  }


  public boolean aPlaceAssise()
	{
    return statut == ASSIS || statut == VIDE;
  }

  public boolean aPlaceDebout()
	{
    return statut == DEBOUT || statut == VIDE;
  }

  public void demanderPlaceAssise(Passager p)
  {
    message = ":demanderPlaceAssise:";
  }

  public void demanderPlaceDebout(Passager p)
  {
    message = ":demanderPlaceDebout:";
  }

  public void demanderChangerEnDebout(Passager p)
  {
    message = ":demanderChangerEnDebout:";
  }

  public void demanderChangerEnAssis(Passager p)
  {
    message = ":demanderChangerEnAssis:";
  }

  public void demanderSortie(Passager p)
  {
    message = ":demanderSortie:";
  }

  public void allerArretSuivant() {}
}

