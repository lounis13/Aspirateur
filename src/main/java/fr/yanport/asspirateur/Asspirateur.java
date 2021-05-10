package fr.yanport.asspirateur;

/**
 * Classe Asspirateur : contient les informations d’un aspirateur et les méthodes.
 */
public class Asspirateur{

    /* Position x de l'asspirateur */
    private int positionX;

    /* Position Y de l'asspirateur */
    private int positionY;

    /* Orientation */
    private Orientation orientation;

    /**
     * Constructeur pour créer un asspirateur.
     *
     * @param positionX   position initial x
     * @param positionY   position initial y
     * @param orientation Orientation initial
     */
    public Asspirateur (int positionX, int positionY, Orientation orientation) {
        this.positionX   = positionX;
        this.positionY   = positionY;
        this.orientation = orientation;
    }

    /* ********************************* */
    /* *           GETTERS               */
    /* ********************************* */

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    /* ********************************* */
    /* *           Methodes              */
    /* ********************************* */

    /**
     * Déplacer (avancer) l'aspirateur vers la droite(+1) / gauche(-1).
     *
     * @param value -1 gauche +1 droite
     */
    public void avanceX (int value) {
        this.positionX += value;
    }

    /**
     * Déplacer (avancer) l'aspirateur vers le Haut(+1) / Bas(-1).
     *
     * @param value -1 haut +1 bas
     */
    public void avanceY (int value) {
        this.positionY += value;
    }

    /**
     * pivoter l’aspirateur vers la gauche.
     */
    public void aGauche() {
        this.orientation = Orientation.values()[(orientation.ordinal() + 3) %4];
    }

    /**
     * pivoter l’aspirateur vers la droite
     */
    public void aDroite() {
        this.orientation = Orientation.values()[(orientation.ordinal() + 1) %4];
    }


    @Override
    public String toString() {
        return "Asspirateur{" +
                "positionX=" + positionX +
                ", positionY=" + positionY +
                ", orientation=" + orientation +
                '}';
    }
}
