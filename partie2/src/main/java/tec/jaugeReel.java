package tec;

/**
 * Réalisation d'une Jauge avec des entiers naturels.
 * <p>
 * Un objet Jauge définit un niveau et un intervalle ouvert ]vigieMin, vigieMax[.
 * Le niveau d'une jauge n'est pas limité aux valeurs dans l'intervalle.
 * <p>
 * L'état d'une jauge correspond à la position de son niveau par rapport à
 * l'intervalle ]vigieMin, vigieMax[.
 * Une jauge définit trois etats :
 * <ul>
 * <li>vert niveau dans l'intervalle,
 * <li>rouge niveau supérieur à l'intervalle,
 * <li>bleu niveau inférieur à l'intervalle.
 * </ul>
 *
 */
public class jaugeReel implements Ijauge{
    private float valeur;
    private final float min;
    private final float max;

    /**
     * Construit une instance en précisant la valeur de départ de la Jauge
     * et l'intervalle de vigie.
     *
     * @param vigieMin valeur minimale de l'intervalle de vigie.
     * @param vigieMax valeur maximale de l'intervalle de vigie.
     * @param depart   valeur initiale de la jauge.
     */
    public jaugeReel(float vigieMin, float vigieMax, float depart) {
        valeur = depart/1000;
        min = vigieMin/1000;
        max = vigieMax/1000;
        /* Le constructeur d'une classe permet d'initialiser l'etat de l'instance creee.
         * Son nom correspond toujours au nom de la classe. Il n'y a pas de type de retour.
         */
    }


    /**
     * L'état de la jauge est-il rouge ?
     *
     * @return vrai si niveau >=  vigieMax.
     *
     */
    public boolean estRouge() {
        return valeur >= max;
    }

    /**
     * L'état de la jauge est-il vert ?
     *
     * @return vrai si niveau appartient à ]vigieMin, vigieMax[.
     *
     */
    public boolean estVert() {
        return valeur > min && valeur < max;
    }

    /**
     * L'état de la jauge est-il bleu ?
     *
     * @return vrai si niveau <= vigieMin.
     */
    public boolean estBleu() {
        return  valeur <= min;
    }

    /**
     * Incrémente le niveau d'une unité.
     * L'état peut devenir supérieur à vigieMax.
     */
    public void incrementer() {
        valeur += 0.001;
    }

    /**
     * Décrémente le niveau d'une unité.
     * L'état peut devenir inférieur à la vigieMin.
     */
    public void decrementer() {
        valeur -= 0.001;
    }


    /**
     * Cette méthode est héritée de la classe {@link Object}.
     * Très utile pour le débogage, elle permet de fournir une
     * chaîne de caractères correspondant a l'état d'un objet.
     * <p> Un code par défaut est définit dans
     * {@link Object#toString() la classe Object}
     * Il faut adapter (redéfinir) le code de cette méthode à chaque classe.
     *
     * Pour les chaînes de cararctères, l'opérateur + correspond a la concaténation.
     * Les valeurs numériques sont alors convertit en ascii.
     * Si l'état d'une instance de cette classe est min=-456, max=23,
     * valeur=-7, la concaténation donne la chaîne "<-7 [-456,23]>".
     */
    @Override
    public String toString() {
        return "<" + valeur + " [" + min + "," + max + "]>";
    }
}