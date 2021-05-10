package fr.yanport.asspirateur;

/**
 * classe Grille
 *
 * @version 1.0.0.
 * @author  BOULDJA Lounis.
 **/
public class Grille {

    /*Taille de la grille*/
    private final int height;
    private final int width;

    /**
     * Constructeur pour créer et initialiser la grille.
     *
     * @param height  hauteur
     * @param width   largeur
     */
    public Grille(int height, int width) {
        this.height = height;
        this.width = width;
    }

    /******************
     *   Getters.     *
     ******************/

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
