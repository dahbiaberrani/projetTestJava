package tec;

/**
 * Cette interface définit le type manipule par le programme principal.
 * <p>
 * Un bus a un nombre de places assises et de places debouts.
 * <p>
 * Un Transport voyage d'arrêt en arrêt, il prévient ses passagers de chaque
 * nouvel arrêt.
 */
public interface Transport {

  /**
   * Indique au tranport de simuler l'arrêt suivant.
   *
   * @throws UsagerInvalideException si l'état du l'usager est incohérent par rapport à sa demande.
   */
  public void allerArretSuivant() throws UsagerInvalideException;
}

