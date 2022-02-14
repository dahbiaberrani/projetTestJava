/* Si aucun paquetage n'est defini, la classe appartient au paquetage anonyme.
   Le nom du repertoire n'est pas impose */

/*
 * L'instruction import evite de specifier a chaque fois le nom
 * complet de la classe (par exemple tec.Usager).
 * La classe (ou l'interface) peut etre designee simplement par son nom
 * (ici Usager).
 */


import tec.*;

/*
 * Exemple de programme principale avec trois PassagerStandard et un Autobus.
 */
class Simple {

  /*
   * Affiche les etats d'un usager et d'un transport.
   * Sur un parametre de type Object, la methode println()
   * utilise la methode toString().
   * La methodes toString() doit etre redefinie dans les
   * deux classes PassagerStandard et Autobus.
   */
  private static void deboguerEtat (Transport t, Usager p) {
    System.out.println(p);
    System.out.println(t);
  }

  public static void main (String[] args) throws UsagerInvalideException {
    Autobus serenity = new Autobus(5, 5);
    Sportif kaylee = new Sportif("Kaylee", 5, new Calme(new EtatCaractere(serenity)));

    serenity.allerArretSuivant();
    // debogue
    deboguerEtat(serenity, kaylee);
    System.out.println(serenity);


    kaylee.monterDans(serenity);
//    kaylee.accepterSortie();
    Usager jayne = new Fatigue("Jayne", 4, new Nerveux(new EtatCaractere(serenity)));
    jayne.monterDans(serenity);
    serenity.allerArretSuivant();
    // debogue
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);

    Usager inara = new Repos("Inara", 5, new Prudent(new EtatCaractere(serenity)));
    inara.monterDans(serenity);

    serenity.allerArretSuivant();
    // debogue
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);

    serenity.allerArretSuivant();
    // debogue
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);

    serenity.allerArretSuivant();
    // debogue
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);
  }
}

/* Resultat de l'execution.
[arret:1, assis:0, debout:0]
[arret:2, assis:1, debout:1]
Kaylee assis
Jayne debout
[arret:3, assis:1, debout:2]
Kaylee assis
Jayne debout
Inara debout
[arret:4, assis:1, debout:1]
Kaylee assis
Jayne dehors
Inara debout
[arret:5, assis:0, debout:0]
Kaylee dehors
Jayne dehors
Inara dehors
*/